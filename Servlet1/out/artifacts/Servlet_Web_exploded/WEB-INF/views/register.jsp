<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous" ></script>
    <%--<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">--%>
    <script src="webjars/jquery/3.3.1/jquery.min.js"></script>
    <%--<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>--%>

    <link rel="stylesheet" type="text/css" href="<c:url value="/style.css"/>">

</head>
<body>

<div class="container m_register">
    <div id="login">
        <h1>Регистрация</h1>
        <p class=error><span>${errorRegister}</span></p>

        <form id="register_form" action="${pageContext.servletContext.contextPath}/controller?command=register_new_user" method="POST">
            <p><span>Введите Имя: </span><input type="text" name="newLoginName"></p>
            <p><span>Введите Пароль: </span><input type="password" name="newPassword"></p>
            <p class="submit"><input class="button" type="submit" value="Зарегистрировать"></p>

        </form>

    </div>
</div>

<div>
    <footer class="footer">
        <div><p> © 2019 Все права защищены</p></div>
    </footer>
</div>

</body>
</html>
