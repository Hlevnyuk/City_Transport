<!doctype html>
<html>
<head>
    <title>TraficJem</title>
</head>
<body>
<h1>Пробки</h1><hr>
<h4>Подробная информация о пробках</h4>
<b>Номер пробки: </b>${traficJem.idTraficJem}<br>
<b>Время начала пробки: </b>${traficJem.timeStart}<br>
<b>Время конца пробки: </b>${traficJem.timeEnd}<br>
<b>Номер остановки: </b>${traficJem.numberStop}<br>
<b>Номер работника: </b>${traficJem.numberEmployee}<br>
<form action="/traficJem/delete/${traficJem.idTraficJem}" method="post">
    <input type="submit" value="Удалить пробку"/>
</form>
</body>
</html>