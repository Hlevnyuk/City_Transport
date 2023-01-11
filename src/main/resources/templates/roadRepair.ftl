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
    <p class="size">Всі ремонти доріг</p>
    <table class="table">
        <thead>
            <th class="th">Айді</th>
            <th class="th">Час початку</th>
            <th class="th">Час кінця</th>
            <th class="th">Зупинка</th>
            <th class="th">Видалення<th>
        </thead>
        <tbody>
            <#list roadRepairTitle as elroadRepair>
                <tr class="tr">
                    <form action="/roadRepair/delete/${elroadRepair.idRoadRepair}" method="post">
                        <td class="td">${elroadRepair.idRoadRepair}</td>
                        <td class="td">${elroadRepair.dateStartRoad}</td>
                        <td class="td">${elroadRepair.dateEndRoad}</td>
                        <td class="td">${elroadRepair.addres}</td>
                        <td class="td">
                            <button type="submit">Видалити</button>
                        </td>
                    </form>
                </tr>
            </#list>
        </tbody>
    </table>
<#if role == "transport_employee">
    <div class="cont_principal">
        <div class="cont_centrar">
            <div class="cont_login">
                <form action="/roadRepair/add" method="post" enctype="multipart/form-data">
                    <div class="cont_text_inputs">
                        <input type="number" class="input_form_sign d_block active_inp" placeholder="id пробки" name="id"/>
                        <select name = "numberStop" class="select">
                           <#list stop as item>
                               <option value = "${item.numberStop}" name="${item.numberStop}"> ${item.numberStop} - ${item.address}</option>
                           </#list>
                        </select>
                        <input type="date" class="input_form_sign d_block  active_inp" placeholder="Час початку" name="dateStartRoad"/>
                        <input type="date" class="input_form_sign d_block  active_inp" placeholder="Час кінця" name="dateEndRoad"/>
                    </div>
                    <div class="cont_btn">
                        <button type="submit" class="btn_sign">Добавити ремонт доріг</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</#if>
</body>
</html>

