/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.Book;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookService {

    private BookDao bookDao;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public BookService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        bookDao=new BookDao(DB_Connection.getConnection());
    }
    
    
    
    public void listBooks() throws IOException,ServletException{
        List<Book> allBooks = bookDao.getAllBooks();
        request.setAttribute("allBooks", allBooks);
        System.out.println(allBooks);
              
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("book_list.jsp");
        requestDispatcher.forward(request, response);
//        return allUsers;
    } 
    
//    
//    public void createCategory() throws ServletException,IOException{
//        
//            int status=0;
//            Category newCategory=null;
//            
//            String name=request.getParameter("name");
//            
//        //fetch  the user with this email
//            Category categoryByName = categoryDao.getCategoryByName(name);
//            
//            
//            //check email is already exist or not
//            if(categoryByName!=null){
//                System.out.println("exist krti hai ye");
//                
//                String message="category name already exist"+name;
//                request.setAttribute("message", message);
//                
//                RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
//                rd.include(request, response);
//            }
//            else{
//                
//                //if email is not already exist, then insert the data
//                newCategory=new Category(name);
//                status = categoryDao.createCategory(newCategory);
//                
//                    if(status !=0 ){
//                        System.out.println("inserted data");
//                        String message="category is created successfully"+newCategory.getName();
//                        request.setAttribute("message", message);
//                        RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
//                        rd.include(request, response);
//                        
//                        
//                    }
//                    else
//                    {
//                        System.out.println("error");
//                        String message="error aa categor me gai";
//                        request.setAttribute("message", message);
//                        RequestDispatcher rd=request.getRequestDispatcher("/error/error.jsp");
//                        rd.include(request, response);
//                    }
//            }
//             
//    } 
//    
// 
//    
////    
//    public void editCategory() throws ServletException,IOException{
//        
//        int id = Integer.parseInt(request.getParameter("id"));
//        
//        Category getCategoryById = categoryDao.getCategoryById(id);
////        userDao.findUserByEmail(email)
//        System.out.println(getCategoryById+" getCategoryById");
//        request.setAttribute("category", getCategoryById);
//        
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category_form.jsp");
//        requestDispatcher.forward(request, response);
//            
//    }
////
//    public void updateCategory() throws ServletException,IOException{
//            
//            int id = Integer.parseInt(request.getParameter("id"));
//            
//            String name=request.getParameter("name");
//            
//            System.out.println(name);
//        Category categoryById = categoryDao.getCategoryById(id);
//        Category categoryByName = categoryDao.getCategoryByName(name);
//            
//        if(categoryByName!=null && categoryByName.getCat_id()!=categoryById.getCat_id())
//            {
//                System.out.println("could not update");
//                String message="could not update "+name+" already exist";
//                request.setAttribute("message", message);
//                
//                RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
//                requestDispatcher.include(request, response);
//                
//            }
//            else{
//                Category category=new Category(id,name);
//                int updateCategoryDetails = categoryDao.updateCategoryDetails(category);
//
//                if(updateCategoryDetails!=0)
//                {
//                    System.out.println("category updated");
//                    String message="category updated successfully";
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
////
//    public void removeCategory() throws IOException,ServletException{
//        int id = Integer.parseInt(request.getParameter("id"));
//        int deleteCategory = categoryDao.deleteCategory(id);
//        
//        if(deleteCategory!=0)
//        {
//            String message="category deleted successfully";
//            request.setAttribute("message", message);
//            
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
//            requestDispatcher.include(request, response);
//            
//        }
//    }
    

    
 
   
    
}
