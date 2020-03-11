package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Contracts;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLContractsDao;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/contracts")
public class ContractsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        Contracts contractsDao = DaoFactory.getContractsDao();
        Users userDao = DaoFactory.getUsersDao();

        User currentUser = (User) request.getSession().getAttribute("user");
        String userRole = userDao.getUserRole(currentUser.getRoleId());

        request.setAttribute("contracts", contractsDao.getContractsByRole(userRole));
        request.getRequestDispatcher("/WEB-INF/contracts/index.jsp").forward(request, response);
    }
}
