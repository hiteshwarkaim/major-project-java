/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller.admin.category;

import com.bookstore.service.CategoryService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateCategoryServlet", urlPatterns = {"/admin/create-category"})
public class CreateCategoryServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
          //contact service to create the new user
            CategoryService service=new CategoryService(request,response);
            try {
                
                service.createCategory();
//            service.getAllUsersData("user created successfully !!!!");
               service.listCategory();

            } catch (Exception e) {
            }
        }
    }
}
