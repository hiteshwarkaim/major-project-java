/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.frontend.customer;

import com.bookstore.entities.Book;
import com.bookstore.frontend.shopingcart.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RemoveBookFromCartServlet", urlPatterns = {"/remove_from_cart"})
public class RemoveBookFromCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            int bookId = Integer.parseInt(request.getParameter("book_id"));
            
            Object cartObject=request.getSession().getAttribute("cart");
            
            ShoppingCart shoppingCart=(ShoppingCart)cartObject;
            shoppingCart.removeItem(new Book(bookId));
            
           
           request.getRequestDispatcher("frontend/view_cart.jsp").forward(request, response);
            
        }
    }
}
