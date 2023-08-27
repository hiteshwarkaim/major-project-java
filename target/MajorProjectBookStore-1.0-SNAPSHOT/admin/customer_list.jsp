<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.entities.User"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            
        </script>
    </head>
    <body>
        <div align="center">
            <%@include file="/components/header.jsp" %>
            
            <div>
                 <h1 class="pageheading">Customer management</h1>    
                 <a href="customer_form.jsp">Create new customer</a>
            </div> 
            <c:if test="${message!=null}">
                <h4 class="message">${message}</h4>
            </c:if>
            
            <table border="1" width="1000">
                <thead>
                    <tr>
                        <th>Index</th>
                        <th>ID</th>
                        <th>Email</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>City</th>
                        <th>Country</th>
                        <th>Zipcode</th>
                        <th>Register date</th>
                        <th>Actions</th>
                        
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="customer" items="${allCustomers}" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${customer.cust_id}</td>
                            <td>${customer.email}</td>
                            <td>${customer.fullName}</td>
                            <td>${customer.address}</td>
                            <td>${customer.city}</td>
                            <td>${customer.country}</td>
                            <td>${customer.zipcode}</td>
                            <td>${customer.register}</td>
                            <td> 
                                <a href="edit-customer?id=${customer.cust_id}">Edit</a> &nbsp;&nbsp; 
                                <a href="javascript:confirmDelete(${customer.cust_id})">Remove</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <%@include file="/components/footer.jsp" %>

        </div>

            <script>
                function confirmDelete(custId) {
                    if(confirm("are sure to delete: "+custId+"?"))
                    {
                        window.location='delete-customer?id=' + custId;
                    }
                }
            </script>
    </body>
</html>
