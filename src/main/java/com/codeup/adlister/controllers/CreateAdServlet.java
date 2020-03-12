package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Contract;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/contracts/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/contracts/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Float reward = Float.parseFloat(request.getParameter("reward"));
        User currentUser = (User) request.getSession().getAttribute("user");
        Contract contract = new Contract(
            currentUser.getId(), // for now we'll hardcode the user id
            request.getParameter("title"),
            request.getParameter("description"),
            request.getParameter("country"),
            reward
        );
        DaoFactory.getContractsDao().insert(contract);
        response.sendRedirect("/contracts");
    }
}
