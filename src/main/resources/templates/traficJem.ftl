<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/traficJem.css"/>
    <link href="https://fonts.cdnfonts.com/css/marske" rel="stylesheet">
    <title>Затори</title>
</head>
<body>
    <header>
        <p class="p">Міський</p>
        <p class="p1">Транспорт</p>
        <a href="/" class = "a2">Головна</a>
    </header>
    <p class="size">Всі затори</p><br>
    <table class="table">
        <thead>
            <th class="th">Час початку</th>
            <th class="th">Час кінця</th>
            <th class="th">Зупинка</th>
            <th class="th">Видалення<th>
        </thead>
        <tbody>
            <#list traficJemTitle as eltraficJem>
                <tr class="tr">
                    <form action="/traficJem/delete/${eltraficJem.idTraficJem}" method="post">
                        <td class="td">${eltraficJem.timeStart}</td>
                        <td class="td">${eltraficJem.timeEnd}</td>
                        <td class="td">${eltraficJem.address}</td>
                        <td class="td"><button type="submit" class="butonbtn">Видалити</button></td>
                    </form>
                </tr>
            </#list>
        </tbody>
    </table>
    <br>
    <#if role == "route_employee">
        <div class="cont_principal">
            <div class="cont_centrar">
                <div class="cont_login">
                    <form action="/traficJem/create" method="post" enctype="multipart/form-data">
                        <div class="cont_text_inputs">
                            <input type="number" class="input_form_sign d_block active_inp" placeholder="Номер працівника" name="numberEmployee"/>
                            <input type="time" class="input_form_sign d_block active_inp" placeholder="Час початку" name="timeStart"/>
                            <input type="time" class="input_form_sign d_block  active_inp" placeholder="Час кінця" name="timeEnd"/>
                            <select name = "numberStop" class="select">
                               <#list stop as item>
                                   <option value = "${item.numberStop}" name="${item.numberStop}"> ${item.numberStop} - ${item.address}</option>
                               </#list>
                            </select>
                        </div>
                        <div class="cont_btn">
                            <button type="submit" class="btn_sign">Добавити пробку</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </#if>
</body>
</html>