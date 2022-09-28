<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>Транспорт</title>
</head>
<body>
    <#list transport as item>
         <b>id: </b>${item.idTransport}<br>
         <b>Номер транспорта: </b>${item.numberTransport}<br>
         <b>Тип транспорта: </b>${item.typeTransport}<br>
         <b>Гараж: </b>${item.garage}<br>
         <b>Номер договора: </b>${item.idContract}<br>
         <form action="/transport/delete/${item.idTransport}" method="post" enctype="multipart/form-data">
            <input type="submit" value="Удалить транспорт"/>
         </form>
    </#list>
    <hr>
    <hr>
    <hr>
    <hr>
    <#list transportChange as item>
    <form action="/transport/change/${item.idTransport}" method="post" enctype="multipart/form-data">
         <b>id: </b>${item.idTransport}<br>
         <b>Номер транспорта: </b><input type="number" name="numberTransport"/><br>
         <b>Тип транспорта: </b>${item.typeTransport}<br>
         <b>Гараж: </b><input type="text" name="garage"/><br>
         <b>Номер договора: </b>${item.idContract}<br>
         <input type="submit" value="Изменить"/>
    </form>
    </#list>
</body>
</html>