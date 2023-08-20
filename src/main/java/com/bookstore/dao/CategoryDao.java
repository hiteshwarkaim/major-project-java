/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entities.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CategoryDao {

    private Connection con=null;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CategoryDao(Connection con) {
        this.con=con;
    }
    
    public int createCategory(Category cat){
         int status=0;
        try {
           
            query="insert into category(category_name) values(?)";
            ps=this.con.prepareStatement(query);
            
            ps.setString(1, cat.getName());
            status = ps.executeUpdate();
            System.out.println(status);
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
    
    public List<Category> getAllCategory(){
        List<Category> categoryList=new ArrayList<>();
        try {
            query="select * from category";
            ps=this.con.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                 Category cat=new Category();
                 
                 cat.setCat_id(rs.getInt("category_id"));
                 cat.setName(rs.getString("category_name"));
                 
                 categoryList.add(cat);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryList;
    }
    
    public Category getCategoryByName(String name){
        Category category=null;
        try {
            query="select * from category where category_name=?";
            ps=this.con.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            
             while(rs.next()){
                category=new Category();
                category.setCat_id(rs.getInt("category_id"));
                category.setName(rs.getString("category_name"));
               
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  category;
    }
    
        public Category getCategoryById(int id){
            Category cat=new Category();
            try {
                query="select * from category where category_id=?";
                ps=this.con.prepareStatement(query);
                ps.setInt(1,id);
                rs=ps.executeQuery();
                while(rs.next())
                {
                    cat.setCat_id(rs.getInt("category_id"));
                    cat.setName(rs.getString("category_name"));

                    return cat;
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return cat;
        }

   
        
         public int updateCategoryDetails(Category cat){
             System.out.println(cat);
            int status=0;
            try {
                query="update category set category_name=? where category_id=?";
                ps=this.con.prepareStatement(query);
                
                ps.setString(1, cat.getName());
                ps.setInt(2,cat.getCat_id());
                status=ps.executeUpdate();
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return status;
        }
         
         
         public int deleteCategory(int id){
             int status=0;
             try {
                 query="delete from category where category_id=?";
                ps=this.con.prepareStatement(query);
                ps.setInt(1, id);
                status = ps.executeUpdate();
                
             } catch (Exception e) {
             }
             return  status;
         }

   
}
