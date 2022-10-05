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
<h1>Увійти</h1>
<div id="wrapper">
    <form id="signin" action="/login/authorization" method="post" autocomplete="off">
        <input type="text" id="user" name="name" placeholder="Логін">
        <input type="password" id="pass" name="password" placeholder="Пароль"><br>
        <button type="submit">&#xf0da;</button>
    </form>
</div>
</body>
</html>