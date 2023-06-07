<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/createContract.css"/>
    <link href="https://fonts.cdnfonts.com/css/marske" rel="stylesheet">
    <title>Договори</title>
</head>
<body>
<header>
        <p class="p">Міський</p>
        <p class="p1">Транспорт</p>
        <a href="/" class = "a a2">Головна</a>
</header>
<p class="size">Створення договору</p><br>
    <hr>
    <div class="cont_principal">
        <div class="cont_centrar">
            <div class="cont_login">
                <form action="/contract/create" method="post" enctype="multipart/form-data">
                    <div class="cont_text_inputs">
                        <input type="number" class="input_form_sign d_block active_inp" placeholder="id договору" name="id"/>
                        <input type="text" class="input_form_sign d_block active_inp" placeholder="Фірма" name="firm"/>
                        <input type="date" class="input_form_sign d_block  active_inp" placeholder="Дата створення" name="dateStartContract"/>
                        <input type="date" class="input_form_sign d_block  active_inp" placeholder="Дата закінчення" name="dateEndContract"/>
                        <input type="number" class="input_form_sign d_block  active_inp" placeholder="Кількість транспорту" name="transportCount"/>
                        <select name="typeTransport" class="select">
                            <#list typeTransport as item>
                                 <option value = "${item.name}"> ${item.name}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="cont_btn">
                        <button type="submit" class="btn_sign">Створити договір</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
<br>
</body>
</html>