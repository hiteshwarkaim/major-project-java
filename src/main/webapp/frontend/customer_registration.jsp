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
            <%@include file="/components/header_frontend.jsp" %>
          
            ${message}
            <div>
                <h2>Customer Registration </h2>
            </div>
             
                    <div>
                            <form action="register" method="POST">
                               
                            Email:<input type="text" name="email" /><br>
                            Full Name:<input type="text" name="fullname" /><br>
                            Password:<input type="password" name="pwd1" /><br>
                            Confirm Password:<input type="password" name="pwd2"/><br>
                            Phone No:<input type="text" name="phone" /><br>
                            Address:<input type="text" name="address" /><br>
                            City:<input type="text" name="city" /><br>
                            Zip Code:<input type="text" name="zipcode" /><br>
                            Country:<input type="text" name="country" ><br>
                            <input type="submit" value="Save"/> &nbsp;<input type="reset" value="Cancel"/>

                    </form>
            </div>
            <%@include file="/components/footer.jsp" %>

        </div>
    </body>
    
    
</html>


