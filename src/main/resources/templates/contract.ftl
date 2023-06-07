<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/contract.css"/>
    <link href="https://fonts.cdnfonts.com/css/marske" rel="stylesheet">
    <title>Договори</title>
</head>
<body>
<#assign aDateTime = .now>
<#assign aDate = aDateTime?date>
<header>
        <p class="p">Міський</p>
        <p class="p1">Транспорт</p>
        <a href="/" class = "a a2">Головна</a>
</header>
<p class="size">Всі договори</p><br>
<table class="table">
    <tr>
        <th class="th">Фірма</th>
        <th class="th">Дата укладення договору</th>
        <th class="th">Дата закінчення договору</th>
        <th class="th">Кількість замовленого транспорту</th>
        <th class="th">Тип</th>
        <th class="th">Термін дії</th>
        <th class="th">Детальніше</th>
    </tr>
    <#list contract as item>
        <tr>
            <td class="td">${item.firm}</td>
            <td class="td">${item.dateStartContract}</td>
            <td class="td">${item.dateEndContract}</td>
            <td class="td">${item.transportCount}</td>
            <td class="td">${item.typeTransport}</td>
            <td class="td">
                <#if aDate gt item.dateEndContract>
                    <p class="invalid">Не дійсний!</p>
                <#else>
                    <p class="valid">Дійсний</p>
                </#if>
            </td>
            <td class="td"><a href="/contract/${item.id}" class="aTable button">Перейти</a></td>
        </tr>
    </#list>
</table>
<br><br>
<#if role == "transport_employee">
    <div class="containerButton">
        <div class="center">
            <form action="/contract/page/create" method="get">
                <button class="btn">
                    <svg width="180px" height="60px" viewBox="0 0 180 60" class="border">
                        <polyline points="179,1 179,59 1,59 1,1 179,1" class="bg-line" />
                        <polyline points="179,1 179,59 1,59 1,1 179,1" class="hl-line" />
                    </svg>
                    <span>Заключити договір</span>
                </button>
            </form>
        </div>
    </div>
</#if>
<br>
</body>
</html>