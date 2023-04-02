<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Добавить нового пользователя</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <a href="/users">Все пользователи</a>
            <!-- BEGIN -->
            <h3> Введите данные нового пользователя </h3>
            <font color="red">${error}</font><br>
            <form method="post" action='/users/new'>

                Имя  <input name = "firstName" placeholder="Введите имя" value="${firstName}" /><br>
                <br>
                Фамилия  <input name = "lastName" placeholder="Введите фамилию" value="${lastName}" /><br>
                <br>
                E-mail  <input name = "email" placeholder="Введите email" value="${email}" /><br>
                <br>
                <button type="submit" class="btn btn-primary">Добавить</button>
            </form>

            <!-- END -->
        </div>
    </body>
</html>
