<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <title>Вхід</title>
</head>
<body>
<form class="decor" action="/login/authorization" method="post">
    <div class="form-inner">
        <h3>Заповніть форму</h3>
        <br>
        <input type="text" id="user" name="name" placeholder="Логін" autocomplete="off">
        <input type="password" id="pass" name="password" placeholder="Пароль" autocomplete="off"><br>
        <input type="submit" value="Увійти">
    </div>
</form>
</body>
</html>