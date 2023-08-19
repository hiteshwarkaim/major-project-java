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
        
            int status=0;
            User newUser=null;
            
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            
            //fetch all the user with this email
            List<User> allUsers = userDao.findUserByEmail(email);
            
            
            //check if user is already exist or not
            if(allUsers.size()>0){
                System.out.println("exist krti hai ye");
                String message="email already exist"+email;
                request.getSession().setAttribute("message", message);
                RequestDispatcher rd=request.getRequestDispatcher("/error/error.jsp");
                rd.forward(request, response);
            }
            else{
                
                //if email is not already exist, then insert the data
                newUser=new User(name,email,password);
                status = userDao.createUser(newUser);
                
                
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
                        request.getSession().setAttribute("message", message);
                        RequestDispatcher rd=request.getRequestDispatcher("/error/error.jsp");
                        rd.forward(request, response);
                    }
            }
                
    } 
    
    public List<User> getAllUsersData(){
        List<User> allUsers = userDao.getAllUsers();
        
        return  allUsers;
    } 
    
    public void editUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        User updateUser = userDao.getUserById(id);
       
        request.setAttribute("user", updateUser);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
        requestDispatcher.forward(request, response);
            
    }
    
}
