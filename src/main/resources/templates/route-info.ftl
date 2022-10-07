<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/routeinfo.css"/>
    <title>Route</title>
</head>
<body>
<header>
        <p class="p">Міський</p>
        <p class="p1">Транспорт</p>
        <a href="/" class = "a2">Головна</a>
</header>
<p class="size">Детальна інформація про маршрут</p>
<br>
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
    <div class="container alignment">
        <div class="brand-title">
            Назначини транспортний засіб
        </div>
        <div class="inputs">
            <form action="/routes/${route.numberRoute}" method="post">
                <select name = "idTransport" class="select">
                    <#list freeTransport as item>
                        <option value = "${item.idTransport}"> ${item.idTransport} - ${item.numberTransport}</option>
                    </#list>
                </select>
                <button type="submit" class="button">Назначити</button>
            </form>
        </div>
    </div>
    <div class="container alignment">
        <div class="brand-title">
            Забрати транспортний засіб
        </div>
        <div class="inputs">
            <form action="/routes/deleteTransport/${route.numberRoute}" method="post">
                <select name = "idTransport" class="select">
                    <#list transport as item>
                        <option value = "${item.idTransport}"> ${item.idTransport} - ${item.numberTransport}</option>
                    </#list>
                </select>
                <button type="submit" class="button">Відвязати</button>
            </form>
        </div>
    </div>
    <div class="container alignment1">
        <div class="brand-title">
            Робота з зупинками
        </div>
        <div class="inputs">
            <form action="/routes/addStop/${route.numberRoute}" method="post">
                <select name = "numberStop" class="select">
                    <#list freeStop as item>
                        <option value = "${item.numberStop}" name="${item.numberStop}"> ${item.numberStop} - ${item.address}</option>
                    </#list>
                </select>
                <input type="number" name="stopOrder" class="input"/>
                <button type="submit" class="button">Добавити</button>
            </form>
        </div>
    </div>
    <div class="container alignment2">
        <div class="brand-title">
            Видалити зупинку
        </div>
        <div class="inputs">
            <form action="/routes/deleteStop/${route.numberRoute}" method="post">
                <select name = "numberStop" class="select">
                    <#list stop as itam>
                        <option value = "${itam.numberStop}" name="${itam.numberStop}"> ${itam.numberStop} - ${itam.address}</option>
                    </#list>
                </select>
                <button type="submit" class="button">Видалити</button>
            </form>
        </div>
    </div>
</#if>
<br><br><br>
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