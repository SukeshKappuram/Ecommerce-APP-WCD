<%-- 
    Document   : header
    Created on : Mar 30, 2017, 7:18:12 PM
    Author     : iamsu
--%>

<%@page import="com.eshopping.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eshop</title>
        <style>
            .header{
                width: 100%;
                height: 50px;
                background-color: Orange;
                font-size: 50px;
                text-align: center;
                color: blue;
                padding: 15px 0px 15px 0px;
            }
            .content{
                width: 100%;
            }
            .footer{
                width: 100%;
                height: 30px;
                background-color: Orange;
                position: fixed;
                bottom: 0px;
                text-align: center;
                color: blue;
            }
            nav{
                background-color: brown;
                height: 30px;
                text-align: center;
            }
            nav a{
                font-size: 15px;
                background-color: wheat;
                padding: 5px 45px 5px 45px;
            }
        </style>
    </head>
    <body>
        <div class='header'>
            Flipcart
        </div>
            <nav>
                <a href='#'>Home</a>
                <a href='#'>About</a>
                <a href='#'>Contact Us</a>
                <a href='#'>Feedback</a>
                
                <c:if test="${empty user and empty param.shw}">
                    <a href='index.jsp?shw=Login'>Login</a>
                </c:if>
                <c:if test="${empty user and not empty param.shw}">
                    <a href='index.jsp'>Sign Up</a>
                </c:if>
                <c:if test="${not empty user}">
                        <a href='logout.jsp'>Logout</a>
                </c:if>
                        
            </nav>
    </body>
</html>
