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
    
    
    public void createCategory() throws ServletException,IOException{
        
            int status=0;
            Category newCategory=null;
            
            String name=request.getParameter("name");
            
        //fetch  the user with this email
            Category categoryByName = categoryDao.getCategoryByName(name);
            
            
            //check email is already exist or not
            if(categoryByName!=null){
                System.out.println("exist krti hai ye");
                
                String message="category name already exist"+name;
                request.setAttribute("message", message);
                
                RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
                rd.include(request, response);
            }
            else{
                
                //if email is not already exist, then insert the data
                newCategory=new Category(name);
                status = categoryDao.createCategory(newCategory);
                
                    if(status !=0 ){
                        System.out.println("inserted data");
                        String message="category is created successfully"+newCategory.getName();
                        request.setAttribute("message", message);
                        RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
                        rd.include(request, response);
                        
                        
                    }
                    else
                    {
                        System.out.println("error");
                        String message="error aa categor me gai";
                        request.setAttribute("message", message);
                        RequestDispatcher rd=request.getRequestDispatcher("/error/error.jsp");
                        rd.include(request, response);
                    }
            }
             
    } 
    
 
    
//    
//    public void editUser() throws ServletException,IOException{
//        
//        int id = Integer.parseInt(request.getParameter("id"));
//        
//        User updateUser = userDao.getUserById(id);
////        userDao.findUserByEmail(email)
//        
//        request.setAttribute("user", updateUser);
//        
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
//        requestDispatcher.forward(request, response);
//            
//    }
//
//    public void updateUser() throws ServletException,IOException{
//            
//            int id = Integer.parseInt(request.getParameter("id"));
//            
//            String name=request.getParameter("name");
//            String email=request.getParameter("email");
//            String password=request.getParameter("password");
//            
//            User userById = userDao.getUserById(id);
//            User userByEmail = userDao.getUserByEmail(email);
//             
//            if(userByEmail!=null && userByEmail.getId()!=userById.getId())
//            {
//                System.out.println("could not update");
//                String message="could not update "+email+" already exist";
//                request.setAttribute("message", message);
//                
//                RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
//                requestDispatcher.include(request, response);
//                
//            }
//            else{
//                User user=new User(id,name,email,password);
//                int updateUserDetails = userDao.updateUserDetails(user);
//
//                if(updateUserDetails!=0)
//                {
//                    System.out.println("user updated");
//                    String message="user updated successfully";
//                    request.setAttribute("message", message);
//                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
//                    requestDispatcher.include(request, response);
//                }
//
//                else
//                    System.out.println("error on update");
//                }
//            
//            
//    }
//
//    public void removeUser() throws IOException,ServletException{
//        int id = Integer.parseInt(request.getParameter("id"));
//        
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
//    }
//    
    
 
   
    
}
