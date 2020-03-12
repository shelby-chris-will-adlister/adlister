package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.Contracts;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="controllers.IndividualServlet", urlPatterns = "/contract")
public class IndividualServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contracts contractsDao = DaoFactory.getContractsDao();
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.setAttribute("contract", contractsDao.getContractById(Long.parseLong(request.getParameter("id"))));

        request.getRequestDispatcher("/WEB-INF/contracts/individual.jsp").forward(request, response);
    }
}