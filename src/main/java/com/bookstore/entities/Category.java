/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.entities;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Category implements Serializable{
    private int cat_id;
    private String name;

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(int cat_id, String name) {
        this.cat_id = cat_id;
        this.name = name;
    }

     public Category(String name) {
        this.name = name;
    }

    
    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" + "cat_id=" + cat_id + ", name=" + name + '}';
    }
    
    
    
}
