<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/traficJem.css"/>
    <title>Route</title>
</head>
<body>
    <header>
        <p class="p">Міський</p>
        <p class="p1">Транспорт</p>
        <a href="/" class = "a2">Головна</a>
    </header>
    <p class="size">Всі маршрути</p><br>
    <ul class="list3b">
        <#list traficJemTitle as eltraficJem>
            <li class="text">
                <b>Id: </b>${eltraficJem.idTraficJem}<br>
                <b>Время начала: </b>${eltraficJem.timeStart}<br>
                <b>Время конца: </b>${eltraficJem.timeEnd}<br>
                <b>Остановка: </b>${eltraficJem.address}<br><br>
                <a href="/traficJem/${eltraficJem.idTraficJem}" class = "btn1">Подробнее...</a><br>
            </li>
        </#list>
    </ul>
    <hr>
    <#if role == "transport_employee">
        <div class="cont_principal">
            <div class="cont_centrar">
                <div class="cont_login">
                    <form action="/traficJem/create" method="post" enctype="multipart/form-data">
                        <div class="cont_text_inputs">
                            <input type="number" class="input_form_sign d_block active_inp" placeholder="id пробки" name="idTraficJem"/>
                            <input type="time" class="input_form_sign d_block active_inp" placeholder="Час початку" name="timeStart"/>
                            <input type="time" class="input_form_sign d_block  active_inp" placeholder="Час кінця" name="timeEnd"/>
                            <select name = "numberStop" class="select">
                               <#list stop as item>
                                   <option value = "${item.numberStop}" name="${item.numberStop}"> ${item.numberStop} - ${item.address}</option>
                               </#list>
                            </select>
                            <input type="number" class="input_form_sign d_block active_inp" placeholder="Номер працівника" name="numberEmployee"/>
                        </div>
                        <div class="cont_btn">
                            <button type="submit" class="btn_sign">Добавити пробку</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </#if>
    <br>
</body>
</html>