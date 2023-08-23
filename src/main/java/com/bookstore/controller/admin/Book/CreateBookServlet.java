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
        fileSizeThreshold = 1024*1024*10,    //10kb
        maxFileSize = 1024*1024*50,         //50mb
        maxRequestSize = 1024*1024*100         //100MB
    )
public class CreateBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            BookService service =new BookService(request,response);
            service.createBook();
           
            
        }
    }
}
