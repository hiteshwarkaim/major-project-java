/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.dao.CustomerDao;
import com.bookstore.dao.DB_Connection;
import com.bookstore.entities.Customer;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class CustomerService {

    private CustomerDao customerDao;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    public CustomerService(HttpServletRequest request,HttpServletResponse response) {
        this.request=request;
        this.response=response;
        customerDao=new CustomerDao(DB_Connection.getConnection());
    }
    
    
    public void create() throws ServletException,IOException{
        
            int status=0;
            Customer newCustomer=null;
            
            
            String email=request.getParameter("email");
            String fullname=request.getParameter("fullname");
            String pwd1=request.getParameter("pwd1");
            String pwd2=request.getParameter("pwd2");
            String phone=request.getParameter("phone");
            String address=request.getParameter("address");
            String city=request.getParameter("city");
            String zipcode=request.getParameter("zipcode");
            String country=request.getParameter("country");
            Date register=new Date();
            
        //fetch  the user with this email
        Customer customerByEmail = customerDao.getCustomerByEmail(email);
            
            //check email is already exist or not
            if(customerByEmail!=null){
                System.out.println("exist krti hai ye");
                
                String message="email already exist"+email;
                request.setAttribute("message", message);
                
                RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
                rd.include(request, response);
            }
            else{
                
                //if email is not already exist, then insert the data
                newCustomer=new Customer(email, fullname, address, city, country, phone, zipcode,pwd1, register);
                status = customerDao.createCustomer(newCustomer);
                System.out.println("status "+status);
                    if(status !=0 ){
                        System.out.println("inserted data");
                        String message="User is created successfully"+newCustomer.getFullName();
                        request.setAttribute("message", message);
                        RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
                        rd.include(request, response);
                        
                        
                    }
                    else
                    {
                        System.out.println("error");
                        String message="error aa gai";
                        request.setAttribute("message", message);
                        RequestDispatcher rd=request.getRequestDispatcher("/error/error.jsp");
                        rd.include(request, response);
                    }
            }
             
    } 
//    
    
//    public void getAllUsersData() throws IOException,ServletException{{
//        getAllUsersData(null);
//    }
//    
    public void listAllCustomer() throws IOException,ServletException{
        List<Customer> allCustomers = customerDao.getAllCustomer();
        request.setAttribute("allCustomers", allCustomers);

                    
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer_list.jsp");
        requestDispatcher.forward(request, response);
//        return allUsers;
    } 
    
    
//    
    public void editCustomer() throws ServletException,IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        Customer customerById = customerDao.getCustomerById(id);
        
        request.setAttribute("customer", customerById);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer_form.jsp");
        requestDispatcher.forward(request, response);
            
    }
//
    public void updateCustomer() throws ServletException,IOException{
            
            int id = Integer.parseInt(request.getParameter("id"));System.out.println("id "+id);
            
            String email=request.getParameter("email");
            String fullname=request.getParameter("fullname");
            String pwd1=request.getParameter("pwd1");
            String pwd2=request.getParameter("pwd2");
            String phone=request.getParameter("phone");
            String address=request.getParameter("address");
            String city=request.getParameter("city");
            String zipcode=request.getParameter("zipcode");
            String country=request.getParameter("country");
            Date register=new Date();
            
            Customer customerById = customerDao.getCustomerById(id);
            Customer customerByEmail = customerDao.getCustomerByEmail(email);
            
            if(customerByEmail!=null && customerByEmail.getCust_id()!=customerById.getCust_id())  
            {
                System.out.println("could not update");
                String message="could not update "+email+" already exist";
                request.setAttribute("message", message);
                
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
                requestDispatcher.include(request, response);
                
            }
            else{
                Customer customer=new Customer();
                
                customer.setCust_id(id);
                customer.setEmail(email);
                customer.setAddress(address);
                customer.setFullName(fullname);
                customer.setCity(city);
                customer.setCountry(country);
                customer.setPassword(pwd1);
                customer.setPhone(phone);
                customer.setZipcode(zipcode);
                customer.setRegister(register);
                
                int updateCustomerDetails = customerDao.updateCustomerDetails(customer);

                if(updateCustomerDetails!=0)
                {
                    System.out.println("customer updated");
                    String message="customer updated successfully";
                    request.setAttribute("message", message);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
                    requestDispatcher.include(request, response);
                }

                else
                    System.out.println("error on update");
                }
    } 
//            
//    }
//
    public void removeCustomer() throws IOException,ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        
        int deleteCustomer = customerDao.deleteUser(id);
        if(deleteCustomer!=0)
        {
            String message="user deleted successfully";
            request.setAttribute("message", message);
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.include(request, response);
            
        }
    }
//    
//    public void userLogin() throws IOException,ServletException{
//        String email = request.getParameter("email");
//        String pass = request.getParameter("password");
//        
//        boolean loginStatus = userDao.login(email,pass);
//        
//        if(loginStatus)
//        {
//            System.out.println("user login success");
//            request.getSession().setAttribute("userEmail", email);
//            
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/");
//            requestDispatcher.include(request, response);
//            
//        }
//        else
//        {
//            System.out.println("not login");
//            String message="login failed";
//            request.setAttribute("message", message);
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
//            requestDispatcher.include(request, response);
//        }
//            
//    }
}
