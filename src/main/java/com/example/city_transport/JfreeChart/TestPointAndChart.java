//package com.example.city_transport.JfreeChart;
//
//import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
//import org.apache.poi.hssf.usermodel.HSSFPatriarch;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.jfree.chart.ChartColor;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.*;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.renderer.category.LineAndShapeRenderer;
//import org.jfree.chart.title.LegendTitle;
//import org.jfree.chart.title.TextTitle;
//import org.jfree.data.category.DefaultCategoryDataset;
//import org.jfree.ui.RectangleEdge;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//import java.util.ArrayList;
//
//public class TestPointAndChart {
//    public static void main(String[] args) throws Exception {
//        // лист Excel2003
//        HSSFWorkbook wb = new HSSFWorkbook();
//        HSSFSheet sheet = wb.createSheet("Sheet 1");
//        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
//        ;
//        // Устанавливаем конкретные данные
//        List<String> timeList = new ArrayList<String>();
//        timeList.add("10:00");
//        timeList.add("11:00");
//        timeList.add("12:00");
//        List<Integer> appList = new ArrayList<Integer>();
//        appList.add(120);
//        appList.add(200);
//        appList.add(150);
//        List<Integer> oraList = new ArrayList<Integer>();
//        oraList.add(230);
//        oraList.add(200);
//        oraList.add(235);
//        // Установить шрифт, цвет и размер шрифта на картинке
//        Font titleFont = new Font("Полужирный", Font.BOLD, 12);
//        Font xfont = new Font("Полужирный", Font.BOLD, 10);
//        Font labelFont = new Font("Bold", Font.BOLD, 10);
//        // Установить область данных
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        for (int i = 0; i < timeList.size(); i++) {
//            String time = timeList.get(i);
//            dataset.addValue(appList.get(i), "«яблоко»", "время");
//            dataset.addValue(oraList.get(i), "«оранжевый»", "время");
//        }
//        JFreeChart chart = ChartFactory.createLineChart("Продажи периода фруктов", "Время", "Продажи", "набор данных", PlotOrientation.VERTICAL, true,
//                true, true);
//        // Установить шрифт легенды
//        chart.getLegend().setItemFont(new Font("Bold", Font.BOLD, 10));
//        // Установить шрифт заголовка
//        chart.setTitle(new TextTitle(chart.getTitle().getText(), titleFont));
//        // Графический рисунок объекта структуры
//        CategoryPlot plot = chart.getCategoryPlot();
//        // Получить объект, отображающий строку
//        LineAndShapeRenderer lasp = (LineAndShapeRenderer) plot.getRenderer();
//        // Установить, будет ли точка перегиба видимой / отображается ли точка перегиба
//        lasp.setBaseShapesVisible(true);
//        // Установить разные точки перегиба с разными формами
//        lasp.setDrawOutlines(true);
//        // Установить, будет ли линия отображаться как цвет заливки
//        lasp.setUseFillPaint(false);
//        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
//        // Установить размер и цвет полилинии
//        renderer.setSeriesStroke(0, new BasicStroke(1.0F));
//        renderer.setSeriesPaint(0, new Color(210, 105, 30));
//        renderer.setSeriesStroke(1, new BasicStroke(1.0F));
//        renderer.setSeriesPaint(1, new Color(0, 191, 255));
//        // Устанавливаем размер вершин
//        lasp.setSeriesOutlineStroke(0, new BasicStroke(0.025F));
//        lasp.setSeriesOutlineStroke(1, new BasicStroke(0.05F));
//        // Установить линии сетки
//        plot.setDomainGridlinePaint(Color.gray);
//        plot.setDomainGridlinesVisible(true);
//        plot.setRangeGridlinePaint(Color.gray);
//        plot.setRangeGridlinesVisible(true);
//        // ось х
//        CategoryAxis domainAxis = plot.getDomainAxis();
//        // Устанавливаем не отображать ось x, то есть выравниваем ось x и область данных
//        domainAxis.setAxisLineVisible(false);
//        // заголовок оси x
//        domainAxis.setLabelFont(xfont);
//        // Наклон данных оси X
//        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.95D));
//        // Числовой шрифт по координатам оси X
//        domainAxis.setTickLabelFont(labelFont);
//        // Устанавливаем интервал оси Y
//        NumberAxis numAxis = (NumberAxis) plot.getRangeAxis();
//        numAxis.setTickUnit(new NumberTickUnit(50));
//        // ось y
//        ValueAxis rangeAxis = plot.getRangeAxis();
//        rangeAxis.setLabelFont(xfont);
//        // Установить ось y не для отображения, то есть совпадать с областью данных
//        rangeAxis.setAxisLineVisible(false);
//        // Числовой шрифт по координатам оси Y
//        rangeAxis.setTickLabelFont(labelFont);
//        rangeAxis.setFixedDimension(0);
//        CategoryPlot cp = chart.getCategoryPlot();
//        // настройка цвета фона
//        cp.setBackgroundPaint(ChartColor.WHITE);
//        cp.setRangeGridlinePaint(ChartColor.GRAY);
//        // Создаем легенду и устанавливаем положение легенды. Настройки здесь на самом деле не работают. Как их установить ниже
//        LegendTitle legendTitle = new LegendTitle(chart.getPlot());
//        legendTitle.setPosition(RectangleEdge.BOTTOM);
//        try {
//            ChartUtilities.writeChartAsPNG(byteArrayOut, chart, 400, 200);
//            String fileSavePath = "exTest.png";
//            BufferedImage bufferImg = ImageIO.read(new File(fileSavePath));
//            ImageIO.write(bufferImg, "png", byteArrayOut);
//        } catch (IOException e) {
//        }
//        // Топ-менеджер по рисованию, только один лист может получить один (обязательно обратите внимание на этот момент)
//        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
//        // Восемь параметров, первые четыре указывают положение изображения от края начальной ячейки и конечной ячейки,
//        // Последние четыре указывают положение начальной и конечной ячеек, как показано ниже, от второго столбца до 12-го столбца, от первого ряда до 15-го ряда, необходимо обратить внимание на то, что начальная позиция Excel равна 0
//        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) 2, (short) 1, (short) 12, (short) 15);
//        anchor.setAnchorType(3);
//        // Вставить картинку
//        patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG));
//        // суффикс excel2003
//        FileOutputStream fileOut = new FileOutputStream("D://myExcel.xls");
//        wb.write(fileOut);
//        fileOut.close();
//
//    }
//}
