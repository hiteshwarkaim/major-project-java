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
                    <c:if test="${user!=null}">Edit User</c:if>
                    <c:if test="${user==null}">Create new User</c:if>
                        
                </h2>
            </div>
             
                    <div>
                        <c:if test="${user!=null}">
                            <form action="update-user" method="POST">
                             <input type="hidden" name="id" value="${user.id}">
                        </c:if>
                        <c:if test="${user==null}">
                            <form action="create-user" method="POST">
                        </c:if>
                                
                   
                    
                        Name:<input type="text" name="name" value="${user.name}"/><br>
                        Email:<input type="email" name="email" value="${user.email}"/><br>
                        Password:<input type="password" name="password" value="${user.password}"/><br>
                        <input type="submit" value="signin"/>

                    </form>
            </div>
            <%@include file="/components/footer.jsp" %>

        </div>
    </body>
</html>
