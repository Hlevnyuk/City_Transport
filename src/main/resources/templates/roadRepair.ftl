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
</body>
</html>

