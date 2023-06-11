package com.example.city_transport.documentConvert;
import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.models.Contract;
import com.example.city_transport.services.ContractService;
import com.itextpdf.html2pdf.HtmlConverter;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class Doc {
    public void file(int id, String typeTransport, int transportCount, String dateStartContract, String dateEndContract, String firm){
        try {
            XWPFDocument docxModel = new XWPFDocument();
            CTSectPr ctSectPr = docxModel.getDocument().getBody().addNewSectPr();
            XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(docxModel, ctSectPr);
            CTP ctpHeaderModel = createHeaderModel(
                    "Верхний колонтитул - создано с помощью Apache POI на Java :)"
            );
            XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeaderModel, docxModel);
            headerFooterPolicy.createHeader(
                    XWPFHeaderFooterPolicy.DEFAULT,
                    new XWPFParagraph[]{headerParagraph}
            );
            CTP ctpFooterModel = createFooterModel("Просто нижний колонтитул");
            XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooterModel, docxModel);
            headerFooterPolicy.createFooter(
                    XWPFHeaderFooterPolicy.DEFAULT,
                    new XWPFParagraph[]{footerParagraph}
            );
            XWPFParagraph bodyParagraph = docxModel.createParagraph();
            bodyParagraph.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun paragraphConfig = bodyParagraph.createRun();
            paragraphConfig.setFontSize(14);
            paragraphConfig.setColor("000000");
            paragraphConfig.setText(
                    "Договір оренди транспортного засобу N " + id + "\n" + " 1. ПРЕДМЕТ ДОГОВОРУ\n"
                            .concat("1.1. В порядку і на умовах, визначених цим Договором, Орендодавець зобов'язується")
                            .concat(" передати Орендарю в тимчасове оплатне користування транспортний засіб вказаний у п. 1.2. цього Договору,")
                            .concat(" а Орендар зобов'язується прийняти його в тимчасове оплатне користування.\n")
                            .concat("1.2. Предмет оренди транспортний засіб:\n")
                            .concat("тип транспортного засобу ".concat(typeTransport).concat(", кількість: ").concat(String.valueOf(transportCount)))
                            .concat("Термін оренди: від ".concat(dateStartContract).concat(" до ").concat(dateEndContract))
                            .concat("Фірма: ".concat(firm).concat("\n"))
                            .concat("1.3. Транспортний засіб, зазначений у п. 1.2. цього договору")
                            .concat(" належить Орендодавцю на праві власності на підставі Свідоцтва\n")
                            .concat("2. МЕТА І ПОРЯДОК ОРЕНДИ\n")
                            .concat("2.1. Транспортний засіб орендується з метою: для використання у власних цілях.")
                            .concat("2.2. ТЗ передається в оренду Орендарю без права його передачі в оренду (суборенду) третім особам.")
                            .concat("2.3. Поточний та капітальний ремонт ТЗ здійснює Орендодавець, якщо необхідність даного")
                            .concat("ремонту виникла в наслідок нормального зносу ТЗ, крім випадку, коли пошкодження ТЗ виникло")
                            .concat("внаслідок дій чи бездіяльності Орендаря.\n")
                            .concat("3. ПОРЯДОК ПЕРЕДАЧІ В ОРЕНДУ ТА ПОВЕРНЕННЯ ТЗ\n")
                            .concat("3.1. Орендодавець передає Орендарю в користування ТЗ протягом 24 годин з моменту підписання")
                            .concat(" даного Договору та внесенням Орендарем гарантійного платежу на користь Орендодавця.")
                            .concat(" Факт передачі ТЗ засвідчується підписаним Сторонами Актом передачі транспортного засобу в оренду,")
                            .concat(" що є є ємним додатком до Договору.\n")
                            .concat("3.2. Орендар повертає Орендодавцю ТЗ до 20 рік. 00 хв. того ж дня припинення дії Договору.")
                            .concat(" Факт повернення ТЗ до Орендодавця підтверджується підписаним Сторонами Актом")
                            .concat(" приймання транспортного засобу з оренди.\n")
                            .concat("3.3. З моменту отримання ТЗ в користування Орендар несе ризик випадкової втрати,")
                            .concat(" пошкодження ТЗ перед Орендодавцем.\n")
                            .concat("4. ОРЕНДНА ПЛАТА І ПОРЯДОК РОЗРАХУНКІВ\n")
                            .concat("4.1. Оренда плата та порядок розрахунків за Договором визначається Додатковою угодою до договору.\n")
                            .concat("5. ПРАВА І ОБОВ'ЯЗКИ СТОРІН\n")
                            .concat("5.1. Орендодавець за даним Договором має право:\n")
                            .concat("5.1.1. Здійснювати перевірку використання Орендарем ТЗ.\n")
                            .concat("5.1.2. Вимагати відшкодування від Орендаря збитків, завданих йому внаслідок пошкодження")
                            .concat(" або погіршення стану ТЗ, порушень або невиконання умов даного Договору.\n")
                            .concat("5.2. Орендодавець за даним Договором зобов'язується:\n")
                            .concat("5.2.1. Надати в оренду ТЗ у технічно справному стані та готуємо до експлуатації.\n")
                            .concat("5.2.2. Здійснювати капітальний та поточний ремонт в рамках нормального зносу ТЗ.\n")
                            .concat("5.2.3. Прийняти у Орендаря ТЗ після закінчення рядок оренди або розірвання Договору,")
                            .concat(" та підписати Акт приймання транспортного засобу з оренди.\n")
                            .concat("5.3. Орендар має право:\n")
                            .concat("5.3.1. Якщо Орендар належний чином виконує свої обов'язки за Договором,")
                            .concat(" після закінчення рядок дії Договору, він має переважне право")
                            .concat(" перед іншими особами на укладення нового договору оренди транспортного засобу.\n")
                            .concat("5.3.2. Достроково розірвати даний Договір за згодою Орендодавця.\n")
                            .concat("5.4. Орендар зобов'язується:\n")
                            .concat("5.4.1. Оглянути та прийняти у користування ТЗ відповідно до Договором.\n")
                            .concat("5.4.2. Використовувати ТЗ у чіткій відповідності до розділу 2 «МЕТА І ПОРЯДОК ОРЕНДИ» даного Договору.\n")
                            .concat("5.4.3. Дбайливо ставитись до орендованого ТЗ, забезпечуваті його схоронність")
                            .concat(" та не допускати погіршення його стану, пошкодження, викрадення.\n")
                            .concat("5.4.4. Своєчасно, у повному розмірі сплачувати орендну плату та гарантійний платіж")
                            .concat(" передбачений даним Договором та додатковими Угодами.\n")
                            .concat("5.4.5. Надавати Орендодавцю ТЗ для перевірки відповідно до даного Договору.\n")
                            .concat("5.4.6. Дотримуватися ПДР і інших вимоги чинного законодавства України при користуванні ТЗ;\n")
                            .concat("5.4.7. Після закінчення/розірвання Договору, повернути Орендодавцю ТЗ в належному")
                            .concat(" технічному стані в порядку, передбаченому цим Договором;")
                            .concat("6. ВІДПОВІДАЛЬНІСТЬ СТОРІН І ВИРІШЕННЯ СПОРІВ\n")
                            .concat("6.1. У випадку порушення своїх зобов'язань за цим Договором,")
                            .concat(" Сторони несуть відповідальність, визначену даним Договором та діючим в Україні законодавством.")
                            .concat(" Порушенням зобов'язання є його невиконання або неналежне виконання,")
                            .concat(" тобто виконання з порушенням умов, визначених змістом зобов'язання.\n")
                            .concat("6.2. Орендар зобов'язується відшкодовувати Орендодавцю у повному розмірі збитки,")
                            .concat(" що виникли в Орендодавця внаслідок дій/бездіяльності Орендаря")
                            .concat(" (вартість втраченого ТЗ, витрати на ремонт, вартість придбаних деталей,")
                            .concat(" відшкодування шкоди третім особам тощо).\n")
                            .concat("6.3. У випадку прострочення Орендарем рядок сплати орендної плати,")
                            .concat(" Орендар зобов'язаннями язаний сплатити Орендодавцю пеню у розмірі")
                            .concat(" подвійної облікової ставки НБУ, яка діяла у період прострочення від розміру орендної плати")
                            .concat(" за 1 календарний день.\n")
                            .concat("6.4. Усі суперечки, пов'язані з даним Договором або виникаючі в процесі виконання умов даного Договору,")
                            .concat(" вирішуються шляхом переговорів. Дотримання претензійного порядку є обов'язковим.")
                            .concat(" Терміни відповіді на претензію – 3 календарні дні з врахуванням терміну поштового обігу.")
                            .concat(" Якщо суперечки неможливо вирішити шляхом переговорів, вони вирішуються в судовому порядку")
                            .concat(" по встановленій підвідомчості і підсудності такої суперечки в порядку,")
                            .concat(" визначеному відповідним законодавством, що діє в Україні.\n")
                            .concat("7. ФОРС-МАЖОР (ОБСТАВИНИ НЕПЕРЕБОРНОЇ СИЛИ)\n")
                            .concat("7.1. У випадку настання форс-мажору – обставин непереборної сили – (війна, революції,")
                            .concat(" терористичні акти, збройні сутички, воєнні дії, аномальні природні явища, природні катаклізми,")
                            .concat(" бойкоти, страйки, громадські заворушення, акти державних органів незалежно від їх законності")
                            .concat(" чи незаконності й ін.), що безпосередньо перешкоджаючому виконанню зобов'язань, терміни виконання таких")
                            .concat(" зобов'язань відповідно відсуваються на час дії форс-мажорних обставин.")
            );
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Test\\" +
                    "Договор.DOCX");
            docxModel.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Успешно записан в файл");
    }
    private static CTP createFooterModel(String footerContent) {
        CTP ctpFooterModel = CTP.Factory.newInstance();
        CTR ctrFooterModel = ctpFooterModel.addNewR();
        CTText cttFooter = ctrFooterModel.addNewT();
        cttFooter.setStringValue(footerContent);
        return ctpFooterModel;
    }
    private static CTP createHeaderModel(String headerContent) {
        CTP ctpHeaderModel = CTP.Factory.newInstance();
        CTR ctrHeaderModel = ctpHeaderModel.addNewR();
        CTText cttHeader = ctrHeaderModel.addNewT();
        cttHeader.setStringValue(headerContent);
        return ctpHeaderModel;
    }
}
