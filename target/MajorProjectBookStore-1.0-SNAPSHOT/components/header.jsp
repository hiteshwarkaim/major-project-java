
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="common_style.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
    </head>
    <body>
        <div align="center">
            <div>
                <img src="../static/images/logo.jpg" alt="alt" height="100" width="300"/>
            </div>
            <h4>Welcome, <c:out value="${sessionScope.userEmail}"></c:out> | <a href="#">Logout</a></h4>
            <div id="headermenu">
                <nav>
                    <div>
                        <a href="list-users">
                            <img src="../static/images/user.png" alt="alt" width="70" height="70"/><br>Users
                        </a> |&nbsp;
                    </div>
                    <div>
                        <a href="list-category">
                            <img src="../static/images/category.png" alt="alt" width="70" height="70"/> <br>Categories
                        </a> | &nbsp;
                     </div>
                    <div>
                        <a href="#">
                            <img src="../static/images/book.png" alt="alt" width="70" height="70"/> <br>Books
                        </a> | &nbsp;
                    </div>
                    <div>
                        <a href="#">
                            <img src="../static/images/customer.png" alt="alt" width="70" height="70"/><br> Customers
                        </a> | &nbsp;
                     </div>
                    <div>
                        <a href="#">
                            <img src="../static/images/order.png" alt="alt" width="70" height="70"/> <br>Orders
                        </a> |&nbsp;
                     </div>
                    <div>
                        <a href="#">
                            <img src="../static/images/review.png" alt="alt" width="70" height="70"/><br> Reviews
                        </a>
                     </div>
                </nav>
            </div>
            
            
        </div>
        <hr>
        
    </body>
</html>
