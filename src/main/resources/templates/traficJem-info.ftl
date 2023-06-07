<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/traficJem.css"/>
    <link href="https://fonts.cdnfonts.com/css/marske" rel="stylesheet">
    <title>Затори</title>
</head>
<body>
    <header>
        <p class="p">Міський</p>
        <p class="p1">Транспорт</p>
        <a href="/" class = "a2">Головна</a>
    </header>
    <p class="size">Всі затори</p><br>
    <table class="table">
        <thead>
            <th class="th">Айді</th>
            <th class="th">Час початку</th>
            <th class="th">Час кінця</th>
            <th class="th">Зупинка</th>
            <th class="th">Детальніше<th>
        </thead>
        <tbody>
            <tr class="tr">
                <td class="td">${traficJemTitle.idTraficJem}</td>
                <td class="td">${traficJemTitle.timeStart}</td>
                <td class="td">${traficJemTitle.timeEnd}</td>
                <td class="td">${traficJemTitle.address}</td>
                <td class="td">
                    <form action="/traficJem/delete/${traficJemTitle.idTraficJem}" method="post">
                        <input type="submit" value="Видалити"/>
                    </form>
                </td>
            </tr>
        </tbody>
    </table>
    <br>
</body>
</html>