<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>Аналитика</title>
</head>
<body>
    <table border = "1">
        <#list ticketSold as item>
            <tr>
                <td>${item.idTransport}</td>
                <td>${item.dateSold}</td>
                <td>${item.kolTicketSold}</td>
                <td>${item.id}</td>
            </tr>
        </#list>
    </table>
     <table border = "1">
            <#list routeTitle as item>
                <tr>
                    <td>${item.numberRoute}</td>
                    <td>${item.startPoint}</td>
                    <td>${item.endPoint}</td>
                </tr>
            </#list>
     </table>
    <form action="/ticketSold/create" method="post" enctype="multipart/form-data">
        <b>id транспорту: <input type="number" name="idTransport"/></b><br><br>
        <b>Дата продажу: <input type="date" name="dateSold"/></b><br><br>
        <b>Кількість проданих: <input type="number" name="kolTicketSold"/></b><br><br>
        <input type="submit" value="Добавити"/><br>
    </form>
    <form action="/analyticks/route" method="post" enctype="multipart/form-data">
        <b>Номер маршруту:</b> <input type="number" name="id"/><br><br>
        <b>Дата початку:</b> <input type="date" name="timeStart"/><br><br>
        <b>Дата кінця:</b> <input type="date" name="timeFinal"/><br><br>
        <input type="submit" value="Відобразити"/><br><br>
    </form><br>
    <#if result?has_content>
        <b>Результат:</b> ${result}<br>
    </#if>
</body>
</html>