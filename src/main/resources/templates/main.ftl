<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <link href="https://fonts.cdnfonts.com/css/marske" rel="stylesheet">
    <title>Главная страница</title>
</head>
<body>
    <header>
        <p class="p">Міський</p>
        <p class="p1">Транспорт</p>
        <a href="/login" class = "a1">Вхід</a>
        <a href="/logout" class = "a2">Вихід</a>
    </header>
        <div class="slider">
            <input type="radio" name="switch" id="btn1" checked>
            <input type="radio" name="switch" id="btn2">
            <input type="radio" name="switch" id="btn3">
            <div class="switch">
              <label for="btn1"></label>
              <label for="btn2"></label>
              <label for="btn3"></label>
            </div>
            <div class="slider-inner">
              <div class="slides">
                <img src="images/Автобус.jpg"/>
                <img src="images/Троллейбус.jpg"/>
                <img src="images/Трамвай.jpg"/>
              </div>
            </div>
        </div>
        <br>
        <div class="nav-container">
            <nav class="nav">
                <a href="/routes" class = "btn btnhelp">Всі маршрути</a>
                <#if role == "route_employee">
                    <a href="/analyticks" class = "btn btnhelp">Аналитика</a>
                    <a href="/admin-panel" class = "btn btnhelp">Панель працівника</a>
                    <a href="/traficJem" class = "btn btnhelp">Пробки</a>
                    <a href="/roadRepair" class = "btn btnhelp">Ремонти доріг</a>
                </#if>
                <#if role == "transport_employee">
                    <a href="/contract" class = "btn btnhelp">Договір</a>
                    <a href="/transport" class = "btn btnhelp">Транспорт</a>
                    <a href="/analyticksTicketSold/0" class = "btn btnhelp">Аналитика</a>
                </#if>
            </nav>
        </div>
</body>
</html>