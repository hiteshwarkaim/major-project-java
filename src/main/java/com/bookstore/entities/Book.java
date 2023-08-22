/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.entities;

import java.io.Serializable;
import java.util.*;

public class Book implements Serializable{
    private int b_id;
    private String b_title;
    private String author;
    private String desc;
    private String isbn;
    private byte[] pic;
    private float price ;
    private Date publishDate;
    private Date lastUpdateTime;
    private Category category;
    
    private Set<Review> reviews=new HashSet<>();
    private Set<OrderDetail> orderDetails=new HashSet<>();

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_title() {
        return b_title;
    }

    public void setB_title(String b_title) {
        this.b_title = b_title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    

    public Book(int b_id, String b_title, String author, Category category, String desc, String isbn, byte[] pic, float price, Date publishDate, Date lastUpdateTime) {
        this.b_id = b_id;
        this.b_title = b_title;
        this.author = author;
        this.desc = desc;
        this.isbn = isbn;
        this.pic = pic;
        this.price = price;
        this.publishDate = publishDate;
        this.lastUpdateTime = lastUpdateTime;
        this.category=category;
    }

    public Book() {
    }
    
    public String getBase64Image(){
        return  Base64.getEncoder().encodeToString(this.pic);
    }
    
}
