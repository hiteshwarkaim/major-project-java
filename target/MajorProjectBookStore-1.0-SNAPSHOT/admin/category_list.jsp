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
                 <h1 class="pageheading">Category management</h1>    
                 <a href="category_form.jsp">Create new Category</a>
            </div> 
            <c:if test="${message!=null}">
                <h4>${message}</h4>
            </c:if>
            <table border="1" width="800">
                <thead>
                    <tr>
                        <th>Index</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Actions</th>
                        
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="cat" items="${allCategory}" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${cat.cat_id}</td>
                            <td>${cat.name}</td>
                            <td> 
                                <a href="edit-category?id=${cat.cat_id}">Edit</a> &nbsp;&nbsp; 
                                <a href="javascript:confirmDelete(${cat.cat_id})">Remove</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <%@include file="/components/footer.jsp" %>

        </div>

            <script>
                function confirmDelete(catId) {
                    if(confirm("are sure to delete: "+catId+"?"))
                    {
                        window.location='delete-category?id=' + catId;
                    }
                }
            </script>
    </body>
</html>
