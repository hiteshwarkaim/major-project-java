<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/common_style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>book</title>
    </head>
    <body>
        <div align="center">
            <%@include file="/components/header_frontend.jsp" %>
            
            
            <div style="border: 1px solid black;width: 80%;">
                <table>
                    <tr>
                        <td colspan="3" align="left">
                            <h2>${book.b_title}</h2>${book.author}
                        </td>
                    </tr>
                    <tr>
                        <td rowspan="2">
                            <img src="data:image/jpg;base64,${book.base64Image}" alt="image" style="width: 400px;"/>
                        </td>
                        <td valign="top" align="left">
                            Rating *****
                        </td>
                        <td rowspan="2" valign="top" width="20%">
                            Rs. ${book.price}
                            <br>
                            <button type="submit">Add to Cart</button>
                        </td>
                        
                    </tr>
                    <tr>
                        <td valign="top">
                            ${book.desc}
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td><h2>Customer Review</h2></td>
                        <td colspan="2" align="center">
                            <button>Write a Customer Review</button>
                        </td>
                    </tr>
                </table>
            </div>
            
            
            
            
            <%@include file="/components/footer.jsp" %>

        </div>
    </body>
</html>
