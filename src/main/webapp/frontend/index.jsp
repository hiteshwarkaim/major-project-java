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
            <h2>New arrival</h2>
            <c:forEach items="${listNewBook}" var="book">
                <div style="display: inline-block">
                    <div>
                        <a href="view-book?id=${book.b_id}">
                            <img src="data:image/jpg;base64,${book.base64Image}" alt="image" style="width: 200px;margin: 15px;"/>
                        </a>
                    </div>
                    <div>
                        <strong>
                            <a href="view-book?id=${book.b_id}">${book.b_title}</a>
                        </strong>
                    </div>
                    <div>Ratting *****</div>
                    <div>by ${book.author}</div>
                    <div>Rs. ${book.price}</div>
                </div>
            </c:forEach>
            
            <h2>best selling</h2>
            <h2>top selling</h2>
            
            
            <%@include file="/components/footer.jsp" %>

        </div>
    </body>
</html>
