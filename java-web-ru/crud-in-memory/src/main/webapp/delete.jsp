<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Пользователь ${id}</title>
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
                <h2>Пользователь будет удален</h2>
                    <c:forEach var="field" items="${user.keySet()}">
                                            <tr>
                                                <td>${field}</td>
                                                <td>${user.get(field)}</td>
                                            </tr>
                                    </c:forEach>
            </table>
            <form method="post" action='/users/delete?id=${user.get("id")}'>
                 <button type="submit" class="btn btn-danger">Удалить</button>
            </form>
        </div>
    </body>
</html>
