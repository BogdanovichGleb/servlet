<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Войти</title>
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

<p><span style="color: red; "> ${errorMessage}</span></p>

<form action="LoginServlet" method="POST">

    <p>Имя: <input type="text" name="name"></p>
    <p>Пароль: <input type="password" name="pass"></p>
    <input type="submit">

</form>

<div>
    <form action="RegisterServlet" method="GET">
        <input class="button-main-page" type="submit" value="Регистрация"/>
    </form>
</div>


</body>
</html>
