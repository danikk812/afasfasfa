
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client wishes</title>
</head>
<body>
<%@ include file="_header.jsp"%>
<div class="container">
    <form action="/clientWishes" method="post">
        <div class="mb-3">
            <p>Write your wishes:</p>
                <label for="exampleFormControlTextarea1" class="form-label">Your wishes</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="5" name="clientWishes"></textarea>
        </div>
        <button class="btn btn-primary" type="submit">Submit</button>
    </form>
</div>
</body>
</html>
