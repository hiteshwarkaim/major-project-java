package com.bookstore.entities;

import java.util.Date;

public class Customer {
    private int cust_id;
    private String email;
    private String fullName;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String zipcode;
    private String password;
    private Date register;

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegister() {
        return register;
    }

    public void setRegister(Date register) {
        this.register = register;
    }

  

    public Customer(String email, String fullName, String address, String city, String country, String phone, String zipcode, String password, Date register) {
        this.email = email;
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.zipcode = zipcode;
        this.password = password;
        this.register = register;
    }
    
    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" + "cust_id=" + cust_id + ", email=" + email + ", fullName=" + fullName + ", address=" + address + ", city=" + city + ", country=" + country + ", phone=" + phone + ", zipcode=" + zipcode + ", password=" + password + ", register=" + register + '}';
    }
    
    
    
    
}
