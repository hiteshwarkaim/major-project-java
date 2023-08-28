/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entities.Customer;
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
    
    public int createCustomer(Customer customer){
         int status=0;
        try {
           
            query="insert into customer(email,fullname,address,city,country,phone,zipcode,password,register_date) values(?,?,?,?,?,?,?,?,?)";
            ps=this.con.prepareStatement(query);
            
            System.out.println(customer.getEmail()+" "+customer.getFullName()+" "+customer.getRegister());
            
            ps.setString(1, customer.getEmail());
            ps.setString(2, customer.getFullName());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getCity());
            ps.setString(5, customer.getCountry());
            ps.setString(6, customer.getPhone());
            ps.setString(7, customer.getZipcode());
            ps.setString(8, customer.getPassword());
            ps.setObject(9, customer.getRegister());
            
            status = ps.executeUpdate();
          
             
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
    
    public Customer getCustomerByEmail(String email){
        Customer customer=null;
        try {
            query="select * from customer where email=?";
            ps=this.con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
             while(rs.next()){
                customer=new Customer();
                
                 customer.setCust_id(rs.getInt("customer_id"));
                 customer.setEmail(rs.getString("email"));
                 customer.setFullName(rs.getString("fullname"));
                 customer.setAddress(rs.getString("address"));
                 customer.setCity(rs.getString("city"));
                 customer.setCountry(rs.getString("country"));
                 customer.setPhone(rs.getString("phone"));
                 customer.setZipcode(rs.getString("zipcode"));
                 customer.setPassword(rs.getString("password"));
                 customer.setRegister(rs.getDate("register_date"));
                
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  customer;
    }
    
        public Customer getCustomerById(int id){
            Customer customer=new Customer();
            try {
                query="select * from customer where customer_id=?";
                ps=this.con.prepareStatement(query);
                ps.setInt(1,id);
                rs=ps.executeQuery();
                while(rs.next())
                {
                 customer.setCust_id(rs.getInt("customer_id"));
                 customer.setEmail(rs.getString("email"));
                 customer.setFullName(rs.getString("fullname"));
                 customer.setAddress(rs.getString("address"));
                 customer.setCity(rs.getString("city"));
                 customer.setCountry(rs.getString("country"));
                 customer.setPhone(rs.getString("phone"));
                 customer.setZipcode(rs.getString("zipcode"));
                 customer.setPassword(rs.getString("password"));
                 customer.setRegister(rs.getDate("register_date"));
                    
                    return customer;
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return customer;
        }

   
        
         public int updateCustomerDetails(Customer customer){
            int status=0;
            try {
                query="update customer set email=?, fullname=?, address=?,city=?,country=?,phone=?,zipcode=?,password=?,register_date=? where customer_id=?";
                ps=this.con.prepareStatement(query);
                
                ps.setString(1, customer.getEmail());
                ps.setString(2, customer.getFullName());
                ps.setString(3, customer.getAddress());
                ps.setString(4, customer.getCity());
                ps.setString(5, customer.getCountry());
                ps.setString(6, customer.getPhone());
                ps.setString(7, customer.getZipcode());
                ps.setString(8, customer.getPassword());
                ps.setObject(9, customer.getRegister());
                ps.setInt(10, customer.getCust_id());
                
                status=ps.executeUpdate();
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return status;
        }
         
         
         public int deleteUser(int id){
             int status=0;
             try {
                 query="delete from customer where customer_id=?";
                ps=this.con.prepareStatement(query);
                ps.setInt(1, id);
                status = ps.executeUpdate();
                
             } catch (Exception e) {
             }
             return  status;
         }
         
         public boolean login(String email, String pass){
             Customer customer=new Customer();
            try {
                query="select * from customer where email=? and password=?";
                ps=this.con.prepareStatement(query);
                ps.setString(1,email);
                ps.setString(2,pass);
                rs=ps.executeQuery();
                if(rs.next())
                {
                    customer.setCust_id(rs.getInt("customer_id"));
                    customer.setFullName(rs.getString("fullname"));
                    customer.setEmail(rs.getString("email"));
                    customer.setPassword(rs.getString("password"));
                    return  true;
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
         }

}
