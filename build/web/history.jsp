<%-- 
    Document   : history
    Created on : Sep 13, 2022, 6:09:24 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="Nghialh.booking.BookingDAO"%>
<%@page import="Nghialh.bookingDetail.BookingDetailDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title>
    </head>
    <body>
        <h1>Booking History</h1>
        <h3>Customer : ${sessionScope.NAME}</h3>
        <c:set var="daoBook" value="${BookingDAO()}"/>
        <c:set var="list" value="${daoBook.getAllBookingByUserName(param.customer)}"/>
        <c:if test="${not empty list}">
            <c:set var="daoDetail" value="${BookingDetailDAO()}"/>
            <table border="1">
                <thead>
                    <tr>
                        <th>Book ID</th>
                        <th>Detail</th>
                        <th>Booked on</th>
                        <th>Fee</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="booking" items="${list}" >
                        <tr>
                            <td>${booking.ID}</td>
                            <td>
                                <c:set var="listDetail" value="${daoDetail.getDetailByID(booking.ID)}"/>
                                <table border="0">
                                    <tbody> <c:forEach var="detail" items="${listDetail}">
                                            <tr>
                                                <td>${detail.courseName}</td>
                                                <td>${detail.startDate} - ${detail.endDate}</td>
                                                <td>${detail.fee}đ</td>
                                                <td> ( Booked : ${detail.quantity} / ${detail.maxQuantity} slots )</td>
                                            </tr>
                                        </tbody>
                                    </c:forEach> </table

                            </td>
                            <td>${booking.bookDate}</td>
                            <td>${booking.money}đ</td>
                        </tr> 
                    </c:forEach>
                </tbody>
            </table> 
        </c:if>
        <c:if test="${ empty list}">
            This customer didn't  book any course
        </c:if>
                    <form action="MainController">
                             <input type="submit" value="Continue booking" name="btAction" />
                            <input type="hidden" name="customer" value="${cookie.USER.value}" />
                    </form>
    </body>
</html>
