<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>Route</title>
</head>
<body>
    Всі пробки<br><br>
<#list traficJemTitle as eltraficJem>
     <b>Id: </b>${eltraficJem.idTraficJem}<br>
     <b>Начало пробки: </b>${eltraficJem.startPoint}<br>
     <b>Конец пробки: </b>${eltraficJem.endPoint}<br>
     <a href="/traficJem/${eltraficJem.idTraficJem}">Подробнее...</a><br>
</#list>
<hr>
<#if role == "transport_officer">
    <h3>Добавить пробку</h3>
    <form action="/traficJem/create" method="post" enctype="multipart/form-data">
        Id: <input type="number" name="idTraficJem"/><br><br>
        Остановка: <input type="text" name="stop"/><br><br>
        Дата возникновения пробки: <input type="date" name="dateTraficJem"/><br><br>
        Начальная точка: <input type="text" name="startPoint"/><br><br>
        Конечная точка: <input type="text" name="endPoint"/><br><br>
        Номер остановки: <input type="number" name="numberStop"/><br><br>
        Время начала: <input type="time" name="timeStart"/><br><br>
        Время конца: <input type="time" name="timeEnd"/><br><br>
        Степень: <input type="number" name="extent"/><br><br>
        Id сотрудника: <input type="number" name="numberEmployee"/><br><br>
        <input type="submit" value="Добавить остановку"/>
    </form>
</#if>
<hr>
</body>
</html>