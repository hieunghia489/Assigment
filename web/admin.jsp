<%-- 
    Document   : admin
    Created on : Aug 19, 2022, 3:10:05 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1 style="text-align: center">ADMIN PAGE</h1>
        <h2 style="text-align: center">Welcome ${sessionScope.NAME}</h2>
        <c:set var="List_Course" value="${sessionScope.LIST_COURSE}"/>

        <H2>Course information : </H2>
        <form action="MainController">
            <input type="hidden" name="role" value="admin.jsp" />
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
            <input type="submit" value="Create Course" name="btAction" />
           
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
                        <th>Creator </th>
                        <th>Create date</th>
                        <th>Last update by</th>
                        <th>Last update on</th>
                        <th>Status</th>
                        <th>Update</th>
                        <th>Note</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="course" items="${List_Course}" varStatus="counter">
                        <c:if test="${course.status}">
                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td>
                                <td><input type="text" name="courseName" value="${course.courseName}" style="width: 100px"/> </td>
                                <td> <img src="image/${course.imageCourse}" alt="${counter.count}" width="100" height="100"> </td>
                                <td><input type="text" name="description" value="${course.description}"/></td>
                                <td><input type="number"  name="tuitionFee" step="10000" value="${course.tuitionFee}" style="width: 100px"/></td>
                                <td><input type="date" name="startDate" value="${course.startDate}" /></td>
                                <td><input type="date" name="endDate" value="${course.endDate}"/></td>
                                <td>
                                    <select name="category">
                                        <c:forEach var="cate" items="${sessionScope.CATEGORY}">
                                            <c:if test="${cate == course.category}">
                                                <option selected="">${course.category}</option>
                                            </c:if>
                                            <c:if test="${cate != course.category}">
                                                <option>${cate}</option>
                                            </c:if>

                                        </c:forEach>
                                    </select>
                                </td>
                                <td>${course.quantity}/<input type="number" name="maxQuantity" style="width: 30px" value="${course.maxQuantity}"/></td>
                                <td>${course.createUser}</td>
                                <td>
                                    <input type="date" name="createDate" value="${course.createDate}" readonly=""/>
                                </td>
                                <td>
                                    ${course.lastUpdateUser}
                                    <input type="hidden" name="lastUserUpdate" value="${cookie.USER.value}" />
                                </td>
                                <td><input type="date" name="lastUpdateDate" value="${course.lastUpdateDate}" readonly=""/></td>
                                <td> <select name="status">
                                        <option style="color: green">Active</option>
                                        <option style="color: red">Close</option>
                                    </select> </td>
                                <td><input type="submit" value="Update" name="btAction" /></td>
                                <td>
                                    <c:if test="${course.courseName eq param.oldCourseName}">
                                    <c:if test="${not empty requestScope.MESSAGE.courseNameError}">
                                        ${requestScope.MESSAGE.courseNameError} <br/>
                                    </c:if>
                                    <c:if test="${not empty requestScope.MESSAGE.descriptionError}">
                                        ${requestScope.MESSAGE.descriptionError} <br/>
                                    </c:if>
                                    <c:if test="${not empty requestScope.MESSAGE.tuitionFeeError}">
                                        ${requestScope.MESSAGE.tuitionFeeError} <br/>
                                    </c:if>
                                    <c:if test="${not empty requestScope.MESSAGE.startDateError}">
                                        ${requestScope.MESSAGE.startDateError} <br/>
                                    </c:if>
                                    <c:if test="${not empty requestScope.MESSAGE.endDateError}">
                                        ${requestScope.MESSAGE.endDateError} <br/>
                                    </c:if>
                                    <c:if test="${not empty requestScope.MESSAGE.maxQuantityError}">
                                        ${requestScope.MESSAGE.maxQuantityError} <br/>
                                    </c:if>
                                        
                                    </c:if>
                                </td>
                            <input type="hidden" name="quantity" value="${course.quantity}" />
                            <input type="hidden" name="oldCourseName" value="${course.courseName}" />
                            </tr>
                        </form>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
    </form>
</c:if>
<c:if test="${empty List_Course}">
    <br/>We can't find any similar to your searching. Please try again 
</c:if>
     <a href="LogoutController">Logout</a>
</body>
</html>
