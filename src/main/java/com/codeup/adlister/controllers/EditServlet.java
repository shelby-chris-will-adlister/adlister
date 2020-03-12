package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Contracts;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Contract;
import com.mysql.cj.api.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/contracts/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long toEditId = Long.parseLong(request.getParameter("id"));
        request.getSession().setAttribute("toEditID", toEditId);
        Contracts contractsDao = DaoFactory.getContractsDao();
        Contract editContract = contractsDao.getContractById(toEditId);
        request.setAttribute("contract", editContract);
        request.getRequestDispatcher("/WEB-INF/contracts/Edit.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contracts contractsDao = DaoFactory.getContractsDao();
        long tmp = (long)request.getSession().getAttribute("toEditID");
        Contract editContract = contractsDao.getContractById((long)request.getSession().getAttribute("toEditID"));
        editContract.setTitle(request.getParameter("title"));
        editContract.setDescription(request.getParameter("description"));
        editContract.setReward(Float.parseFloat(request.getParameter("reward")));
        editContract.setCountry(request.getParameter("country"));
        try {
            contractsDao.updateContract(editContract);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/profile");
    }
}
