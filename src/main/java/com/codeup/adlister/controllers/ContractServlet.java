package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLContractsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try{
            switch (action){
                case "/new":
                    addNewForm(request, response);
                    break;
                case "/add":
                    addNewContract(request, response);
                    break;
                case "/delete":
                    deleteContract(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateContract(request, response);
                    break;
                default:
                    listContract(request, response);
                    break;
            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
        request.setAttribute("contracts", DaoFactory.getContractsDao().all());
        request.getRequestDispatcher("/WEB-INF/contracts/individual.jsp").forward(request, response);
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        List<Contract> contractList = MySQLContractsDao.all();
    }
}
