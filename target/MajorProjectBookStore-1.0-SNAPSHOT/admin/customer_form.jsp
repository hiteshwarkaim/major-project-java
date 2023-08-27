<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../static/css/jquery-ui.min.css"/>
        
    </head>
    <body>
        <div align="center">
            <%@include file="/components/header.jsp" %>
          
            <div>
                <h2>
                    <c:if test="${customer!=null}">Edit Customer</c:if>
                    <c:if test="${customer==null}">Create new Customer</c:if>
                        
                </h2>
            </div>
             
                    <div>
                        <c:if test="${customer!=null}">
                            <form action="update-customer" method="post">
                             <input type="hidden" name="id" value="${customer.cust_id}">
                        </c:if>
                        <c:if test="${customer==null}">
                            <form action="create-customer" method="POST">
                        </c:if>
                                
                   
                               
                            Email:<input type="text" name="email" value="${customer.email}"/><br>
                            Full Name:<input type="text" name="fullname" value="${customer.fullName}"/><br>
                            Password:<input type="password" name="pwd1" value="${customer.password}"/><br>
                            Confirm Password:<input type="password" name="pwd2" value="${customer.password}"/><br>
                            Phone No:<input type="text" name="phone" value="${customer.phone}"/><br>
                            Address:<input type="text" name="address" value="${customer.address}"/><br>
                            City:<input type="text" name="city" value="${customer.city}"/><br>
                            Zip Code:<input type="text" name="zipcode" value="${customer.zipcode}"/><br>
                            Country:<input type="text" name="country" value="${customer.country}"><br>
                            <input type="submit" value="Save"/> &nbsp;<input type="reset" value="Cancel"/>

                    </form>
            </div>
            <%@include file="/components/footer.jsp" %>

        </div>
    </body>
    
    
</html>


