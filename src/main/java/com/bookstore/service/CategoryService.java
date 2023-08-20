/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.Category;
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
public class CategoryService {

    private CategoryDao categoryDao;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    public CategoryService(HttpServletRequest request,HttpServletResponse response) {
        this.request=request;
        this.response=response;
        categoryDao=new CategoryDao(DB_Connection.getConnection());
    }
//    public void getAllUsersData() throws IOException,ServletException{{
//        getAllUsersData(null);
//    }
//    
    public void listCategory() throws IOException,ServletException{
        List<Category> allCategory = categoryDao.getAllCategory();
        request.setAttribute("allCategory", allCategory);
//        if(message!=null)
//            request.setAttribute("message", message);
                    
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category_list.jsp");
        requestDispatcher.forward(request, response);
//        return allUsers;
    } 
    
    
    
    public void editUser() throws ServletException,IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        
//        User updateUser = userDao.getUserById(id);
//        userDao.findUserByEmail(email)
        
//        request.setAttribute("user", updateUser);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
        requestDispatcher.forward(request, response);
            
    }


    public void removeUser() throws IOException,ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        
//        int deleteUser = userDao.deleteUser(id);
//        if(deleteUser!=0)
//        {
//            String message="user deleted successfully";
//            request.setAttribute("message", message);
//            
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
//            requestDispatcher.include(request, response);
//            
//        }
    }
    
}
