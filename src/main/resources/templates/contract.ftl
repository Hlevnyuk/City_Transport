<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>Route</title>
</head>
<body>
    Всі договори<br><br>
<#list contract as item>
     <b>Id: </b>${item.id}<br>
     <b>Фирма: </b>${item.firm}<br>
     <b>Дата заключения договора: </b>${item.dateStartContract}<br>
     <b>Дата окончания договора: </b>${item.dateEndContract}<br>
     <b>Количество заказанного транспорта: </b>${item.transportCount}<br>
     <b>Тип: </b>${item.typeTransport}<br>
     <a href="/contract/${item.id}">Подробнее...</a><br>
</#list>
<hr>
<#if role == "transport_employee">
    <h3>Создать договор</h3>
    <form action="/contract/create" method="post" enctype="multipart/form-data">
        Id: <input type="number" name="id"/><br><br>
        Фирма: <input type="text" name="firm"/><br><br>
        Дата заключения договора: <input type="date" name="dateStartContract"/><br><br>
        Дата окончания договора: <input type="date" name="dateEndContract"/><br><br>
        Количество заказанного транспорта: <input type="number" name="transportCount"/><br><br>
        <select name="typeTransport">
            <#list typeTransport as item>
                 <option value = "${item.name}"> ${item.name}</option>
            </#list>
        </select><br><br>
        <input type="submit" value="Добавить договор"/>
    </form>
</#if>
<hr>
</body>
</html>