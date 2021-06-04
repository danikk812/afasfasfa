<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
<%
    List<String> names = new ArrayList<String>();
    names.add("Action");
    names.add("Comedy");
    names.add("Horror");
    names.add("Drama");
    names.add("Science fiction");
    session.setAttribute("films", names);
%>
<div class="center">
    <div style="align-content: center">
        <custom:logo heading="1" image="movie.jpg" width="600" height="250">My MovieStore</custom:logo>
    </div>
    <form action="info" method="post">
        <p>Enter your favourite producer</p>
        <input name="name">
        <br /><br />
        <p>Enter your favourite movie genre</p>
        <select name="genre">
        <c:forEach var="genre" items="${films}">
            <option>${genre}</option>
        </c:forEach>
        </select>
        <br /><br />
        <p>Do you prefer to watch films at cinema or at home?</p>
        <label><input type="checkbox" name="cinema" value="true">Cinema</label>
        <label><input type="checkbox" name="home" value="true">Home</label>
        <br /><br />
        <p>What format do you prefer?</p>
        <br />
        <label><input type="radio" name="format" value="full" checked>Full-length film</label>
        <label><input type="radio" name="format" value="serial">Serial</label>
        <br/>
        <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>
