/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.frontend;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.Book;
import com.bookstore.entities.Category;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeServlet", urlPatterns = {""})
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
        CategoryDao categoryDao=new CategoryDao(DB_Connection.getConnection());
        BookDao bookDao=new BookDao(DB_Connection.getConnection());
        
        List<Category> allCategory = categoryDao.getAllCategory();
        List<Book> listNewBook = bookDao.listNewBook();
        
        request.setAttribute("allCategory", allCategory);
        request.setAttribute("listNewBook", listNewBook);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("frontend/index.jsp");
        rd.forward(request, response);
    }
}
