<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div class="log-form-conteiner">
    <form action="/login/authorization" method="post">
        <p>Увійти</p>
        <p>Логін</p>
        <input type="text" name="name">
        <p>Пароль</p>
        <input type="password" name="password"><br>
        <div class="account">
            <a href="/registration">Створити обліковий запис</a>
        </div>
        <button type="submit" class="log-button">Увійти</button>
    </form>
</div>
</body>
</html>