/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.dao.DB_Connection;
import com.bookstore.dao.UserDao;
import com.bookstore.entities.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class UserService {

    private UserDao userDao;
    
    public UserService() {
        userDao=new UserDao(DB_Connection.getConnection());
    }
    
    
    public void create(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            
            
            //contact to dao for insert data
            User newUser=new User(name,email,password);
            int status = userDao.createUser(newUser);
           
            if(status !=0 ){
                System.out.println("inserted data");
                String message="User is created successfully"+newUser.getName();
                request.getSession().setAttribute("currentuser", message);
                RequestDispatcher rd=request.getRequestDispatcher("/components/message.jsp");
                rd.forward(request, response);
            }
            else
            {
                System.out.println("error");
                String message="error aa gai";
                request.getSession().setAttribute("currentuser", message);
                RequestDispatcher rd=request.getRequestDispatcher("/error/error.jsp");
                rd.forward(request, response);
            }
                
    } 
    
    public List<User> getAllUsersData(){
        List<User> allUsers = userDao.getAllUsers();
        
        return  allUsers;
    }
    
}
