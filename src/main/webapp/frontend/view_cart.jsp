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
                <h2>Cart details</h2>
                
                <c:set var="cart" value="${sessionScope['cart']}"/>
              
                <c:if test="${cart.totalItems==0}">
                    <h2>there is no item in the cart</h2>
                </c:if>
                <c:if test="${cart.totalItems>0}">
                    <div>
                        <form>
                            <table width="1200" style="border: 1px solid black;">
                                <tr>
                                    <th>No</th>
                                    <th>Book</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                    <th>Subtotal</th>
                                    <th>
                                        <a href="">Clear Cart</a>
                                    </th>
                                </tr>
                                
                                <c:forEach var="item" items="${cart.items}" varStatus="status">
                                    
                                <tr>
                                    <td>${status.index+1}</td>
                                    <td>
                                        <img src="data:image/jpg;base64,${item.key.base64Image}" alt="image" style="width: 100px;"/>
                                        &nbsp;&nbsp;
                                        ${item.key.author}</td>
                                    <td>${item.value}</td>
                                    <td>Rs. ${item.key.price}</td>
                                    <td>Rs. ${item.value * item.key.price}</td>
                                    <td>
                                        <a href="">Remove</a>
                                    </td>
                                </tr>
                                </c:forEach>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td>${cart.totalQuantity} book(s)</td>
                                    <td>Total</td>
                                    <td rowspan="2">${cart.totalAmount}</td>
                                </tr>
                                
                                
                            </table>
                        </form>
                    </div>
                </c:if>
                
               
            </div>
            
            
                <%@include file="/components/footer.jsp" %>
            
        </div>
            
    </body>
</html>


