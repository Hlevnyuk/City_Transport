<!doctype html>
<html>
<head>
    <title>TraficJem</title>
</head>
<body>
<h1>Пробки</h1><hr>
<h4>Подробная информация о пробках</h4>
<b>Номер пробки: </b>${traficJemTitle.idTraficJem}<br>
<b>Время начала пробки: </b>${traficJemTitle.timeStart}<br>
<b>Время конца пробки: </b>${traficJemTitle.timeEnd}<br>
<b>Номер остановки: </b>${traficJemTitle.numberStop}<br>
<b>Адрес: </b>${traficJemTitle.address}<br>
<b>Номер работника: </b>${traficJemTitle.numberEmployee}<br>
<form action="/traficJem/delete/${traficJemTitle.idTraficJem}" method="post">
    <input type="submit" value="Удалить пробку"/>
</form>
</body>
</html>