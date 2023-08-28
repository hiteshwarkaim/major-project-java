/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.frontend.customer;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.Book;
import com.bookstore.frontend.shopingcart.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddBookToCartServlet", urlPatterns = {"/add_to_cart"})
public class AddBookToCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            int bookId = Integer.parseInt(request.getParameter("book_id"));
            
            Object cartObject=request.getSession().getAttribute("cart");
            
            ShoppingCart shoppingCart=null;
            
            if(cartObject!=null && cartObject instanceof ShoppingCart){
                shoppingCart=(ShoppingCart)cartObject;
            }else{
                shoppingCart=new ShoppingCart();
                request.getSession().setAttribute("cart", shoppingCart);
            }
            
            BookDao bookDao=new BookDao(DB_Connection.getConnection());
            Book book1 = bookDao.getBookById(bookId);
            
            shoppingCart.addItem(book1);
            
//            String cartPage=request.getContextPath().concat("/view_cart");
//            response.sendRedirect(cartPage);
                request.getRequestDispatcher("frontend/view_cart.jsp").forward(request, response);
                
        }
    }
}
