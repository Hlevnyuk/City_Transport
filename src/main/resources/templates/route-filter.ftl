<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/routes.css"/>
    <script src="JavaScript/routes.js" defer></script>
    <title>Route</title>
</head>
<body>
<header>
        <p class="p">Міський</p>
        <p class="p1">Транспорт</p>
        <a href="/" class = "a2">Головна</a>
        <#if role = "administrator">
            <a href="/admin-panel" class = "a1">Панель працівника</a>
        </#if>
</header>
<p class="size">Всі маршрути</p>
<form action="/route/filter" method="post">
    <div class="dropdown1">
        <div id="myDropdown" class="dropdown-content1">
            <span class="custom-dropdown big">
                <select name = "start">
                    <#list stop as el>
                        <option value="${el.numberStop}" name="startPoint" onclick="inputFunction(${el.numberStop})">${el.numberStop} - ${el.address}</option>
                    </#list>
                </select>
            </span>
            <span class="custom-dropdown big">
                <select name = "end">
                   <#list stop as el>
                       <option value="${el.numberStop}" name="endPoint" onclick="inputFunction(${el.numberStop})">${el.numberStop} - ${el.address}</option>
                   </#list>
                </select>
            </span>
        </div>
    </div>
    <button type="submit" class="btn_sign">Знайти</button>
</form>
<#if routeTitle?size gt 0>
    <ul class="list3b">
        <#list routeTitle as elroute>
            <li class="text">
                <b>Номер маршрута: </b>${elroute.numberRoute}<br>
                <b>Начальная точка: </b>${elroute.startPoint}<br>
                <b>Конечная точка: </b>${elroute.endPoint}<br><br>
                <a href="/routes/${elroute.numberRoute}" class = "btn1">Подробнее...</a><br>
            </li>
        </#list>
    </ul>
<#else>
    <p class="result">Не знайдено</p>
</#if>
<br>
</body>
</html>