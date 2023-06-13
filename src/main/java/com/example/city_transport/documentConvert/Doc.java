package com.example.city_transport.documentConvert;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.springframework.stereotype.Component;
import java.io.FileOutputStream;
@Component
@RequiredArgsConstructor
public class Doc {
    public void file(int id, String typeTransport, int transportCount, String dateStartContract, String dateEndContract, String firm){
        try {
            XWPFDocument docxModel = new XWPFDocument();
            XWPFParagraph bodyParagraph = docxModel.createParagraph();
            bodyParagraph.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun paragraphConfig = bodyParagraph.createRun();
            paragraphConfig.setFontSize(14);
            paragraphConfig.setColor("000000");
            paragraphConfig.setText("Договір оренди транспортного засобу N " + id);
            paragraphConfig.addBreak();
            paragraphConfig.setText("1. ПРЕДМЕТ ДОГОВОРУ");
            paragraphConfig.addBreak();
            paragraphConfig.setText("1.1. В порядку і на умовах, визначених цим Договором, Орендодавець зобов'язується " +
                    "передати Орендарю в тимчасове оплатне користування транспортний засіб вказаний у п. 1.2. цього Договору, " +
                    "а Орендар зобов'язується прийняти його в тимчасове оплатне користування.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("1.2. Предмет оренди транспортний засіб:");
            paragraphConfig.addBreak();
            paragraphConfig.setText("тип транспортного засобу " + typeTransport + ", кількість: " + transportCount +
                            "Термін оренди: від " + dateStartContract + " до " + dateEndContract + "Фірма: " + firm);
            paragraphConfig.addBreak();
            paragraphConfig.setText("1.3. Транспортний засіб, зазначений у п. 1.2. цього договору " +
                    "належить Орендодавцю на праві власності на підставі Свідоцтва");
            paragraphConfig.addBreak();
            paragraphConfig.setText("2. МЕТА І ПОРЯДОК ОРЕНДИ");
            paragraphConfig.addBreak();
            paragraphConfig.setText("2.1. Транспортний засіб орендується з метою: для використання у власних цілях.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("2.2. ТЗ передається в оренду Орендарю без права його передачі в оренду (суборенду) третім особам.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("2.3. Поточний та капітальний ремонт ТЗ здійснює Орендодавець, якщо необхідність даного " +
                    "ремонту виникла в наслідок нормального зносу ТЗ, крім випадку, коли пошкодження ТЗ виникло " +
                    "внаслідок дій чи бездіяльності Орендаря.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("3. ПОРЯДОК ПЕРЕДАЧІ В ОРЕНДУ ТА ПОВЕРНЕННЯ ТЗ");
            paragraphConfig.addBreak();
            paragraphConfig.setText("3.1. Орендодавець передає Орендарю в користування ТЗ протягом 24 годин з моменту підписання " +
                    "даного Договору та внесенням Орендарем гарантійного платежу на користь Орендодавця. " +
                    "Факт передачі ТЗ засвідчується підписаним Сторонами Актом передачі транспортного засобу в оренду, " +
                    "що є ємним додатком до Договору.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("3.2. Орендар повертає Орендодавцю ТЗ до 20 рік. 00 хв. того ж дня припинення дії Договору. " +
                    "Факт повернення ТЗ до Орендодавця підтверджується підписаним Сторонами Актом приймання транспортного засобу з оренди.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("3.3. З моменту отримання ТЗ в користування Орендар несе ризик випадкової втрати, пошкодження ТЗ перед Орендодавцем.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("4. ОРЕНДНА ПЛАТА І ПОРЯДОК РОЗРАХУНКІВ");
            paragraphConfig.addBreak();
            paragraphConfig.setText("4.1. Оренда плата та порядок розрахунків за Договором визначається Додатковою угодою до договору.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5. ПРАВА І ОБОВ'ЯЗКИ СТОРІН");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.1. Орендодавець за даним Договором має право:");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.1.1. Здійснювати перевірку використання Орендарем ТЗ.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.1.2. Вимагати відшкодування від Орендаря збитків, завданих йому внаслідок пошкодження" +
                                    "або погіршення стану ТЗ, порушень або невиконання умов даного Договору.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.2. Орендодавець за даним Договором зобов'язується:");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.2.1. Надати в оренду ТЗ у технічно справному стані та готуємо до експлуатації.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.2.2. Здійснювати капітальний та поточний ремонт в рамках нормального зносу ТЗ.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.2.3. Прийняти у Орендаря ТЗ після закінчення рядок оренди або розірвання Договору," +
                                    "та підписати Акт приймання транспортного засобу з оренди.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.3. Орендар має право:");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.3.1. Якщо Орендар належний чином виконує свої обов'язки за Договором, " +
                    "після закінчення рядок дії Договору, він має переважне право " +
                    "перед іншими особами на укладення нового договору оренди транспортного засобу.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.3.2. Достроково розірвати даний Договір за згодою Орендодавця.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.4. Орендар зобов'язується:");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.4.1. Оглянути та прийняти у користування ТЗ відповідно до Договором.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.4.2. Використовувати ТЗ у чіткій відповідності до розділу 2 «МЕТА І ПОРЯДОК ОРЕНДИ» даного Договору.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.4.3. Дбайливо ставитись до орендованого ТЗ, забезпечуваті його схоронність " +
                    "та не допускати погіршення його стану, пошкодження, викрадення.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.4.4. Своєчасно, у повному розмірі сплачувати орендну плату та гарантійний платіж " +
                    "передбачений даним Договором та додатковими Угодами.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.4.5. Надавати Орендодавцю ТЗ для перевірки відповідно до даного Договору.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.4.6. Дотримуватися ПДР і інших вимоги чинного законодавства України при користуванні ТЗ;");
            paragraphConfig.addBreak();
            paragraphConfig.setText("5.4.7. Після закінчення/розірвання Договору, повернути Орендодавцю ТЗ в належному " +
                    "технічному стані в порядку, передбаченому цим Договором;");
            paragraphConfig.addBreak();
            paragraphConfig.setText("6. ВІДПОВІДАЛЬНІСТЬ СТОРІН І ВИРІШЕННЯ СПОРІВ");
            paragraphConfig.addBreak();
            paragraphConfig.setText("6.1. У випадку порушення своїх зобов'язань за цим Договором, " +
                    "Сторони несуть відповідальність, визначену даним Договором та діючим в Україні законодавством. " +
                    "Порушенням зобов'язання є його невиконання або неналежне виконання, " +
                    "тобто виконання з порушенням умов, визначених змістом зобов'язання.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("6.2. Орендар зобов'язується відшкодовувати Орендодавцю у повному розмірі збитки, " +
                    "що виникли в Орендодавця внаслідок дій/бездіяльності Орендаря " +
                    "(вартість втраченого ТЗ, витрати на ремонт, вартість придбаних деталей, " +
                    "відшкодування шкоди третім особам тощо).");
            paragraphConfig.addBreak();
            paragraphConfig.setText("6.3. У випадку прострочення Орендарем рядок сплати орендної плати, " +
                    "Орендар зобов'язаннями язаний сплатити Орендодавцю пеню у розмірі " +
                    "подвійної облікової ставки НБУ, яка діяла у період прострочення від розміру орендної плати за 1 календарний день.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("6.4. Усі суперечки, пов'язані з даним Договором або виникаючі в процесі виконання умов даного Договору, " +
                    "вирішуються шляхом переговорів. Дотримання претензійного порядку є обов'язковим. " +
                    "Терміни відповіді на претензію – 3 календарні дні з врахуванням терміну поштового обігу. " +
                    "Якщо суперечки неможливо вирішити шляхом переговорів, вони вирішуються в судовому порядку " +
                    "по встановленій підвідомчості і підсудності такої суперечки в порядку, " +
                    "визначеному відповідним законодавством, що діє в Україні.");
            paragraphConfig.addBreak();
            paragraphConfig.setText("7. ФОРС-МАЖОР (ОБСТАВИНИ НЕПЕРЕБОРНОЇ СИЛИ)");
            paragraphConfig.addBreak();
            paragraphConfig.setText("7.1. У випадку настання форс-мажору – обставин непереборної сили – (війна, революції, " +
                    "терористичні акти, збройні сутички, воєнні дії, аномальні природні явища, природні катаклізми, " +
                    "бойкоти, страйки, громадські заворушення, акти державних органів незалежно від їх законності чи " +
                    "незаконності й ін.), що безпосередньо перешкоджаючому виконанню зобов'язань, терміни виконання таких " +
                    "зобов'язань відповідно відсуваються на час дії форс-мажорних обставин.");
            String fileName = "contract" + id + ".docx";
            FileOutputStream outputStream = new FileOutputStream("contracts/" + fileName);
            docxModel.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
