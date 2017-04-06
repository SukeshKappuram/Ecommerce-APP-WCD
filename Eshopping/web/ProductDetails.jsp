<%-- 
    Document   : ProductDetails
    Created on : Apr 4, 2017, 5:05:06 PM
    Author     : iamsu
--%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="add">
                <form action="ProductDetails?m=c" method="post" >
                    <fieldset style="width:300px;text-align: center;">
                        <legend>Product Details</legend>
                        <input type="text" name="serailNumber" placeholder="Serail Number" value="${productDetails.serailNumber}" /><br/><br/>
                        <input type="date" name="manufactureDate" placeholder="Manufacture Date" value="${productDetails.manufactureDate}" /><br/><br/>
                        <input type="date" name="expieryDate" placeholder="Expiery Date" value="${productDetails.expieryDate}" /><br/><br/>
                        <input type="text" name="size" placeholder="Size" value="${productDetails.size}" /><br/><br/>
                        <input type="text" name="color" placeholder="Color" value="${productDetails.color}" /><br/><br/>
                        <input type="text" name="sellerId" placeholder="seller" value="${productDetails.sellerId}" readonly/><br/><br/>
                        <select name="productId">
                            <c:if test="${not empty productDetail}">
                                <option value="${productDetail.id}">${productDetail.name}</option>
                            </c:if>
                            <c:forEach var="p" items="${products}">
                                <option value="${p.id}">${p.name}</option>
                            </c:forEach>
                        </select><br/><br/>
                        <c:if test="${empty product}">
                            <input type="submit" value="Add Product Details" />
                        </c:if>
                        <c:if test="${not empty product}">
                            <input type="submit" value="Update Product Details" formaction="Product?m=u&&id=${product.id}"/>
                        </c:if>
                    </fieldset>
                </form>
            </div><br/>
            <div id="view">
                <table border="1" align='center'>
                    <thead>
                        <tr>
                            <th>Product Serail Number</th>
                            <th>Product Id</th>
                            <th>Mafc. Date</th>
                            <th>Expy. Date</th>
                            <th>Size</th>
                            <th>Color</th>
                            <th>Edit</th>
                            <th>Delete</th>
                            <th>View</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var='p' items="${productDetails}">
                        <tr>
                            <td>${p.serialNumber}</td>
                            <td>${p.productId}</td>
                            <td>${p.manufactureDate}</td>
                            <td>${p.expieryDate}</td>
                            <td>${p.size}</td>
                            <td>${p.color}</td>
                            <td><a href="Product?m=e&&id=${p.id}"> edit </a></td>
                            <td><a href="Product?m=d&&id=${p.id}"> X </a></td>
                            <td><a href='Products?id=${p.id}'>View Products</a></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
    </body>
</html>
<%@include file="footer.jsp" %>
