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
    
}
