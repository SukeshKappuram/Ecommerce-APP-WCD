<%-- 
    Document   : index
    Created on : Mar 2, 2017, 6:58:42 PM
    Author     : iamsu
--%>
<%@page import="com.eshopping.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <%@include file="header.jsp" %>
        <c:if test="${empty user}">
            <% response.sendRedirect("index.jsp?shw=Login"); %>
        </c:if>
        <div class='content'>
            <p>Hi ${user.firstName} ${user.lastName} !!</p>
            <%=request.getParameter("n")%>
            
            <%
                Cookie[] cookies=request.getCookies();
                for(Cookie c:cookies){
                    if(c.getName().equals("mail")){
                        out.println(c.getValue());
                    }
                }
            %>
           <c 
        </div>
            <%@include file="footer.jsp" %>
    </body>
</html>
