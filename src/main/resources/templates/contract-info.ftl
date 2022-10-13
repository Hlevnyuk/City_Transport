<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/contract-info.css"/>
    <title>Детальна інформация про договір</title>
</head>
<body>
<header>
        <p class="p">Міський</p>
        <p class="p1">Транспорт</p>
        <a href="/" class = "a a2">Головна</a>
</header>
<p class="size">Договір</p><br>
<form action="/contract/delete/${contract.id}" method="post">
    <input type="submit" value="Розірвати контракт"/>
</form>
<div id="main">
    <div id="detail-page" class="article-area-wrap">
        <div class="article-area">
            <div class="article-content">
                <p style="text-align: center" class="p2">
                    <strong>Договір оренди транспортного засобу N ${contract.id}</strong>
                </p>
                <p class="p2" style="text-align: center">
                    <strong>1. ПРЕДМЕТ ДОГОВОРУ</strong>
                </p>
                <p class="p2">
                    1.1. В порядку і на умовах, визначених цим Договором, Орендодавець зобов'язується
                    передати Орендарю в тимчасове оплатне користування транспортний засіб вказаний у п. 1.2. цього Договору,
                    а Орендар зобов'язується прийняти його в тимчасове оплатне користування.<br>
                    1.2. Предмет оренди транспортний засіб:
                    тип транспортного засобу <b>${contract.typeTransport}</b>, кількість:<b>${contract.transportCount}</b>
                    Термін оренди: від <b>${contract.dateStartContract}</b> до <b>${contract.dateEndContract}</b>
                    Фірма: <b>${contract.firm}</b><br>
                    1.3. Транспортний засіб, зазначений у п. 1.2. цього договору
                    належить Орендодавцю на праві власності на підставі Свідоцтва
                </p>
                <p class="p2" style="text-align: center">
                    <strong>2. МЕТА І ПОРЯДОК ОРЕНДИ</strong>
                </p>
                <p class="p2">
                    2.1. Транспортний засіб орендується з метою: для використання у власних цілях.<br>
                    2.2. ТЗ передається в оренду Орендарю без права його передачі в оренду (суборенду) третім особам.<br>
                    2.3. Поточний та капітальний ремонт ТЗ здійснює Орендодавець, якщо необхідність даного<br>
                    ремонту виникла в наслідок нормального зносу ТЗ, крім випадку, коли пошкодження ТЗ виникло
                    внаслідок дій чи бездіяльності Орендаря.<br>
                </p>
                <p class="p2" style="text-align: center">
                    <strong>3. ПОРЯДОК ПЕРЕДАЧІ В ОРЕНДУ ТА ПОВЕРНЕННЯ ТЗ</strong>
                </p>
                <p class="p2">
                    3.1. Орендодавець передає Орендарю в користування ТЗ протягом 24 годин з моменту підписання
                    даного Договору та внесенням Орендарем гарантійного платежу на користь Орендодавця.
                    Факт передачі ТЗ засвідчується підписаним Сторонами Актом передачі транспортного засобу в оренду,
                    що є є ємним додатком до Договору.<br>
                    3.2. Орендар повертає Орендодавцю ТЗ до 20 рік. 00 хв. того ж дня припинення дії Договору.
                    Факт повернення ТЗ до Орендодавця підтверджується підписаним Сторонами Актом
                    приймання транспортного засобу з оренди.<br>
                    3.3. З моменту отримання ТЗ в користування Орендар несе ризик випадкової втрати,
                    пошкодження ТЗ перед Орендодавцем.<br>
                </p>
                <p class="p2" style="text-align: center">
                    <strong>4. ОРЕНДНА ПЛАТА І ПОРЯДОК РОЗРАХУНКІВ</strong>
                </p>
                <p class="p2">
                    4.1. Оренда плата та порядок розрахунків за Договором визначається Додатковою угодою до договору.
                </p>
                <p class="p2" style="text-align: center">
                    <strong>5. ПРАВА І ОБОВ'ЯЗКИ СТОРІН</strong>
                </p>
                <p class="p2">
                    <strong>5.1. Орендодавець за даним Договором має право:</strong><br>
                    5.1.1. Здійснювати перевірку використання Орендарем ТЗ.<br>
                    5.1.2. Вимагати відшкодування від Орендаря збитків, завданих йому внаслідок пошкодження
                    або погіршення стану ТЗ, порушень або невиконання умов даного Договору.<br>
                    <strong>5.2. Орендодавець за даним Договором зобов'язується:</strong><br>
                    5.2.1. Надати в оренду ТЗ у технічно справному стані та готуємо до експлуатації.<br>
                    5.2.2. Здійснювати капітальний та поточний ремонт в рамках нормального зносу ТЗ.<br>
                    5.2.3. Прийняти у Орендаря ТЗ після закінчення рядок оренди або розірвання Договору,
                    та підписати Акт приймання транспортного засобу з оренди.<br>
                    <strong>5.3. Орендар має право:</strong><br>
                    5.3.1. Якщо Орендар належний чином виконує свої обов'язки за Договором,
                    після закінчення рядок дії Договору, він має переважне право
                    перед іншими особами на укладення нового договору оренди транспортного засобу.<br>
                    5.3.2. Достроково розірвати даний Договір за згодою Орендодавця.<br>
                    <strong>5.4. Орендар зобов'язується:</strong><br>
                    5.4.1. Оглянути та прийняти у користування ТЗ відповідно до Договором.<br>
                    5.4.2. Використовувати ТЗ у чіткій відповідності до розділу 2 «МЕТА І ПОРЯДОК ОРЕНДИ» даного Договору.<br>
                    5.4.3. Дбайливо ставитись до орендованого ТЗ, забезпечуваті його схоронність
                    та не допускати погіршення його стану, пошкодження, викрадення.<br>
                    5.4.4. Своєчасно, у повному розмірі сплачувати орендну плату та гарантійний платіж
                    передбачений даним Договором та додатковими Угодами.<br>
                    5.4.5. Надавати Орендодавцю ТЗ для перевірки відповідно до даного Договору.<br>
                    5.4.6. Дотримуватися ПДР і інших вимоги чинного законодавства України при користуванні ТЗ;<br>
                    5.4.7. Після закінчення/розірвання Договору, повернути Орендодавцю ТЗ в належному
                    технічному стані в порядку, передбаченому цим Договором;
                </p>
                <p class="p2" style="text-align: center">
                    <strong>6. ВІДПОВІДАЛЬНІСТЬ СТОРІН І ВИРІШЕННЯ СПОРІВ</strong>
                </p>
                <p class="p2">
                    6.1. У випадку порушення своїх зобов'язань за цим Договором,
                    Сторони несуть відповідальність, визначену даним Договором та діючим в Україні законодавством.
                    Порушенням зобов'язання є його невиконання або неналежне виконання,
                    тобто виконання з порушенням умов, визначених змістом зобов'язання.<br>
                    6.2. Орендар зобов'язується відшкодовувати Орендодавцю у повному розмірі збитки,
                    що виникли в Орендодавця внаслідок дій/бездіяльності Орендаря
                    (вартість втраченого ТЗ, витрати на ремонт, вартість придбаних деталей,
                    відшкодування шкоди третім особам тощо).<br>
                    6.3. У випадку прострочення Орендарем рядок сплати орендної плати,
                    Орендар зобов'язаннями язаний сплатити Орендодавцю пеню у розмірі
                    подвійної облікової ставки НБУ, яка діяла у період прострочення від розміру орендної плати
                    за 1 календарний день.<br>
                    6.4. Усі суперечки, пов'язані з даним Договором або виникаючі в процесі виконання умов даного Договору,
                    вирішуються шляхом переговорів. Дотримання претензійного порядку є обов'язковим.
                    Терміни відповіді на претензію – 3 календарні дні з врахуванням терміну поштового обігу.
                    Якщо суперечки неможливо вирішити шляхом переговорів, вони вирішуються в судовому порядку
                    по встановленій підвідомчості і підсудності такої суперечки в порядку,
                    визначеному відповідним законодавством, що діє в Україні.
                </p>
                <p class="p2" style="text-align: center">
                    <strong>7. ФОРС-МАЖОР (ОБСТАВИНИ НЕПЕРЕБОРНОЇ СИЛИ)</strong>
                </p>
                <p class="p2">
                    7.1. У випадку настання форс-мажору – обставин непереборної сили – (війна, революції,
                    терористичні акти, збройні сутички, воєнні дії, аномальні природні явища, природні катаклізми,
                    бойкоти, страйки, громадські заворушення, акти державних органів незалежно від їх законності
                    чи незаконності й ін.), що безпосередньо перешкоджаючому виконанню зобов'язань, терміни виконання таких
                    зобов'язань відповідно відсуваються на час дії форс-мажорних обставин.
                </p>
            </div>
        </div>
    </div>
</div>
<div class="right-bar">
    <div style="height: 350px">
        <table class="table">
            <tr>
                <th class="th">Номер</th>
                <th class="th">Тип</th>
            </tr>
            <#list transport as item>
                <tr class="tr">
                    <td class="td">
                        <#if item.numberTransport == 0>
                            Номер відустній
                        <#else>
                            ${item.numberTransport}
                        </#if>
                    </td>
                    <td class="td">${item.typeTransport}</td>
                </tr>
            </#list>
        </table>
    </div>
</div>
</body>
</html>