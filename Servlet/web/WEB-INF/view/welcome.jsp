
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<body>
<head>
    <title>Welcome</title>
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

<nav role="navigation" class="navbar navbar-default">

    <div class="">
        <img src="https://www.kv.by/sites/default/files/user7743/logo_iba_group.jpg" width="50" height="50">
    </div>

    <div class="navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active">
                <a href="#">Home</a>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="LoginServlet">Login</a>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="LogoutServlet">Logout</a>
            </li>
        </ul>


    </div>

</nav>
<div class="container">

    <H2>Welcome ${username}</H2>

    <p><span style="color: blue; ">${lastdate}</span></p>
    <div action="delete">

        <table border="1">
            <caption> Список вашей группы</caption>

            <tr>
                <th>Имя</th>
                <th>Телефон</th>
                <th>Email</th>

            </tr>
            <c:forEach items="${group}" var="person">
                <tr>
                    <th>${person.name}</th>
                    <th>${person.phone}</th>
                    <th>${person.email}</th>
                </tr>
            </c:forEach>
        </table>

        <p><span style="color: red; ">${errorMessage}</span></p>
        <form method="POST" action="ListServlet">
            <p>Новый :</p>
            <p> Введите имя <input name="nname" type="text"/></p>
            <p> Введите телефон <input name="nphone" type="text"/></p>
            <p> Введите email <input name="nemail" type="text"/></p>
            <input name="add" type="submit"/>
        </form>

    </div>


    <footer class="footer">
        <div class="container"><p>2019 Все права защищены</p></div>
    </footer>

</div>
</body>


</html>
