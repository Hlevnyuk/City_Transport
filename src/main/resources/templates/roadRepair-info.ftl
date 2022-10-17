<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/roadRepair.css"/>
    <title>Ремонти доріг</title>
</head>
<body>
    <header>
        <p class="p">Міський</p>
        <p class="p1">Транспорт</p>
        <a href="/" class = "a2">Головна</a>
    </header>
    <p class="size">Всі ремонти доріг</p><br>
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
                <form action="/roadRepair/delete/${roadRepairTitle.idRoadRepair}" method="post">
                    <td class="td">${roadRepairTitle.idRoadRepair}</td>
                    <td class="td">${roadRepairTitle.dateStartRoad}</td>
                    <td class="td">${roadRepairTitle.dateEndRoad}</td>
                    <td class="td">${roadRepairTitle.addres}</td>

                </form>
            </tr>
        </tbody>
    </table>
    <br>
</body>
</html>