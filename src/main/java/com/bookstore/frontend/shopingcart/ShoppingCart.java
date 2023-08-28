/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.frontend.shopingcart;

import com.bookstore.entities.Book;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class ShoppingCart {
    private Map<Book,Integer> cartList=new HashMap<>();
    
    public void addItem(Book book){
        if(cartList.containsKey(book)){
            Integer quantity=cartList.get(book)+1;
            cartList.put(book, quantity);
        }
        else{
            cartList.put(book, 1);
        }
    }
    
    public void removeItem(Book book){
        cartList.remove(book);  
    }
    public int getTotalQuantity(){
        int total=0;
        
        Iterator<Book> iterator=cartList.keySet().iterator();
        
        while(iterator.hasNext()){
            Book next=iterator.next();
            Integer quantity=cartList.get(next);
            total+=quantity;
        }
        return  total;
    }
    public double getTotalAmount(){
        double total=0.0f;
        
        Iterator<Book> iterator=cartList.keySet().iterator();
        
        while(iterator.hasNext()){
            Book book=iterator.next();
            Integer quantity=cartList.get(book);
            double subTotal=quantity*book.getPrice();
            total+=subTotal;
        }
        return  total;
    }

    public void clearCart(){
        cartList.clear();
    }
    
    public int getTotalItems(){
       return cartList.size();
    }
    public Map<Book,Integer> getItems(){
        return this.cartList;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "cartList=" + cartList + '}';
    }
    
        
}
