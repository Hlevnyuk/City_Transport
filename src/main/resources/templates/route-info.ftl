<!doctype html>
<html>
<head>
    <title>Route</title>
</head>
<body>
<h1>Маршрут</h1><hr>
<h4>Подробная информация о маршруте</h4>
<b>Номер маршрута: </b>${route.numberRoute}<br>
<b>Остановки:</b><br>
<#list stop as item>
    ${item.address};<br>
</#list>
<b>Интервал: </b>${route.interval}<br>
<b>Дата создания: </b>${route.dateTime}<br>

<b>Транспорт проходящий через этот маршрут:</b><br>
<#list transport as item>
    <b>Номер: </b>${item.numberTransport} <b>Тип: </b>${item.typeTransport};<br>
</#list>
<div>
    <p>Работа с транспортом</p>
    <form action="/routes/${route.numberRoute}" method="post">
        <select name = "idTransport">
            <#list freeTransport as item>
                <option value = "${item.idTransport}"> ${item.idTransport} - ${item.numberTransport}</option>
            </#list>
        </select>
        <input type="submit" value="Назначить транспорт"/>
    </form>
    <form action="/routes/deleteTransport/${route.numberRoute}" method="post">
        <select name = "idTransport">
            <#list transport as item>
                <option value = "${item.idTransport}"> ${item.idTransport} - ${item.numberTransport}</option>
            </#list>
        </select>
        <input type="submit" value="Отвязать транспорт"/>
    </form>
</div>
<div>
    <p>Работа с остановками</p>
    <form action="/routes/addStop/${route.numberRoute}" method="post">
            <select name = "numberStop">
                <#list freeStop as item>
                    <option value = "${item.numberStop}" name="${item.numberStop}"> ${item.numberStop} - ${item.address}</option>
                </#list>
            </select>
            <input type="number" name="stopOrder"/>
            <input type="submit" value="Добавить остановку"/>
    </form>
    <form action="/routes/deleteStop/${route.numberRoute}" method="post">
            <select name = "numberStop">
                <#list stop as itam>
                    <option value = "${itam.numberStop}" name="${itam.numberStop}"> ${itam.numberStop} - ${itam.address}</option>
                </#list>
            </select>
            <input type="submit" value="Удалить остановку"/>
    </form>
</div>
<hr>
Пробки на маршруте:<br>
<#list traficJemTitle as item>
    Адрес:${item.address}<br>
    Время начала:${item.timeStart}<br>
    Время конца:${item.timeEnd}<br>
    <#if role == "transport_officer">
        <form action="/routes/deleteTraficJem/${route.numberRoute}/${item.numberStop}" method="post">
            <input type="submit" value="Удалить пробку"/><br>
        </form>
    </#if>
</#list>
<hr>
<form action="/route/delete/${route.numberRoute}" method="post">
    <input type="submit" value="Удалить маршрут"/>
</form>
</body>
</html>