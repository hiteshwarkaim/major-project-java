/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.Book;
import com.bookstore.entities.Category;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class BookService {

    private BookDao bookDao;
    private CategoryDao categoryDao;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public BookService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        bookDao=new BookDao(DB_Connection.getConnection());
       categoryDao=new CategoryDao(DB_Connection.getConnection());
        
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
    public void showBookForm() throws ServletException,IOException{
        
        List<Category> allCategory = categoryDao.getAllCategory();
        request.setAttribute("allCategory", allCategory);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("book_form.jsp");
        requestDispatcher.forward(request, response);
      
             
    }   
    public void createBook() throws IOException,ServletException{
        System.out.println("book service start");
        int catId = Integer.parseInt(request.getParameter("category"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String desc = request.getParameter("desc");
        String isbn = request.getParameter("isbn");
        float price = Float.parseFloat(request.getParameter("price"));
        
        DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
        Date publishdate=null;
        try {
            publishdate=dateFormat.parse(request.getParameter("publishdate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        
        Book newBook=new Book();
        newBook.setB_title(title);
        newBook.setAuthor(author);
        newBook.setDesc(desc);
        newBook.setIsbn(isbn);
        newBook.setPublishDate(publishdate);
        
        Category category = categoryDao.getCategoryById(catId);
        newBook.setCategory(category);
        
        newBook.setPrice(price);
        
        
        Part part=request.getPart("bookImage");
        if(part!=null && part.getSize()>0){
            long size=part.getSize();
            byte[] imageBytes=new byte[(int)size];
            
            InputStream inputStream=part.getInputStream();
            inputStream.read(imageBytes);
            inputStream.close();
        
            newBook.setPic(imageBytes);
        }
        int createdBook = bookDao.createBook(newBook);
        System.out.println("status of created book"+createdBook);
        if(createdBook!=0)
            System.out.println("created new book successfully");
        else
            System.out.println("error in inserting book");
    }
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
