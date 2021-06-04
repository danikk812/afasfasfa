<%@ page import="lab3.entity.Format" %>
<%@ taglib prefix="custom" uri="/WEB-INF/logo.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="reset.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="center">
    <div style="align-content: center">
        <custom:logo heading="1" image="movie.jpg" width="600" height="250">My MovieStore</custom:logo>
        <br />
    </div>
    <h2>${sessionScope.user.email}</h2>
    <br />
    <div>
        <form action="change" method="post">
            <p>Enter your favourite producer</p>
            <input name="name" value="${sessionScope.user.preference.favProducer}">
            <br /><br />
            <p>Enter your favourite movie genre</p>
            <select name="genre">
                <c:forEach var="el" items="${sessionScope.films}">
                    <option <c:if test="${el.equals(sessionScope.user.preference.favGenre)}"> selected</c:if>>${el}</option>
                </c:forEach>
            </select>
            <br /><br />
            <p>Do you prefer to watch films at cinema or at home?</p>
            <label><input type="checkbox" name="cinema" value="true"
                          <c:if test="${sessionScope.user.preference.cinema == true}">checked</c:if>
            >Cinema</label>
            <br />
            <label><input type="checkbox" name="home" value="true"
                          <c:if test="${sessionScope.user.preference.home == true}">checked</c:if>
            >Home</label>
            <br />
            <p>What format do you prefer?</p>
            <br />
            <label><input type="radio" name="format" value="full"
                          <c:if test="${sessionScope.user.preference.preference.equals(Format.FILM)}">checked</c:if>
            >Full-length film</label>
            <label><input type="radio" name="format" value="serial"
                          <c:if test="${sessionScope.user.preference.preference.equals(Format.SERIAL)}">checked</c:if>
            >Serial</label>
            <br />
            <button type="submit">Submit</button>
        </form>
    </div>
</div>


</body>
</html>


