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
          <%@include file="/components/header_frontend.jsp" %>
            <c:if test="${message!=null}">
                <h4 class="message">${message}</h4>
            </c:if>
                    
            <div>
                <h2>Login</h2>
            </div>
            
                <div>
                    <form action="login-customer" method="POST" >
                        Email:<input type="text" name="email"/><br>
                        Password:<input type="password" name="password"/><br>
                        <button type="submit" >Login</button> &nbsp;&nbsp;
                    </form>
                </div>
            <%@include file="/components/footer.jsp" %>
        </div>
            
    </body>
</html>


