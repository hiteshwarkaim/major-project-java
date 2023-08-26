/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entities.Customer;
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
public class CustomerDao {

    private Connection con=null;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CustomerDao(Connection con) {
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
    
    public List<Customer> getAllCustomer(){
        List<Customer> customersList=new ArrayList<>();
        try {
            query="select * from customer";
            ps=this.con.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                 Customer customer=new Customer();
                 
                 customer.setCust_id(rs.getInt("customer_id"));
                 customer.setEmail(rs.getString("email"));
                 customer.setFullName(rs.getString("fullname"));
                 customer.setAddress(rs.getString("address"));
                 customer.setCity(rs.getString("city"));
                 customer.setCountry(rs.getString("country"));
                 customer.setPhone(rs.getString("phone"));
                 customer.setZipcode(rs.getString("zipcode"));
                 customer.setRegister(rs.getDate("register_date"));
                 
                 customersList.add(customer);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customersList;
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
         
         
         public int deleteUser(int id){
             int status=0;
             try {
                 query="delete from users where user_id=?";
                ps=this.con.prepareStatement(query);
                ps.setInt(1, id);
                status = ps.executeUpdate();
                
             } catch (Exception e) {
             }
             return  status;
         }
         
         public boolean login(String email, String pass){
             User user=new User();
            try {
                query="select * from users where email=? and password=?";
                ps=this.con.prepareStatement(query);
                ps.setString(1,email);
                ps.setString(2,pass);
                rs=ps.executeQuery();
                if(rs.next())
                {
                    user.setId(rs.getInt("user_id"));
                    user.setName(rs.getString("full_name"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    return  true;
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
         }

}
