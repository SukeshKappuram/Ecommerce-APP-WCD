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
        <%
            User user=(User)session.getAttribute("user");
            
        %>
        <div class='header'>
            Flipcart
        </div>
            <nav>
                <a href='#'>Home</a>
                <a href='#'>About</a>
                <a href='#'>Contact Us</a>
                <a href='#'>Feedback</a>
                <a href='logout.jsp'>Logout</a>
            </nav>
        
        <div class='content'>
            <p>Hi <%=user.getFirstName()+" "+user.getLastName()%> !!</p>
            <%=request.getParameter("n")%>
            
            <%
                Cookie[] cookies=request.getCookies();
                for(Cookie c:cookies){
                    if(c.getName().equals("mail")){
                        out.println(c.getValue());
                    }
                }
            %>
            
        </div>
        <div class='footer'>
            &copy Copyright to NIIT. All rights received 2017
        </div>
    </body>
</html>
