<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>Route</title>
</head>
<body>
    Всі маршрути<br><br>
<#-- это тот же список for each -->
<#list routeTitle as elroute>
     <b>Номер маршрута: </b>${elroute.numberRoute}<br>
     <b>Начальная точка: </b>${elroute.startPoint}<br>
     <b>Конечная точка: </b>${elroute.endPoint}<br>
     <a href="/routes/${elroute.numberRoute}">Подробнее...</a><br>
</#list>
<hr>
<#if role == "administrator">
    <h3>Создать новый маршрут</h3>
    <form action="/route/create" method="post" enctype="multipart/form-data">
        Номер маршрута: <input type="number" name="numberRoute"/><br><br>
        Интервал: <input type="text" name="interval"/><br><br>
        Дата создания: <input type="date" name="dateTime"/><br><br>
        Администратор id: <input type="int" name="idAdministrator"/><br><br>
        Начальная остановка: <input type="number" name="startPoint"/><br><br>
        Конечная остановка: <input type="number" name="endPoint"/><br><br>
        Количество остановок: <input type="number" name="stopOrder"/><br><br>
        <input type="submit" value="Добавить маршрут"/>
    </form>
</#if>
<#if role == "administrator">
    <h3>Создать новую остановку</h3>
    <form action="/stop/add" method="post" enctype="multipart/form-data">
        Номер остановки: <input type="number" name="numberStop"/><br><br>
        Адрес: <input type="text" name="address"/><br><br>
        <input type="submit" value="Добавить остановку"/>
    </form>
</#if>
</body>
</html>