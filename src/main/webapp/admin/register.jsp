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
          
            <form action="create-user" method="POST">
                Name:<input type="text" name="name" value="${user.name}"/><br>
                Email:<input type="email" name="email" value="${user.email}"/><br>
                Password:<input type="password" name="password" value="${user.password}"/><br>
                <input type="submit" value="signin"/>
                
            </form>
            
            <%@include file="/components/footer.jsp" %>

        </div>
    </body>
</html>
