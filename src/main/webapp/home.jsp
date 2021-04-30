<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Class input</title>
</head>
<body>
<h3>Enter full class name: </h3>
<form action="/" method="post">
    <label for="classNameInput">JDK Class name:</label>
    <input id="classNameInput" type="text" name="className">
    <br><br>
    <button>Submit</button>
    <br>
    <p style="color: red">${requestScope.classNotFoundMessage}</p>
</form>
</body>
</html>
