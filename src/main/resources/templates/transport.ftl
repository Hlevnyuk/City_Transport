<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/transport.css"/>
    <script src="JavaScript/routes.js" defer></script>
    <title>Транспорт</title>
</head>
<body>
    <header>
        <p class="p">Міський</p>
        <p class="p1">Транспорт</p>
        <a href="/" class = "a2">Головна</a>
    </header>
    <p class="size">Всі транспортні засоби</p>
    <br>
    <table class="table">
        <thead>
            <th class="th">Номер транспорту</th>
            <th class="th">Тип транспорту</th>
            <th class="th">Гараж</th>
            <th class="th">Номер договору<th>
        </thead>
        <tbody>
            <#list transport as item>
                <tr class="tr">
                    <form action="/transport/delete/${item.idTransport}" method="post" enctype="multipart/form-data">
                        <td class="td">${item.numberTransport}</td>
                        <td class="td">${item.typeTransport}</td>
                        <td class="td">${item.garage}</td>
                        <td class="td">${item.idContract}</td>
                        <td class="td"><button type="submit">Видалити</button></td>
                    </form>
                </tr>
            </#list>
        </tbody>
    </table>
    <hr>
    <p class="size">Завершити працю з транспортними засобами</p>
    <br>
    <#list transportChange as item>
        <form  action="/transport/change/${item.idTransport}" method="post" onSubmit = "return checkform(this)" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>Номер транспорту</td>
                    <td><input type="number" name="numberTransport" required></td>
                </tr>
                <tr>
                    <td>Тип транспорту</td>
                    <td>${item.typeTransport}</td>
                </tr>
                <tr>
                    <td>Гараж</td>
                    <td><input type="text" name="garage" required></td>
                </tr>
                <tr>
                    <td>Номер договору</td>
                    <td>${item.idContract}</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Добавити"></td>
                </tr>
            </table>
        </form>
    </#list>
</body>
</html>