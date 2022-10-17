<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/admin-panel.css"/>
    <script src="JavaScript/routes.js" defer></script>
    <title>Route</title>
</head>
<body>
<header>
        <p class="p">Міський</p>
        <p class="p1">Транспорт</p>
        <a href="/" class = "a2">Головна</a>
        <a href="/routes" class = "a1">Маршрути</a>
</header>
<p class="size">Панель працівника по маршруту</p>
<#if role == "route_employee">
<br>
    <article class="container">
        <div class="block">
            <section class="block__item block-item">
                <h2 class="block-item__title">Створення маршруту</h2>
                <button class="block-item__btn route-btn">Створити</button>
            </section>
            <section class="block__item block-item">
                <h2 class="block-item__title">Створення зупинок</h2>
                <button class="block-item__btn stop-btn">Створити</button>
            </section>
        </div>
        <div class="form-box">
            <form action="/route/create" method="post" class="form form_route" enctype="multipart/form-data">
                <h3 class="form__title">Створення маршруту</h3>
                <p>
                    <input type="number" name="numberRoute" class="form__input" placeholder="Номер маршруту">
                </p>
                <p>
                    <input type="text" name="interval" class="form__input" placeholder="Інтервал їзди транспорту"/>
                </p>
                <p>
                    <input type="date" name="dateTime" class="form__input" placeholder="Дата створення маршруту"/>
                </p>
                <p>
                    <input type="number" name="startPoint" class="form__input" placeholder="Початок маршруту"/>
                </p>
                <p>
                    <input type="number" name="endPoint" class="form__input" placeholder="Кінець маршруту"/>
                </p>
                <p>
                    <input type="number" name="stopOrder" class="form__input" placeholder="Кількість зупинок"/>
                </p>
                <p>
                    <input type="int" name="idAdministrator" class="form__input" placeholder="Айді працівника"/>
                </p>
                <button type="submit" class="form__btn">Створити</button>
            </form>
            <form action="/stop/add" method="post" class="form form_stop" enctype="multipart/form-data">
                <h3 class="form__title">Створення зупинки</h3>
                <p>
                    <input type="number" name="numberStop" class="form__input" placeholder="Номер зупинки"/>
                </p>
                <p>
                    <input type="text" name="address" class="form__input" placeholder="Адреса"/>
                </p>
                <button type="submit" class="form__btn">Створити</button>
            </form>
        </div>
    </article>
    <br><br>
    <table class="table">
        <thead>
            <th class="th">Номер зупинки</th>
            <th class="th">Адреса</th>
        </thead>
        <tbody>
            <form action="/routes" method="get" enctype="multipart/form-data">
                 <#list stop as itam>
                      <tr class="tr">
                        <td class="td"></b>${itam.numberStop}</td>
                        <td class="td"></b>${itam.address}</td>
                      </tr>
                 </#list>
            </form>
        </tbody>
    </table>
</#if>
</body>
</html>