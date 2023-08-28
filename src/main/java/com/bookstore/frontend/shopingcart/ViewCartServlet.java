/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.frontend.shopingcart;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.Book;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ViewCartServlet", urlPatterns = {"/view-cart"})
public class ViewCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Object cartobject=request.getSession().getAttribute("cart");
            
            if(cartobject==null){
                ShoppingCart shopingCart=new ShoppingCart();
                request.getSession().setAttribute("cart", shopingCart);
                
                BookDao bookDao=new BookDao(DB_Connection.getConnection());
            
            Book book=new Book();
            Book book1 = bookDao.getBookById(4);
            Book book2 = bookDao.getBookById(5);
            Book book3 = bookDao.getBookById(7);
            
//            ShoppingCart shopingCart =(ShoppingCart) request.getSession().getAttribute("cart");
            shopingCart.addItem(book1);
            shopingCart.addItem(book2);
            shopingCart.addItem(book3);
            }
            
            
            
            
             RequestDispatcher rd=request.getRequestDispatcher("frontend/view_cart.jsp");
             rd.forward(request, response);
            
        }
    }
}
