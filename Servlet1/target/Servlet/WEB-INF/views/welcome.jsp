<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Welcome</title>
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


<div class="row text-center d-flex justify-content-center pt-5 mb-3">

    <div class="container">

        <img src="https://www.kv.by/sites/default/files/user7743/logo_iba_group.jpg" width="50" height="50">

    </div>

    <div class="col-md-2 mb-3">
        <h6 class="text-uppercase font-weight-bold">
            <a href="#!">Home</a>
        </h6>
    </div>

    <div class="col-md-2 mb-3">
        <h6 class="text-uppercase font-weight-bold">
            <a href="${pageContext.request.contextPath}/controller?command=login_page">Lon in</a>
        </h6>
    </div>

    <div class="col-md-2 mb-3">
        <h6 class="text-uppercase font-weight-bold">
            <a href="#!">About us</a>
        </h6>
    </div>

    <div class="col-md-2 mb-3">
        <h6 class="text-uppercase font-weight-bold">
            <a href="${pageContext.servletContext.contextPath}/controller?command=sign_out">Logo ut</a>
        </h6>
    </div>
</div>
<div id="welcome">
    <H2>Welcome, ${username}</H2>

    <p></p>


    <caption> Список вашей группы</caption>
    <table border="1">

        <tr>
            <td>Имя</td>
            <td>Телефон</td>
            <td>Email</td>
        </tr>
        <c:forEach items="${group}" var="person">
            <tr>
                <td>${person.name}</td>
                <td>${person.phone}</td>
                <td>${person.email}</td>
            </tr>
        </c:forEach>

    </table>


    <div class="container">
        <p><span style="color: red; ">${errorMessage}</span></p>


        <form id="login_form" method="POST"
              action="${pageContext.servletContext.contextPath}/controller?command=add_new_person">
            <p>Новый :</p>
            <p> Введите имя <input name="nname" type="text"/></p>
            <p> Введите телефон <input name="nphone" type="text"/></p>
            <p> Введите email <input name="nemail" type="text"/></p>
            <input class="button" value="Добавить" type="submit"/>
        </form>

    </div>
    <p> ${lastdate}</p>

</div>


<div>
    <footer class="footer">
        <div><p> © 2019 Все права защищены</p></div>
    </footer>
</div>


</body>

</html>
