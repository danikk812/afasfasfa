<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JDK class methods</title>
    <style>
        table {
            border: 4px double black;
            border-collapse: collapse;
        }

        th {
            background: #ccc;
            padding: 5px;
            border: 1px solid black;
        }

        td {
            padding: 5px;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h3>${requestScope.className} Methods Summary</h3>
<table>
    <thead>
    <th>Methods</th>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.methods}" var="method">
        <tr>
            <td>${method}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
