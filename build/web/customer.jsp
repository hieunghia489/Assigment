<%-- 
    Document   : user
    Created on : Aug 19, 2022, 3:10:11 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Page</title>
    </head>
    <body>
        <h1 style="text-align: center">CUSTOMER PAGE</h1>
        <h2 style="text-align: center">Welcome ${sessionScope.NAME}</h2>
        <c:if test="${not empty sessionScope.NAME}">
            <form action="MainController">
                <input type="hidden" name="customer" value="${cookie.USER.value}" />
            <input type="submit" value="History" name="btAction" /> 
            </form>
        </c:if>
        <c:set var="List_Course" value="${sessionScope.LIST_COURSE}"/>
        <c:set var="Cart" value="${sessionScope.CART}"/>
        <H2>Course information : </H2>
        <form action="MainController">
            <input type="hidden" name="role" value="customer.jsp" />
            Search course: 
            Name : <input type="text" name="searchValue" value="${param.searchValue}" />  Category <select name="searchCate">
                <option></option>
                <c:forEach var="cate" items="${sessionScope.CATEGORY}">
                    <c:if test="${cate == param.searchCate}">
                        <option selected="">${param.searchCate}</option>
                    </c:if>
                    <c:if test="${cate != param.searchCate}">
                        <option>${cate}</option>
                    </c:if>
                </c:forEach>
            </select>
            <input type="submit" value="Search" name="btAction" />
        </form>
        <c:if test="${not empty List_Course}">
            <table border="1" style="text-align: center">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Course</th>
                        <th>Image</th>
                        <th>Description</th>
                        <th>Fee</th>
                        <th>Start</th>
                        <th>End</th>
                        <th>Category</th>
                        <th>Quantity</th>
                        <th>Status</th>
                        <th>Booking</th>
                        <th>Note</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="course" items="${List_Course}" varStatus="counter">
                        <c:if test="${course.status}">
                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${course.courseName}</td>
                                <td> <img src="image/${course.imageCourse}" alt="${counter.count}" width="100" height="100"> </td>
                                <td>${course.description}</td>
                                <td>${course.tuitionFee}đ</td>
                                <td><input type="date" name="startDate" value="${course.startDate}" readonly="" /></td>
                                <td><input type="date" name="endDate" value="${course.endDate}" readonly=""/></td>
                                <td>${course.category}  </td>
                                <td>${course.quantity}/${course.maxQuantity}</td>
                                <c:if test="${course.quantity==course.maxQuantity}">
                                    <td style="color: red"> Full  </td>
                                    <td></td>
                                </c:if>
                                <c:if test="${course.quantity<course.maxQuantity}">
                                    <td style="color: green"> Available ( ${course.maxQuantity-course.quantity} slots left)  </td>
                                    <c:if test="${not empty Cart.items}">
                                        <c:if test="${Cart.items.containsKey(course.courseName)}">
                                            <td><input type="submit" value="-" name="btAction"/> ${Cart.items.get(course.courseName)} 
                                                <c:if test="${Cart.items.get(course.courseName) < (course.maxQuantity-course.quantity)}" >
                                                    <input type="submit" value="+" name="btAction" />
                                                </c:if>
                                            </td>
                                            <c:if test="${course.courseName == param.courseName && not empty requestScope.Error}">
                                                <td>${requestScope.Error}</td>
                                            </c:if>
                                            <c:if test="${!course.courseName == param.courseName ||  empty requestScope.Error}">
                                                <td style="color: greenyellow">Booking...</td>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${!Cart.items.containsKey(course.courseName)}">
                                            <td><input type="submit" value="-" name="btAction" readonly=""/> 0 <input type="submit" value="+" name="btAction" /> </td>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${ empty Cart.items}">
                                        <td><input type="submit" value="-" name="btAction" readonly=""/> 0 <input type="submit" value="+" name="btAction" /> </td>
                                        </c:if>

                                </c:if>
                            </tr>
                            <input type="hidden" name="courseName" value="${course.courseName}" />
                            <input type="hidden" name="slot" value="${course.maxQuantity-course.quantity}" />
                            <input type="hidden" name="role" value="customer.jsp" />
                            <input type="hidden" name="searchValue" value="${param.searchValue}" />
                            <input type="hidden" name="searchCate" value="${param.searchCate}" />
                        </form>
                    </c:if>

                </c:forEach>
            </tbody>
        </table>
        <form action="MainController">
            <input type="submit" value="Confirm Booking" name="btAction" />
        </form>
    </c:if>
    <c:if test="${empty List_Course}">
        <br/>We can't find any similar to your searching. Please try again 
    </c:if>
    <c:if test="${not empty sessionScope.NAME}"> <br/><a href="LogoutController">Logout</a></c:if>
    <c:if test="${empty sessionScope.NAME}"> <br/><a href="login.jsp">Return to login page</a></c:if>
</body>
</html>
