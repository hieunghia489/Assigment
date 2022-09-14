<%-- 
    Document   : confirm
    Created on : Aug 24, 2022, 11:29:12 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="Nghialh.course.CourseDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Page</title>
    </head>
    <body>
        <c:set var="Cart" value="${sessionScope.CART}"/>
        <c:if test="${not empty Cart}">
            <table border="1" style="text-align: center">
                <thead>
                    <tr>
                        <th colspan="4">Finally Booking Form</th>
                    </tr>
                    <tr>
                        <th>Course</th>
                        <th>Quantity</th>
                        <th>Tuition fee</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody> 
                    <c:set var="dao" value="${CourseDAO()}"/>
                    <c:set var="money" value="0"/>
                    <c:forEach var="item" items="${Cart.items}">
                        <c:set var="course" value="${dao.getCourse(item.key)}"/>
                        <tr>
                            <td>${item.key}</td>
                            <td>${item.value}</td>
                            <td>${course.tuitionFee}đ</td>
                            <td>${item.value*course.tuitionFee}đ</td>
                        </tr>
                        <c:set var="money" value="${money+item.value*course.tuitionFee}"/>
                    </c:forEach>
                    <tr>
                        <td colspan="3">Total Bill : </td>
                        <td >${money} đ</td>
                    </tr>
                    <c:if test="${not empty cookie.USER.value}">
                        <tr>
                            <td colspan="4">Customer's Information : ${sessionScope.NAME} ( ID : ${cookie.USER.value} )</td>
                        </tr>
                        <tr>
                    <form action="MainController">
                            <td colspan="2"> <input type="submit" value="Continue booking" name="btAction" /></td>
                            <td colspan="2"> <input type="submit" value="Confirm booking" name="btAction" /></td> 
                            <input type="hidden" name="customer" value="${cookie.USER.value}" />
                            <input type="hidden" name="money" value="${money}" />
                    </form>
                        </tr>
                    </c:if>
                    <c:if test="${ empty cookie.USER.value}">
                        <tr>
                            <td colspan="2">Not login yet</td>
                            <td colspan="2"><a href="login.jsp">Click here !!!</a></td>
                        </tr>
                    </c:if>
                        
                </tbody>
            </table> 

        </c:if>
        <c:if test="${empty Cart}">
            <c:redirect url="SearchController?searchValue=&searchCate=&role=customer.jsp"/>
        </c:if>

    </body>
</html>
