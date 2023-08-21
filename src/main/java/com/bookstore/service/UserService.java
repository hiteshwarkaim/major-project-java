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
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    public UserService(HttpServletRequest request,HttpServletResponse response) {
        this.request=request;
        this.response=response;
        userDao=new UserDao(DB_Connection.getConnection());
    }
    
    
    public void create() throws ServletException,IOException{
        
            int status=0;
            User newUser=null;
            
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            
        //fetch  the user with this email
            User userByEmail = userDao.getUserByEmail(email);
            
            
            //check email is already exist or not
            if(userByEmail!=null){
                System.out.println("exist krti hai ye");
                
                String message="email already exist"+email;
                request.setAttribute("message", message);
                
                RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
                rd.include(request, response);
            }
            else{
                
                //if email is not already exist, then insert the data
                newUser=new User(name,email,password);
                status = userDao.createUser(newUser);
                
                    if(status !=0 ){
                        System.out.println("inserted data");
                        String message="User is created successfully"+newUser.getName();
                        request.setAttribute("message", message);
                        RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
                        rd.include(request, response);
                        
                        
                    }
                    else
                    {
                        System.out.println("error");
                        String message="error aa gai";
                        request.setAttribute("message", message);
                        RequestDispatcher rd=request.getRequestDispatcher("/error/error.jsp");
                        rd.include(request, response);
                    }
            }
             
    } 
    
    
//    public void getAllUsersData() throws IOException,ServletException{{
//        getAllUsersData(null);
//    }
//    
    public void getAllUsersData() throws IOException,ServletException{
        List<User> allUsers = userDao.getAllUsers();
        request.setAttribute("allUsers", allUsers);
//        if(message!=null)
//            request.setAttribute("message", message);
                    
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user_list.jsp");
        requestDispatcher.forward(request, response);
//        return allUsers;
    } 
    
    
    
    public void editUser() throws ServletException,IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        User updateUser = userDao.getUserById(id);
//        userDao.findUserByEmail(email)
        
        request.setAttribute("user", updateUser);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
        requestDispatcher.forward(request, response);
            
    }

    public void updateUser() throws ServletException,IOException{
            
            int id = Integer.parseInt(request.getParameter("id"));
            
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            
            User userById = userDao.getUserById(id);
            User userByEmail = userDao.getUserByEmail(email);
             
            if(userByEmail!=null && userByEmail.getId()!=userById.getId())
            {
                System.out.println("could not update");
                String message="could not update "+email+" already exist";
                request.setAttribute("message", message);
                
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
                requestDispatcher.include(request, response);
                
            }
            else{
                User user=new User(id,name,email,password);
                int updateUserDetails = userDao.updateUserDetails(user);

                if(updateUserDetails!=0)
                {
                    System.out.println("user updated");
                    String message="user updated successfully";
                    request.setAttribute("message", message);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
                    requestDispatcher.include(request, response);
                }

                else
                    System.out.println("error on update");
                }
            
            
    }

    public void removeUser() throws IOException,ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        
        int deleteUser = userDao.deleteUser(id);
        if(deleteUser!=0)
        {
            String message="user deleted successfully";
            request.setAttribute("message", message);
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.include(request, response);
            
        }
    }
    
    public void userLogin() throws IOException,ServletException{
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        
        boolean loginStatus = userDao.login(email,pass);
        
        if(loginStatus)
        {
            System.out.println("user login success");
            request.getSession().setAttribute("userEmail", email);
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/");
            requestDispatcher.include(request, response);
            
        }
        else
        {
            System.out.println("not login");
            String message="login failed";
            request.setAttribute("message", message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.include(request, response);
        }
            
    }
}
