package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLContractsDao;
import com.codeup.adlister.models.Contract;
import com.codeup.adlister.util.Config;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controllers.ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    private MySQLContractsDao contractsDao;
    public void init(){
        contractsDao = new MySQLContractsDao(new Config())
    }
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

    private void addNewContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = request.getParameter("id");
        long user_id = request.getParameter("user_id");
        long role_id = request.getParameter("role_id");
        String desc = request.getParameter("description");
        String title = request.getParameter("title");
        String country = request.getParameter("country");
        float reward = request.getParameter("reward");
        Contract newContract = new Contract(id, user_id,title, desc, country,reward);
        contractsDao.insert(newContract);
        response.sendRedirect("list");
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        List<Contract> contractList = contractsDao.all();
        request.setAttribute("list", contractList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("somepage(waitingonchris).jsp");
        dispatcher.forward(request, response);
    }
}
