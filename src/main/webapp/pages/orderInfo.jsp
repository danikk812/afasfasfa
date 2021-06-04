<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order information</title>
</head>
<style>
    img {
        width: 400px;
    }

    table, th, td {
        border: 2px solid black;
        border-collapse: collapse;
    }
</style>
<body>
<%@ include file="_header.jsp"%>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Characteristic</th>
            <th scope="col">Value</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Hotel name</td>
            <td>${sessionScope.hotel.hotelName}</td>
        </tr>
        <tr>
            <td>Floor</td>
            <td>${sessionScope.hotel.floor}</td>
        </tr>
        <tr>
            <td>Conditioner</td>
            <td>${sessionScope.hotel.conditioner}</td>
        </tr>
        <tr>
            <td>Extra bathroom</td>
            <td>${sessionScope.hotel.extraBathroom}</td>
        </tr>
        <tr>
            <td>Client wishes</td>
            <td>${sessionScope.hotel.clientWishes}</td>
        </tr>
        </tbody>
    </table>
    <img src="${sessionScope.hotel.image}">
</div>
</body>
</html>
