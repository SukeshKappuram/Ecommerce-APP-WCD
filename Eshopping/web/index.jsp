<%-- 
    Document   : index
    Created on : Mar 30, 2017, 7:20:13 PM
    Author     : iamsu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <%@include file="header.jsp" %>
        <c:if test="${not empty user}">
            <% response.sendRedirect("Welcome.jsp"); %>
        </c:if>
        <div class='content'>
            <img src='http://img01.ibnlive.in/ibnlive/uploads/2015/07/online-shopping.jpg' alt="Login Image" style="width: 48%;"/>
            <c:if test="${not empty param.shw}">
            <div style="width: 45%;float: right">
        <form action="User.do" method="post">
            <fieldset>
                <legend>Login</legend>
            <table border="0" align='center'>
                    <thead>
                        <tr>
                            <th></th>
                        </tr>
                    </thead>
                        <tr>
                            <td>
                                <input type="email" name="mailId" placeholder="Mail Id" required="required"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                 <input type="password" name="password" placeholder="Password" required="required"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                               <input type="submit" value="Login" />
                               <input type="reset" value="Cancel" />
                            </td>
                        </tr>
                    </tbody>
                </table>
            </fieldset>
            </form>
        </c:if>
        <c:if test="${empty param.shw}">
        <form action="User.do" method="post">
            <fieldset>
                <legend>Sign Up here</legend>
                <table border="0" align='center'>
                    <thead>
                        <tr>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <input type="text" name="firstName" placeholder="First Name" required="required"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="text" name="lastName" placeholder="Last Name" required="required"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="email" name="mailId" placeholder="Mail Id" required="required"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Gender</label>
                                <input type="radio" name="Gender" value="Male" checked="checked" />Male
                                <input type="radio" name="Gender" value="Female" />Female
                            </td>
                        </tr>
                        <tr>
                            <td>
                                 <input type="password" name="password" placeholder="Password" required="required"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                               <input type="submit" value="SignUp" />
                               <input type="reset" value="Cancel" />
                            </td>
                        </tr>
                    </tbody>
                </table>
        </fieldset>    
        </form>
            </c:if>
         </div>   
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>