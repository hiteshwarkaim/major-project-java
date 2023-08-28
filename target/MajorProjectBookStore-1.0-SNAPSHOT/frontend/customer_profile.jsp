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
           
            <h2>Hello: ${customerEmail}</h2>
            
            <%@include file="/components/footer.jsp" %>

        </div>
    </body>
</html>
