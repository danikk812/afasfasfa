
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="/WEB-INF/logo.tld" %>
<html>
<head>
    <title>Log In</title>
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
        <h1>Log In</h1>
        <br />
    </div>
    <div>
        <form name="login" action="login" method="post">
            <div>
                <p>Enter your email:</p>
                <input required type="email" name="email" value="<c:out value="${email}"/>">
            </div>
            <br /><br />
            <div>
                <p>Enter your password:</p>
                <input required type="password" name="password" value="<c:out value="${password}"/>">
            </div>
            <div>
                <label><button type="submit">Submit</button></label>
            </div>
        </form>
    </div>
</div>

</body>
</html>
