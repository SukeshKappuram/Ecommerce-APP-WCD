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
            <%@include file="ViewProducts.jsp" %>
        </div>
            <%@include file="footer.jsp" %>
    </body>
</html>
