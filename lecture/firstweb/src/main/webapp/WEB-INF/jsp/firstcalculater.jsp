<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>First Web Application</title>
</head>
<body>

<h2>四則演算アプリ</h2>

<form action="/firstweb/firstcalculater" method="POST">

    <input type="text" name="num1" value="${num1}">
    <select name="calculater">
    <option value="+">+</option>
    <option value="-">-</option>
    <option value="*">*</option>
    <option value="/">/</option>
    </select>
    <input type="text" name="num2" value="${num2}">
    <button type="submit">＝</button>
    ${result}
</form>

</body>
</html>


