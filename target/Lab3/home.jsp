<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="custom" uri="/WEB-INF/logo.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
    session.setAttribute("film", names);
%>
<div class="center">
    <div style="align-content: center">
        <custom:logo heading="1" image="movie.jpg" width="600" height="250">My MovieStore</custom:logo>
    </div>
    <h1>${sessionScope.user.email}</h1>
    <table>
        <tr><td>Favourite producer:</td><td>${sessionScope.user.preference.favProducer}</td></tr>
        <tr><td>Favourite movie genre:</td><td>${sessionScope.user.preference.favGenre}</td></tr>
        <tr><td>Preference:</td><td>${sessionScope.user.preference.preference}</td></tr>
        <tr><td>Watch films at home:</td><td>${sessionScope.user.preference.home}</td></tr>
        <tr><td>Watch films at cinema:</td><td>${sessionScope.user.preference.cinema}</td></tr>
        <tr>
            <td><button onclick="document.location='change.jsp'">Change params</button></td>
            <td>
                <form name="logoff" action="logoff">
                    <button type="submit">Log Off</button>
                </form>
            </td>
        </tr><br />
    </table>
</div>

</body>
</html>
