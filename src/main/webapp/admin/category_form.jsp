<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <%@include file="/components/header.jsp" %>
          
            <div>
                <h2>
                    <c:if test="${category!=null}">Edit Category</c:if>
                    <c:if test="${category==null}">Create new Category</c:if>
                        
                </h2>
            </div>
             
                    <div>
                        <c:if test="${category!=null}">
                            <form action="update-category" method="POST" >
                             <input type="hidden" name="id" value="${category.cat_id}">
                        </c:if>
                        <c:if test="${category==null}">
                            <form action="create-category" method="POST">
                        </c:if>
                                
                   
                    
                            Name:<input type="text" name="name" value="${category.name}"/><br>
                            <input type="submit" value="Add category"/>

                    </form>
            </div>
            <%@include file="/components/footer.jsp" %>

        </div>
            
    </body>
</html>


