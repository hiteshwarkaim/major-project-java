package com.bookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {
    private static Connection con=null;
    
    public static Connection getConnection(){
        if(con==null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstoredb","root","hitesh123");
                System.out.println("connected");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
