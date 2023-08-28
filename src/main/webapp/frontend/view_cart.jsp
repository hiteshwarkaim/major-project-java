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
                        <form action="update_cart" method="post">
                            <div>
                            <table width="1200" style="border: 1px solid black;">
                                <tr>
                                    <th>No</th>
                                    <th>Book</th>
                                    <th>Quan tity</th>
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
                                    <td>
                                        <input type="hidden" name="bookId" value="${item.key.b_id}"/>
                                        <input type="text" name="quantity" value="${item.value}" size="3"/>  </td>
                                    <td>Rs. ${item.key.price}</td>
                                    <td>Rs. ${item.value * item.key.price}</td>
                                    <td>
                                        <a href="remove_from_cart?book_id=${item.key.b_id}">Remove</a>
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
                             </div>
                                
                                <div>
                                    <table>
                                        <tr>
                                            <td></td>
                                            <td><button type="submit">Update</button></td>
                                            <td><a href="${pageContext.request.contextPath}/">Continue Shopping</a></td>
                                            <td><a href="url">Checkout</a></td>
                                        </tr>
                                    </table>
                                </div>
                        </form>
                    </div>
                         
                </c:if>
                
               
            </div>
            
            
                <%@include file="/components/footer.jsp" %>
            
        </div>
            
    </body>
</html>


