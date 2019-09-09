<%--
  Created by IntelliJ IDEA.
  User: Gleb
  Date: 16.04.2019
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Title</title>
</head>
<body>
<H2>Welcome ${name}</H2>
<div>
    <table border="1">
        <caption>Список вашей группы</caption>
        <tr>
            <th>Имя</th>
            <th>Телефон</th>
            <th>email</th>
        </tr>
        <c:forEach items="${group}" var="person">
            <tr><td>${person.name}</td>
                <td>${person.phone}</td>
                <td>>${person.email}</td>
            </tr>
        </c:forEach>
    </table>
    <p><font color="red">${errorMessage}</font></p>
    <form method="POST" action="GroupServlet">
        Новый :
        <p> Введите имя <input name="nname" type="text" /> </p>
        <p> Введите телефон <input name="nphone" type="text" /> </p>
        <p> Введите email <input name="nemail" type="text" /> </p>
        <input name="add" type="submit" />
    </form>
</div>
</body>
</html>
</html>