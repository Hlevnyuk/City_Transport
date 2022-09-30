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
     <b>Время начала: </b>${eltraficJem.timeStart}<br>
     <b>Время конца: </b>${eltraficJem.timeEnd}<br>
     <b>Остановка: </b>${eltraficJem.address}<br>
     <a href="/traficJem/${eltraficJem.idTraficJem}">Подробнее...</a><br>
</#list>
<hr>
<#if role == "transport_employee">
    <h3>Добавить пробку</h3>
    <form action="/traficJem/create" method="post" enctype="multipart/form-data">
        Id: <input type="number" name="idTraficJem"/><br><br>
        Время начала: <input type="time" name="timeStart"/><br><br>
        Время конца: <input type="time" name="timeEnd"/><br><br>
        Остановки: <br><br>
        <select name = "numberStop">
           <#list stop as item>
               <option value = "${item.numberStop}" name="${item.numberStop}"> ${item.numberStop} - ${item.address}</option>
           </#list>
        </select>
        Номер работника: <input type="number" name="numberEmployee"/><br><br>
        <input type="submit" value="Добавить остановку"/>
    </form>
</#if>
<hr>
</body>
</html>