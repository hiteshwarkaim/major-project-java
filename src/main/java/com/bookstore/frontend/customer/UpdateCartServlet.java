/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.frontend.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateCartServlet", urlPatterns = {"/update-cart"})
public class UpdateCartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            String[] arraybookIds = request.getParameterValues("bookId");
            String[] arrayQuantites=new String[arraybookIds.length];
            
            for (int i = 1; i < arrayQuantites.length; i++) {
                String aQuantity=request.getParameter("quantity"+i);
                arrayQuantites[i-1]=aQuantity;
            }
            
            int[] bookIds=Arrays.stream(arraybookIds).mapToInt(Integer::parseInt).toArray();;
            
        }
    }
}
