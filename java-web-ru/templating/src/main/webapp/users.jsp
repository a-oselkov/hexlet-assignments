<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- BEGIN -->
<!DOCTYPE html>
<html>
    <head>
        <title>Users</title>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <a href="/">Главная</a>
            <style>
                table {border: 1px solid grey;}
                th {border: 1px solid grey;}
                td {border: 1px solid grey;}
                table {width: 30%;}
            </style>
            <table>
                <colgroup>
                     <col style="background-color:LightCyan">
                     <col style="background:Khaki">
                </colgroup>
                <tr>
                    <th style="background-color:yellow">id</th>
                    <th style="background-color:yellow" >Пользователь</th>
                </tr>
                <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.get("id")}</td>
                    <td><a href='/users/show?id=${user.get("id")}'>
                            ${user.get("firstName")} ${user.get("lastName")}
                        </a>
                    </td>
                </tr>
                </c:forEach>

            </table>
        </div>
    </body>
</html>
<!-- END -->
