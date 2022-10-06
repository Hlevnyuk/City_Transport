<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/routeinfo.css"/>
    <title>Route</title>
</head>
<body>
<h1>Детальна інформація про маршрут</h1>
<hr>
<table class="table">
    <thead>
        <th class="th">Номер маршруту</th>
        <th class="th">Зупинки</th>
        <th class="th">Інтервал</th>
        <th class="th">Дата створення</th>
        <th class="th">Номер та тип транспорту</th>
    </thead>
    <tbody>
        <tr class="tr">
            <td class="td">${route.numberRoute}</td>
            <td class="td">
                <#list stop as item>
                    ${item.address},
                </#list>
            </td>
            <td class="td">${route.interval}</td>
            <td class="td">${route.dateTime}</td>
            <td class="td">
                <#list transport as item>
                    ${item.numberTransport} - ${item.typeTransport}<br>
                </#list>
            </td>
        </tr>
    </tbody>
</table>
<#if role == "administrator">
        <form action="/routes/${route.numberRoute}" method="post" class="decor">
            <div class="form-inner">
                <p>Назначити транспортний засіб</p>
                <select name = "idTransport" class="radius">
                    <#list freeTransport as item>
                        <option value = "${item.idTransport}"> ${item.idTransport} - ${item.numberTransport}</option>
                    </#list>
                </select>
                <input type="submit" value="Назначить транспорт"/>
            </div>
        </form>
        <form action="/routes/deleteTransport/${route.numberRoute}" method="post" class="decor1">
            <div class="form-inner">
                <p>Забрати транспортний засіб</p>
                <select name = "idTransport" class="radius">
                    <#list transport as item>
                        <option value = "${item.idTransport}"> ${item.idTransport} - ${item.numberTransport}</option>
                    </#list>
                </select>
                <input type="submit" value="Отвязать транспорт"/>
            </div>
        </form>
</#if>
<#if role == "administrator">
    <form action="/routes/addStop/${route.numberRoute}" method="post" class="decor2">
        <div class="form-inner">
            <p>Работа с остановками</p>
            <select name = "numberStop" class="radius">
                <#list freeStop as item>
                    <option value = "${item.numberStop}" name="${item.numberStop}"> ${item.numberStop} - ${item.address}</option>
                </#list>
            </select>
            <br>
            <br>
            <br>
            <input type="number" name="stopOrder"/>
            <input type="submit" value="Добавить остановку"/>
        </div>
    </form>
    <form action="/routes/deleteStop/${route.numberRoute}" method="post" class="decor3">
        <div class="form-inner">
            <p>Видалити зупинку</p>
            <select name = "numberStop" class="radius">
                <#list stop as itam>
                    <option value = "${itam.numberStop}" name="${itam.numberStop}"> ${itam.numberStop} - ${itam.address}</option>
                </#list>
            </select>
            <input type="submit" value="Удалить остановку"/>
        </div>
    </form>
</#if>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<hr>
<b>Пробки на маршруте:</b><br>
<#list traficJemTitle as item>
    Адрес:${item.address}<br>
    Время начала:${item.timeStart}<br>
    Время конца:${item.timeEnd}<br>
    <#if role == "transport_employee">
        <form action="/routes/deleteTraficJem/${route.numberRoute}/${item.numberStop}" method="post">
            <input type="submit" value="Удалить пробку"/><br>
        </form>
    </#if>
</#list>
<b>Ремонты дорог:</b><br>
<#list roadRepairTitle as item>
    Адрес:${item.addres}<br>
    Время начала ремонта:${item.dateStartRoad}<br>
    Время конца ремонта:${item.dateEndRoad}<br>
    <#if role == "transport_employee">
            <form action="/routes/deleteRoadRepair/${item.numberRoute}/${item.numberStop}" method="post">
                <input type="submit" value="Удалить ремонт дорог"/><br>
            </form>
        </#if>
</#list>
<hr>
<form action="/route/delete/${route.numberRoute}" method="post">
    <input type="submit" value="Удалить маршрут"/>
</form>
</body>
</html>