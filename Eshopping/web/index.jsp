<%-- 
    Document   : index
    Created on : Mar 2, 2017, 6:58:42 PM
    Author     : iamsu
--%>
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
        <div class='header'>
            Flipcart
        </div>
            <nav>
                <a href='#'>Home</a>
                <a href='#'>About</a>
                <a href='#'>Contact Us</a>
                <a href='#'>Feedback</a>
            </nav>
        
        <div class='content'>
            <img src='http://img01.ibnlive.in/ibnlive/uploads/2015/07/online-shopping.jpg' alt="Login Image" style="width: 48%;"/>
            <fieldset style="width: 45%;float: right">
                <legend>Sign Up here</legend>
                <form action="Home" method="post">
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
            </form>
            </fieldset>
        </div>
        <div class='footer'>
            &copy Copyright to NIIT. All rights received 2017
        </div>
    </body>
</html>
