<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Войти</title>
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

<div class="container m_login">
    <div id="login">
        <h1>Вход</h1>
        <p class=error><span>${errorMessage}</span></p>

        <form id="login_form" action="${pageContext.servletContext.contextPath}/controller?command=login" method="POST">
            <p><span>Имя:</span><input class="input" type="text" size="18" name="loginName"></p>
            <p><span>Пароль:</span><input class="input" type="password" size="18" name="password"></p>
            <p class="reg_text">Еще не зарегистрированы? <a href="${pageContext.servletContext.contextPath}/controller?command=registration_page">Регистрация</a></p>
            <p class="submit"><input class="button" type="submit" value="Войти"></p>
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
