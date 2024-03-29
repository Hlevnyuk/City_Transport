<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/routeinfo.css"/>
    <link href="https://fonts.cdnfonts.com/css/marske" rel="stylesheet">
    <title>Route</title>
</head>
<body>
<header>
        <p class="p">Міський</p>
        <p class="p1">Транспорт</p>
        <a href="/" class = "a2">Головна</a>
        <a href="/routes" class = "a3">Маршрути</a>
</header>
<p class="size">Детальна інформація про маршрут</p>
<br>
<table class="table">
    <thead>
        <th class="th">Номер маршруту</th>
        <th class="th">Послідовність зупинок</th>
        <th class="th">Інтервал їзди транспорту</th>
        <#if role == "route_employee">
            <th class="th">Дата створення</th>
        </#if>
        <th class="th">Номер та тип транспорту</th>
    </thead>
    <tbody>
        <tr class="tr">
            <td class="td">${route.numberRoute}</td>
            <td class="td">
            <#list stopAddress?keys as key>
                ${key} - ${stopAddress[key]}<br>
            </#list>
            </td>
            <td class="td">${route.interval}
                <#if role == "route_employee">
                    <br>
                    <form action="/route/updateInterval/${route.numberRoute}" method="post">
                        <input type="text" name="interval" class="inputUpdateQuery" placeholder="Змінити інтервал" autocomplete="off"/>
                        <button type="submit">Змінити</button>
                    </form>
                </#if>
            </td>
            <#if role == "route_employee">
                <td class="td">${route.dateTime}</td>
            </#if>
            <td class="td">
                <#list transport as item>
                    ${item.numberTransport} - ${item.typeTransport}<br>
                </#list>
            </td>
        </tr>
    </tbody>
</table>
<#if traficJemTitle?size gt 0>
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
                        <#if role == "route_employee">
                            <form action="/routes/deleteTraficJem/${route.numberRoute}/${item.numberStop}" method="post">
                                <input type="submit" class="butonbtn" value="Видалити пробку"/><br>
                            </form>
                        </#if>
                    </td>
                </tr>
            </#list>
       </tbody>
    </table>
</#if>
<#if roadRepairTitle?size gt 0>
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
                    <#if role == "route_employee">
                        <td class="td">
                            <form action="/routes/deleteRoadRepair/${item.numberRoute}/${item.numberStop}" method="post">
                                <input type="submit" class="butonbtn" value="Видалити ремонт доріг"/><br>
                            </form>
                        </td>
                    </#if>
                </tr>
            </#list>
        </tbody>
    </table>
</#if>
<#if role == "route_employee">
    <br>
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
<#if role == "route_employee">
    <hr>
    <div class="container alignment">
        <div class="brand-title">
            Назначини транспортний засіб
        </div>
        <div class="inputs">
            <form action="/routes/${route.numberRoute}" method="post">
                <select name = "idTransport" class="select">
                    <#list freeTransport as item>
                        <#if item.numberTransport gt 0>
                            <option value = "${item.idTransport}"> ${item.idTransport} - ${item.numberTransport}</option>
                        </#if>
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
                    <select name = "stopOrder" class="select">
                        <#assign x = maxStopOrder>
                        <#list 1..x as i>
                            <option value = ${i}>${i}</option>
                        </#list>
                    </select>
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