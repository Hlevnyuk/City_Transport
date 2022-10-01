<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>Аналитика</title>
</head>
<body>
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