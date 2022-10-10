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
<table class="table">
    <thead>
        <th class="th">Адреса</th>
        <th class="th">Час початку пробки</th>
        <th class="th">Час кінця пробки</th>
        <#if role == "transport_employee">
            <th class="th">Видалення</th>
        </#if>
    </thead>
    <tbody>
        <#list traficJemTitle as item>
            <tr class="tr">
                <td class="td">${item.address}</td>
                <td class="td">${item.timeStart}</td>
                <td class="td">${item.timeEnd}</td>
                <td class="td">
                    <#if role == "transport_employee">
                        <form action="/routes/deleteTraficJem/${route.numberRoute}/${item.numberStop}" method="post">
                            <input type="submit" value="Видалити пробку"/><br>
                        </form>
                    </#if>
                </td>
            </tr>
        </#list>
   </tbody>
</table>
<table class="table">
    <thead>
        <th class="th">Адреса</th>
        <th class="th">Час початку ремонту</th>
        <th class="th">Час кінця ремонту</th>
        <#if role == "transport_employee">
            <th class="th">Видалення</th>
        </#if>
    </thead>
    <tbody>
        <#list roadRepairTitle as item>
            <tr class="tr">
                <td class="td">${item.addres}</td>
                <td class="td">${item.dateStartRoad}</td>
                <td class="td">${item.dateEndRoad}</td>
                <td class="td">
                    <#if role == "transport_employee">
                        <form action="/routes/deleteRoadRepair/${item.numberRoute}/${item.numberStop}" method="post">
                            <input type="submit" value="Видалити ремонт доріг"/><br>
                        </form>
                    </#if>
                </td>
            </tr>
        </#list>
    </tbody>
</table>
<#if role == "administrator">
    <div class="containerButton">
        <div class="center">
            <form action="/route/delete/${route.numberRoute}" method="post">
                <button class="btn">
                    <svg width="180px" height="60px" viewBox="0 0 180 60" class="border">
                        <polyline points="179,1 179,59 1,59 1,1 179,1" class="bg-line" />
                        <polyline points="179,1 179,59 1,59 1,1 179,1" class="hl-line" />
                    </svg>
                    <span>Видалити маршрут</span>
                </button>
            </form>
        </div>
    </div>
</#if>
<#if role == "administrator">
    <hr>
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
<br>
</body>
</html>