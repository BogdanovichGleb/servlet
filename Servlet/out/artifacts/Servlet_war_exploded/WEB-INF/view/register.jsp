
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>
        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 60px;
            background-color: #f5f5f5;
        }

        .footer .container {
            width: auto;
            max-width: 680px;
            padding: 0 15px;
        }     </style>
</head>
<body>

<p><span style="color: red; "> ${errorRegister}</span></p>

<form action="RegisterServlet" method="POST">
    <p>Pегистрация нового пользователя</p>
    <p>Введите Имя: <input type="text" name="newLoginName"></p>
    <p>Введите Пароль: <input type="password" name="newPassword"></p>
    <input class ="button-main-page" type="submit" value="Зарегистрировать">

</form>


</body>
</html>
