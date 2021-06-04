<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Floor and features</title>
</head>
<body>
<%@ include file="_header.jsp"%>
<%! int floors = 10; %>
<%
    request.setAttribute("floors", floors);
%>
<div class="container">
    <form action="/floorAndFeatures" method="post">
        <div class="mb-3">
            <p>Select floor:</p>
            <c:forEach var="floor" begin="1" end="${floors}">
                <div class="form-check">
                    <input class="form-check-input" type="radio" value="${floor}" name="floor" id="flexRadioDefault1">
                    <label class="form-check-label" for="flexRadioDefault1">
                            ${floor}
                    </label>
                </div>
            </c:forEach>
        </div>
        <div class="mb-3">
            <p>Select features:</p>
            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" value="true" name="conditioner"
                       id="flexSwitchCheckDefault1">
                <label class="form-check-label" for="flexSwitchCheckDefault1">Conditioner</label>
            </div>
            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" value="true" name="extraBathroom"
                       id="flexSwitchCheckDefault2">
                <label class="form-check-label" for="flexSwitchCheckDefault2">Extra bathroom</label>
            </div>
        </div>
        <p style="color: red">${requestScope.floorError}</p>
        <button class="btn btn-primary" type="submit">Submit</button>
    </form>
</div>
</body>
</html>
