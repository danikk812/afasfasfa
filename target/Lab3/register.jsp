
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="/WEB-INF/logo.tld" %>

<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="reset.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="center">
    <div style="align-content: center">
        <custom:logo heading="1" image="movie.jpg" width="600" height="250">My MovieStore</custom:logo>
        <br />
    </div>
    <div>
        <h1>Register</h1>
        <br />
    </div>
    <div>
        <c:if test="${! (empty requestScope.errorMsg)}">
            <div>
                <p>Please enter values correctly</p>
            </div>
        </c:if>
        <form name="register" action="register" method="post">
            <div>
                <p>Enter your email:</p>
                <input required type="email" name="email" value="${requestScope.email}">
            </div>
            <br /><br />
            <div>
                <p>Enter your password:</p>
                <input required type="password" name="password" value="${requestScope.password}">
            </div>
            <div>
                <br />
                <label><button type="submit">Submit</button></label>
            </div>
        </form>
    </div>
</div>
</body>
</html>
