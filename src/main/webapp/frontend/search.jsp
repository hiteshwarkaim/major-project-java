<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/common_style.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

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
                
                <c:if test="${fn:length(searchBook)==0 }">
                    <h2>No result found for "${keyword}"</h2>
                </c:if>
                <c:if test="${fn:length(searchBook)>0}">
                    <div style="width: 90%">
                        <table>
                             <c:forEach items="${searchBook}" var="book">
                            <tr>
                                <td>
                                    <a href="view-book?id=${book.b_id}">
                                        <img src="data:image/jpg;base64,${book.base64Image}" alt="image" style="width: 200px;margin: 15px;"/>
                                    </a>    
                                </td>
                                <td>
                                    <strong>
                                        <a href="view-book?id=${book.b_id}">${book.b_title}</a>
                                    </strong>
                                </td>
                                <td>Ratting *****</td>
                                <td>by ${book.author}</td>
                                <td>Rs. ${book.price}</td>
                                <td><button>Add to Cart</button></td>

                            </tr>
                            </c:forEach>
                        </table>
                     </div>
                </c:if>
                
            
            
            
            
            
            <%@include file="/components/footer.jsp" %>

        </div>
    </body>
</html>
