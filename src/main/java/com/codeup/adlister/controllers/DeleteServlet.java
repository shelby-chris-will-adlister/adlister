package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Contracts;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Contract;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/contracts/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long toDeleteId = Long.parseLong(request.getParameter("id"));
        Contracts contractsDao = DaoFactory.getContractsDao();
        contractsDao.deleteContract(toDeleteId);
        response.sendRedirect("/profile");
    }
}