<!doctype html>
<html>
<head>
<#--    <link rel="stylesheet"-->
<#--          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">-->
<#--    <script-->
<#--            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>-->
<#--    <script type="text/javascript"-->
<#--            src="https://www.gstatic.com/charts/loader.js"></script>-->
    <link rel="stylesheet" type="text/css" href="analyticksTicketSold.css">
    <link href="https://fonts.cdnfonts.com/css/marske" rel="stylesheet">
    <title>Аналитика</title>
</head>
<body>
<style>
    * {
        margin:0;
        padding:0;
    }
    body {
        min-width: 900px;
        background: #312e2e;
    }
    html {
        width:100%;
        height:100%;
    }
    header{
        width:100%;
        height:80px;
        background:#181818;
    }
    .p{
        position: absolute;
        top: 20px;
        left: 100px;
        color: #b0b0b0;
        font-size: 35px;
    }
    .p1{
        position: absolute;
        top: 20px;
        left: 275px;
        font-size: 35px;
        color: #b30000;
    }
    .table{
        font-size: 14px;
        background:#312e2e;
        max-width: 70%;
        width: 70%;
        border-collapse: collapse;
        text-align: left;
        font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
        position: relative;
        margin: 0 auto;
    }
    .td{
        font-family: 'Play',sans-serif;
        border-bottom: 1px solid grey;
        color: #999;
        font-size:1rem;
        padding: 16px 12px;
    }
    .th {
        font-size: 2rem;
        border-bottom: 1px solid #ff0800;
        padding: 10px;
        color: white;
        font-family: 'Play',sans-serif;
    }
    .cont_principal {
        position: relative;
        height: 350px;
    }
    .cont_centrar {
        position: absolute;
        width: 320px;
        left:50%;
        top:50%;
        margin-left: -160px;
        margin-top: -160px;
    }
    .cont_centrar {
        position: relative;
        width: 320px;
        float: left;
        background-image: linear-gradient(-226deg, #FFFFFF 8%, #EEF3F5 100%);
        border-radius: 8px;
        transition: all 0.5s;
    }
    .cont_text_inputs {
        position: relative;
        float: left;
        width: 100%;
        margin-top: 20px;
    }
    .input_form_sign {
        position: relative;
        float: left;
        width: 90%;
        border: none;
        border-bottom: 1px solid #B0BEC5 ;
        font-size: 14px;
        outline: none;
        transition: all 0.5s;
        height: 0px;
        margin: 0px;
        padding: 0px;
        opacity: 0;
        display: none;
    }
    .active_inp {
        margin: 5% 5% ;
        padding: 10px 0px;
        opacity: 1;
        height: 5px;
    }
    .input_form_sign:focus {
        border-bottom: 1px solid #FF8383 ;
    }
    .cont_btn {
        position: relative;
        margin-left: -18%;
    }
    .d_block {
        display: block;
    }
    .btn_sign {
        background: rgba(255,0,10,1);
        box-shadow: 0px 2px 20px 2px rgb(255 114 132 / 50%);
        border-radius: 8px;
        padding: 15px 30px;
        border: none;
        color: #fff;
        font-size: 14px;
        position: relative;
        float: left;
        /* margin-left: auto; */
        /* text-align: center; */
        left: 41%;
        right: 50%;
        /* transform: translate(-50%, -50%); */
        margin-top: 20px;
        margin-bottom: 20px;
        cursor: pointer;
    }
    .date {
        height: 1%;
    }
</style>
<header>
    <p class="p">Міський</p>
    <p class="p1">Транспорт</p>
</header>
<br><br><br>
<table class="table">
    <th class="th">id транспорту</th>
    <th class="th">Дата</th>
    <th class="th">Кількість проданих білетів</th>
    <#list ticketSold as item>
        <tr class="tr">
            <td class="td">${item.numberTransport}</td>
            <td class="td">${item.dateSold}</td>
            <td class="td">${item.kolTicketSold}</td>
        </tr>
    </#list>
</table>
<br>
<div class="cont_principal">
    <div class="cont_centrar">
        <div class="cont_login">
            <form action="/ticketSold/create" method="post" enctype="multipart/form-data">
                <div class="cont_text_inputs">
                    <p>
                        <input type="number" name="numberTransport" class="input_form_sign d_block active_inp" placeholder="id транспорту">
                    </p>
                    <p>
                        <input type="date" name="dateSold" class="input_form_sign d_block active_inp date" placeholder="Дата продажу"/>
                    </p>
                    <p>
                        <input type="number" name="kolTicketSold" class="input_form_sign d_block active_inp" placeholder="Кількість проданих"/>
                    </p>
                </div>
                <div class="cont_btn">
                    <button type="submit" class="btn_sign">Добавити</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="cont_principal">
    <div class="cont_centrar">
        <div class="cont_login">
            <form action="/analyticks/route" method="post" enctype="multipart/form-data">
                <div class="cont_text_inputs">
                    <p>
                        <input type="number" name="numberTransport" class="input_form_sign d_block active_inp" placeholder="Номер маршруту"/>
                    </p>
                    <p>
                        <input type="date" name="timeStart" class="input_form_sign d_block active_inp date" placeholder="Дата початку"/>
                    </p>
                    <p>
                        <input type="date" name="timeFinal" class="input_form_sign d_block active_inp date" placeholder="Дата кінця"/>
                    </p>
                    <p>
                        <#if result?has_content>
                            <b style="margin-left: 35%">Результат:</b> ${result}<br>
                        </#if>
                    </p>
                </div>
                <div class="cont_btn">
                    <button type="submit" class="btn_sign">Показати</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>