/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller.admin;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebFilter(filterName = "AdminLoginFilter", urlPatterns = {"/admin/*"}) //* means it intercept all request came afetr admin URL
public class AdminLoginFilter implements Filter {
    

    private FilterConfig filterConfig = null;
    
    public AdminLoginFilter() {
    }    
    
  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {
        
        HttpServletRequest httpRequest=(HttpServletRequest)request;
        HttpSession session=httpRequest.getSession(false);
        
        boolean loggedIn= (session!=null) && (session.getAttribute("userEmail")!=null);
        
        String loginURI=httpRequest.getContextPath()+"/admin/login";
        boolean loginRequest=httpRequest.getRequestURI().equals(loginURI);
        boolean loginPage=httpRequest.getRequestURI().endsWith("login.jsp");
        
        if(loggedIn && (loginRequest||loginPage))
        {
            RequestDispatcher rd = request.getRequestDispatcher("/admin/");
            rd.forward(request, response);
        }
        else if(loggedIn || loginRequest)
        {
            System.out.println("user login successfully");
            chain.doFilter(request, response);
        }
        else
        {
            System.out.println("login failed...............");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }

    public void destroy() {        
    
    }

    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        
    }

    
    
}
