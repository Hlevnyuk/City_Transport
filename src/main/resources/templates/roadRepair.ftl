<!doctype html>
<html>
<head>
    <title>Route</title>
</head>
<body>
<h4>Всі ремонти доріг</h4>
<#-- это тот же список for each -->
<#list roadRepair as iRoadRepair>

    <b>Дата начала: </b>${iRoadRepair.dateStartRoad}<br>
    <b>Дата конца: </b>${iRoadRepair.dateEndRoad}<br>
    <a href="/routes/${elroute.numberRoute}">Подробнее...</a><br>
</#list>
<hr>
</body>
</html>