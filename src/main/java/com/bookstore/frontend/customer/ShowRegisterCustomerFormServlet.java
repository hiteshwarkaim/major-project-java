/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.frontend.customer;

import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.Category;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShowRegisterCustomerFormServlet", urlPatterns = {"/register-customer"})
public class ShowRegisterCustomerFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
       
            CategoryDao categoryDao=new CategoryDao(DB_Connection.getConnection());
        List<Category> allCategory = categoryDao.getAllCategory();
        
        request.setAttribute("allCategory", allCategory);
        
            RequestDispatcher rd=request.getRequestDispatcher("/frontend/customer_registration.jsp");
            rd.forward(request, response);
        }
    }
}
