<%-- 
    Document   : ViewProducts
    Created on : May 3, 2017, 12:56:48 PM
    Author     : iamsu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="Container">
                 <div class="row">
                     <c:forEach var='p' items="${products}">
                         <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <img src="https://lareviewofbooks-org-cgwbfgl6lklqqj3f4t3.netdna-ssl.com/wp-content/uploads/2012/08/Television.jpg" alt="..." >
                                <div class="caption">
                                    <h3>${p.name}</h3>
                                    <p>Rs. ${p.price}</p>
                                    <p><a href="Cart?m=a&&u=${user.id}&&p=${p.id}" class="btn btn-primary" role="button">Add to Cart</a> 
                                       <a href="Cart?m=p&&u=${user.id}&&p=${p.id}" class="btn btn-default" role="button">Buy Now</a></p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
        </div>
    </body>
</html>
