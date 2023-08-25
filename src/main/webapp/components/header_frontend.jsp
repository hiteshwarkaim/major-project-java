
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
                <img src="./static/images/book.jpg" alt="alt" height="100" width="300"/>
            </div>
            <div>
                <nav>
                    <a href="#">Register</a> | &nbsp;
                    <a href="#">Signin</a> |&nbsp;
                    <a href="#">Cart</a>
                </nav>
            </div>
            
            <div>
                <c:forEach var="category" items="${allCategory}" varStatus="status">
                    <a href="view-category?id=${category.cat_id}">
                        <strong style="font-size: 20px;"><c:out value="${category.name}"/></strong>
                    </a>
                    <c:if test="${not status.last}">
                        &nbsp; | &nbsp;
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <hr>
        
    </body>
</html>
