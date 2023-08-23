/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller.admin.Book;

import com.bookstore.service.BookService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateBookServlet", urlPatterns = {"/admin/create-book"})
@MultipartConfig(
        fileSizeThreshold = 1024*10,    //10kb
        maxFileSize = 1024*300,         //300kb
        maxRequestSize = 1024*1024         //1MB
    )
public class CreateBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            try {
                   BookService service =new BookService(request,response);
                   service.createBook();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
    }
}
