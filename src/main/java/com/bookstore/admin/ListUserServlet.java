/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.admin;

import com.bookstore.entities.User;
import com.bookstore.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListUserServlet", urlPatterns = {"/admin/list-users"})
public class ListUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            UserService service=new UserService();
            List<User> allUsersData = service.getAllUsersData();
            
            request.getSession().setAttribute("allUsersSession", allUsersData);
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(("user_list.jsp"));
            requestDispatcher.forward(request, response);
            
        }
    }
}
