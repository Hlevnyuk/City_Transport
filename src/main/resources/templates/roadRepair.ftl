<!doctype html>
<html>
<head>
    <title>Route</title>
</head>
<body>
<h4>Всі ремонти доріг</h4>
<#list roadRepair as item>
    <b>Id: </b>${item.id}
    <b>Дата начала: </b>${item.dateStartRoad}<br>
    <b>Дата конца: </b>${item.dateEndRoad};<br>
</#list>
<hr>
<h3>Добавити ремонт доріг</h3>
    <form action="/roadRepair/add" method="post" enctype="multipart/form-data">
        Id: <input type="number" name="id"/><br><br>
        Остановка:
        <select name = "numberStop">
           <#list stop as item>
               <option value = "${item.numberStop}" name="${item.numberStop}"> ${item.numberStop} - ${item.address}</option>
           </#list>
        </select>
        Дата начала: <input type="date" name="dateStartRoad"/><br><br>
        Дата кінця: <input type="date" name="dateEndRoad"/><br><br>
        <input type="submit" value="Добавити ремонт доріг"/>
    </form>
</body>
</html>

