<%
   String msg=(String)session.getAttribute("message");
   
    if(msg!=null)
    {
       // print
 %>
 
 <html>
     <head>
         
     </head>
     <body>
         <script type="text/javascript">
            let s="<%= msg %>";     //convert jsp variable into javascript variable
            alert("Alert!!!  :"+s);
        </script>
                                <!--OR-->
<!--        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong><%=msg%></strong> 
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>-->
         
     </body>
     
 </html>
        
 <%
        
        session.removeAttribute("message");
    }
%>