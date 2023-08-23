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
           
            query="insert into book(full_name,email,password) values(?,?,?)";
            ps=this.con.prepareStatement(query);
            
            ps.setString(1, book.getAuthor());
            ps.setString(2, book.getB_title());
            ps.setString(3, book.getIsbn());
            status = ps.executeUpdate();
            System.out.println(status);
             
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
    
//    public User getUserByEmail(String email){
//        User user=null;
//        try {
//            query="select * from users where email=?";
//            ps=this.con.prepareStatement(query);
//            ps.setString(1, email);
//            rs = ps.executeQuery();
//            
//             while(rs.next()){
//                user=new User();
//                user.setId(rs.getInt("user_id"));
//                user.setName(rs.getString("full_name"));
//                user.setEmail(rs.getString("email"));
//                
//            }
//           
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return  user;
//    }
//    
//        public User getUserById(int id){
//            User user=new User();
//            try {
//                query="select * from users where user_id=?";
//                ps=this.con.prepareStatement(query);
//                ps.setInt(1,id);
//                rs=ps.executeQuery();
//                while(rs.next())
//                {
//                    user.setId(rs.getInt("user_id"));
//                    user.setName(rs.getString("full_name"));
//                    user.setEmail(rs.getString("email"));
//                    user.setPassword(rs.getString("password"));
//                    
//                    return user;
//                }
//                
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return user;
//        }
//
//   
//        
//         public int updateUserDetails(User u){
//            int status=0;
//            try {
//                query="update users set full_name=?, email=?, password=? where user_id=?";
//                ps=this.con.prepareStatement(query);
//                
//                ps.setString(1, u.getName());
//                ps.setString(2, u.getEmail());
//                ps.setString(3, u.getPassword());
//                ps.setInt(4,u.getId());
//                status=ps.executeUpdate();
//                
//                
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return status;
//        }
//         
//         
//         public int deleteUser(int id){
//             int status=0;
//             try {
//                 query="delete from users where user_id=?";
//                ps=this.con.prepareStatement(query);
//                ps.setInt(1, id);
//                status = ps.executeUpdate();
//                
//             } catch (Exception e) {
//             }
//             return  status;
//         }
//         
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
