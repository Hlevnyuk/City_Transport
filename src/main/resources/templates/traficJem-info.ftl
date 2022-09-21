<!doctype html>
<html>
<head>
    <title>TraficJem</title>
</head>
<body>
<h1>Пробки</h1><hr>
<h4>Подробная информация о пробках</h4>
<b>Номер пробки: </b>${traficJem.idTraficJem}<br>
<b>Место возникновения пробки: </b>${traficJem.stop}<br>
<b>Дата возникновения пробки: </b>${traficJem.dateTraficJem}<br>
<b>Начало пробки: </b>${traficJem.startPoint}<br>
<b>Конец пробки: </b>${traficJem.endPoint}<br>
<b>Время начала пробки: </b>${traficJem.timeStart}<br>
<b>Время конца пробки: </b>${traficJem.timeEnd}<br>
<b>Степень: </b>${traficJem.extent}<br>
<form action="/traficJem/delete/${traficJem.idTraficJem}" method="post">
    <input type="submit" value="Удалить пробку"/>
</form>
</body>
</html>