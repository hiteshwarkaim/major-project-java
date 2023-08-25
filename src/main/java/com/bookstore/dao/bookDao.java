/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entities.Book;
import com.bookstore.entities.Category;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDao {

    private Connection con=null;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public BookDao(Connection con) {
        this.con=con;
    }
    
    public int createBook(Book book){
         int status=0;
        try {
           
            query="insert into book(title,author,description,isbn,image,price,publish_date,last_update_time,category_id) values(?,?,?,?,?,?,?,?,?)";
            ps=this.con.prepareStatement(query);
            
            ps.setString(1, book.getB_title());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getDesc());
            ps.setString(4, book.getIsbn());
            ps.setBytes(5, book.getPic());
            ps.setFloat(6, book.getPrice());
            ps.setObject(7, book.getPublishDate());
            ps.setObject(8, new Date());
            
            //fetch category name by categori id
            String query1="select * from category where category_name=?";
            PreparedStatement ps1=this.con.prepareStatement(query1);
            ps1.setString(1, book.getCategory().getName());
            ResultSet rs1=ps1.executeQuery();
            Category category=null;
            
            if(rs1.next()){
                category=new Category();
                int catid=rs1.getInt("category_id");
                category.setCat_id(catid);
            }
            ps.setInt(9, category.getCat_id());
            status = ps.executeUpdate();
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
    
    public List<Book> getAllBooks(){
        List<Book> booksList=new ArrayList<>();
        Book book=null;
        try {
            query="select * from book";
            ps=this.con.prepareStatement(query);
            rs = ps.executeQuery();
            
            ResultSet rs1=null;
            Category cat=null;
            while(rs.next()){
//               
                 book=new Book();
                 
                 book.setB_id(rs.getInt("book_id"));
                 book.setB_title(rs.getString("title"));
                 book.setAuthor(rs.getString("author"));
                 book.setDesc(rs.getString("description"));
                 book.setIsbn(rs.getString("isbn"));
    
//                 //fetch image
                try {
                     Blob b=rs.getBlob("image");
                    byte[] barr=b.getBytes(1, (int) b.length());
                    File file = new File("D:/xtra/");
//                    if(!file.canRead())
//                    file.setReadable(true);
                    OutputStream fos=new FileOutputStream(file);
                    fos.write(barr);
                    fos.flush();
                    fos.close();
                    book.setPic(barr);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
//                 
                 
                 
                 book.setPic(rs.getBytes("image"));
                 book.setPrice(rs.getFloat("price"));
                 book.setPublishDate(rs.getDate("publish_date"));
                 book.setLastUpdateTime(rs.getTimestamp("last_update_time"));
//                 
//                 System.out.println(rs.getString("author"));
//                 System.out.println(rs.getString("title"));
//                 System.out.println(rs.getInt("category_id"));
//                 
                 int catid=rs.getInt("category_id");
                 
                String query1="select category_name from category where category_id=?";
                PreparedStatement ps1=con.prepareStatement(query1);
                ps1.setInt(1, catid);
                rs1=ps1.executeQuery();
                while(rs1.next()){
//                    System.out.println(rs1.getString("category_name"));
               
                
                    cat=new Category();
                    cat.setName(rs1.getString("category_name"));
                    book.setCategory(cat);

                    
                }
                booksList.add(book);
            }           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booksList;
    }
    
    public Book getBookBytitle(String title){
        Book book=null;
        try {
            query="select * from book where title=?";
            ps=this.con.prepareStatement(query);
            ps.setString(1, title);
            rs = ps.executeQuery();
            
             while(rs.next()){
                book=new Book();
                book.setB_id(rs.getInt("book_id"));
                book.setB_title(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setDesc(rs.getString("desc"));
                book.setIsbn(rs.getString("isbn"));
                book.setPic(rs.getBytes("image"));
                book.setPublishDate(rs.getDate("publish_date"));
                
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  book;
    }
//    
        public Book getBookById(int id){
            Book book=new Book();
            try {
                query="select * from book where book_id=?";
                ps=this.con.prepareStatement(query);
                ps.setInt(1,id);
                rs=ps.executeQuery();
                while(rs.next())
                {
                    book.setB_id(rs.getInt("book_id"));
                    book.setB_title(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setDesc(rs.getString("description"));
                    book.setIsbn(rs.getString("isbn"));
                    book.setPic(rs.getBytes("image"));
                    book.setPrice(rs.getFloat("price"));
                    book.setPublishDate(rs.getDate("publish_date"));
                    book.setLastUpdateTime(rs.getDate("last_update_time"));
                    
                    String query1="select * from category where category_id=?";
                    PreparedStatement ps2=this.con.prepareStatement(query1);
                    ps2.setInt(1, rs.getInt("category_id"));
                    ResultSet rs2=ps2.executeQuery();
                    Category category=null;
                    if(rs2.next())
                    {
                         category=new Category();
                         category.setCat_id(rs2.getInt("category_id"));
                         category.setName(rs2.getString("category_name"));
                    }
                    
                    book.setCategory(category);
                    return book;
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return book;
        }
//
//   
        
         public int updateBookDetails(Book book){
            int status=0;
            try {
                query="update book set title=?,author=?,description=?,isbn=?,price=?,publish_date=?,last_update_time=?,category_id=? where book_id=?";
                ps=this.con.prepareStatement(query);
                
                ps.setString(1, book.getB_title());
                ps.setString(2, book.getAuthor());
                ps.setString(3, book.getDesc());
                ps.setString(4, book.getIsbn());
                ps.setFloat(5, book.getPrice());
                ps.setObject(6, book.getPublishDate());
                ps.setObject(7, new Date());
                
                
                
                
                //fetch category name by categori id
                String query1="select * from category where category_name=?";
                PreparedStatement ps1=this.con.prepareStatement(query1);
                
                ps1.setString(1, book.getCategory().getName());
                ResultSet rs1=ps1.executeQuery();
                Category category=null;

                if(rs1.next()){
                    category=new Category();
                    int catid=rs1.getInt("category_id");
                    category.setCat_id(catid);
                }
                ps.setInt(8, category.getCat_id());
                ps.setInt(9, book.getB_id());
                status=ps.executeUpdate();
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return status;
        }
//         
//         
         public int delete(int id){
             int status=0;
             try {
                 query="delete from book where book_id=?";
                ps=this.con.prepareStatement(query);
                ps.setInt(1, id);
                status = ps.executeUpdate();
                
             } catch (Exception e) {
             }
             return  status;
         }
         
         public List<Book> listBookByCategory(int categoryId){
              List<Book> booksList=new ArrayList<>();
             
            try {
                query="select * from category c right JOIN book b  ON b.category_id=c.category_id where c.category_id=?";
                ps=this.con.prepareStatement(query);
                ps.setInt(1,categoryId);
                rs=ps.executeQuery();
                while(rs.next())
                {
                    Book book=new Book();
                    Category category=new Category();
                    
                    book.setB_id(rs.getInt("book_id"));
                    book.setB_title(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setDesc(rs.getString("description"));
                    book.setIsbn(rs.getString("isbn"));
                    book.setPic(rs.getBytes("image"));
                    book.setPrice(rs.getFloat("price"));
                    book.setPublishDate(rs.getDate("publish_date"));
                    book.setLastUpdateTime(rs.getDate("last_update_time"));
                    
                    category.setName(rs.getString("category_name"));
                    category.setCat_id(rs.getInt("category_id"));
                    
                    booksList.add(book);
               }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return booksList;
         }
         
          public List<Book> listNewBook(){
              List<Book> booksList=new ArrayList<>();
             
            try {
                query="select * from book order by publish_date desc";
                ps=this.con.prepareStatement(query);
//                ps.setInt(1,categoryId);
                rs=ps.executeQuery();
                while(rs.next())
                {
                    Book book=new Book();
                    Category category=new Category();
                    
                    book.setB_id(rs.getInt("book_id"));
                    book.setB_title(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setDesc(rs.getString("description"));
                    book.setIsbn(rs.getString("isbn"));
                    book.setPic(rs.getBytes("image"));
                    book.setPrice(rs.getFloat("price"));
                    book.setPublishDate(rs.getDate("publish_date"));
                    book.setLastUpdateTime(rs.getDate("last_update_time"));
                   
                    booksList.add(book);
               }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return booksList;
         }
         
//         public boolean login(String email, String pass){
//             User user=new User();
//            try {
//                query="select * from users where email=? and password=?";
//                ps=this.con.prepareStatement(query);
//                ps.setString(1,email);
//                ps.setString(2,pass);
//                rs=ps.executeQuery();
//                if(rs.next())
//                {
//                    user.setId(rs.getInt("user_id"));
//                    user.setName(rs.getString("full_name"));
//                    user.setEmail(rs.getString("email"));
//                    user.setPassword(rs.getString("password"));
//                    return  true;
//                }
//                
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return false;
//         }

   
    

}

