<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/transport.css"/>
    <link href="https://fonts.cdnfonts.com/css/marske" rel="stylesheet">
    <script src="JavaScript/transport.js" defer></script>
    <title>Транспорт</title>
</head>
<body>
    <header>
        <p class="p">Міський</p>
        <p class="p1">Транспорт</p>
        <a href="/" class = "a2">Головна</a>
    </header>
    <p class="size">Всі транспортні засоби</p>
    <br>
    <table class="table">
        <thead>
            <th class="th">Номер транспорту</th>
            <th class="th">Тип транспорту</th>
            <th class="th">Гараж</th>
            <th class="th">Номер договору<th>
        </thead>
        <tbody>
            <#list transport as item>
                <tr class="tr">
                    <form action="/transport/update/${item.idTransport}" method="post" enctype="multipart/form-data">
                        <td class="td">${item.numberTransport}</td>
                        <td class="td">${item.typeTransport}</td>
                        <td class="td">${item.garage}</td>
                        <td class="td">${item.idContract}</td>
                        <td class="td"><button type="submit">Видалити</button></td>
                    </form>
                </tr>
            </#list>
        </tbody>
    </table>
    <hr>
    <p class="size">Завершити працю з транспортними засобами</p>
    <br>
    <div class="cont_principal">
            <div class="cont_centrar">
                <div class="cont_login">
                    <form action="/transport/change" method="post" onSubmit = "return checkform(this)" enctype="multipart/form-data">
                        <div class="cont_text_inputs">
                            <input id = "id" type="number" class="input_form_sign d_block  active_inp" name="idTransport" required placeholder="id транспорту" readonly>
                            <br>
                            <input type="number" class="input_form_sign d_block  active_inp" name="numberTransport" required placeholder="Номер транспорту">
                            <br>
                            <input id = "type" type="text" class="input_form_sign d_block  active_inp" name="typeTransport" required placeholder="Тип транспорту">
                            <br>
                            <input type="text" class="input_form_sign d_block  active_inp" name="garage" required placeholder="Гараж">
                            <br>
                            <select name="idContract" id="selectValue" class="select">
                                <#list transportChange as item>
                                    <option value=${item.idContract} onclick="myFunction()">${item.idContract}</option>
                                </#list>
                            </select>
                            <div class="cont_btn">
                                <button type="submit" class="btn_sign">Добавити</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
    </div>
    <script>

        function myFunction(){
            var i, count = 0, index;
            var transportList = JSON.parse('${transportForm}');
            document.getElementById("type").value = transportList;
            var selectValue = document.getElementById("selectValue").value;
            for (i = 0; i < transportList.length; i++) {
                if(transportList[i].idContract == selectValue){
                    count++;
                    index = i;
                }
            }
            document.getElementById("type").value = transportList[index].typeTransport;
            document.getElementById("id").value = transportList[index].idTransport;

        }
    </script>
</body>
</html>