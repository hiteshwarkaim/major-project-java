/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserDao {

    private Connection con=null;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public UserDao(Connection con) {
        this.con=con;
    }
    
    public int createUser(User user){
         int status=0;
        try {
           
            query="insert into users(full_name,email,password) values(?,?,?)";
            ps=this.con.prepareStatement(query);
            
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            status = ps.executeUpdate();
            System.out.println(status);
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
    
    public List<User> getAllUsers(){
        List<User> usersList=new ArrayList<>();
        try {
            query="select * from users";
            ps=this.con.prepareStatement(query);
            
            rs = ps.executeQuery();
            int id=0;
            String name=null;
            String email=null;
            
            while(rs.next()){
                 User user=new User();
                 
                 user.setId(rs.getInt("user_id"));
                 user.setName(rs.getString("full_name"));
                 user.setEmail(rs.getString("email"));
                 
                 usersList.add(user);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }
    
    public User getUserByEmail(String email){
        User user=null;
        try {
            query="select * from users where email=?";
            ps=this.con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
             while(rs.next()){
                user=new User();
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  user;
    }
    
        public User getUserById(int id){
            User user=new User();
            try {
                query="select * from users where user_id=?";
                ps=this.con.prepareStatement(query);
                ps.setInt(1,id);
                rs=ps.executeQuery();
                while(rs.next())
                {
                    user.setId(rs.getInt("user_id"));
                    user.setName(rs.getString("full_name"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    
                    return user;
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user;
        }

   
        
         public int updateUserDetails(User u){
            int status=0;
            try {
                query="update users set full_name=?, email=?, password=? where user_id=?";
                ps=this.con.prepareStatement(query);
                
                ps.setString(1, u.getName());
                ps.setString(2, u.getEmail());
                ps.setString(3, u.getPassword());
                ps.setInt(4,u.getId());
                status=ps.executeUpdate();
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return status;
        }
}
