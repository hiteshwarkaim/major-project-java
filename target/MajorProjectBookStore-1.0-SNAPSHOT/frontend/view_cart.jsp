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
                            <table>
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
                                    <th>${status.index+1}</th>
                                    <th>${item.key.author}</th>
                                    <th>${item.value}</th>
                                    <th>Rs. ${item.key.price}</th>
                                    <th>Rs. ${item.value * item.key.price}</th>
                                    <th>
                                        <a href="">Remove</a>
                                    </th>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td>${cart.totalQuantity} book(s)</td>
                                    <td>Total</td>
                                    <td rowspan="2">${cart.totalAmount}</td>
                                </tr>
                                
                                </c:forEach>
                            </table>
                        </form>
                    </div>
                </c:if>
                
               
            </div>
            
            
                <%@include file="/components/footer.jsp" %>
            
        </div>
            
    </body>
</html>


