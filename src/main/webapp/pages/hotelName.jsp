<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.bsuir.model.Hotel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel name</title>
</head>
<body>
<%@ include file="_header.jsp"%>
<%
    List<Hotel> hotels = Arrays.asList(
            new Hotel("Mariott", new File("/image/mariott.jpg")),
            new Hotel("Victoria", new File("/image/victoria.jpg")),
            new Hotel("Beijing", new File("/image/beijing.jpg"))
    );
    session.setAttribute("hotels", hotels);
%>
<div class="container">
    <form action="/hotel" method="post">
        <div class="mb-3">
            <label for="select1" class="form-label">Hotel name</label>
            <select id="select1" class="form-select" required name="hotelName">
                <c:forEach var="hotel" items="${hotels}">
                    <option value="${hotel.hotelName}">${hotel.hotelName}</option>
                </c:forEach>
            </select>
        </div>
        <p style="color: red">${requestScope.hotelNameError}</p>
        <button class="btn btn-primary" type="submit">Submit</button>
    </form>
</div>
</body>
</html>
