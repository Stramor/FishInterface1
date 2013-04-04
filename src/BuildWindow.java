import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuildWindow {
  //создание кнопки
  //setButton(название панели, куда устанавливается кнопка,
  // название кнопки,
  // задание ширины, высоты);
  public static void setButton(Container pane, JButton name, int width, int height) {
    name.setPreferredSize(new Dimension(width, height));
    pane.add(name);
  }
  //Добавление первой значимой панели на окно
  public static JPanel addPanelOneToPane() {
    JPanel panelOne = new JPanel();
    panelOne.setVisible(true);
    panelOne.setBackground(new Color(70, 110, 130).brighter());

    JButton button1 = new JButton("First");
    setButton(panelOne, button1, 100,100);
    button1.addActionListener(new actionListenerBut());

    JButton button2 = new JButton("Process");
    setButton(panelOne, button2, 100,100);
    button2.addActionListener(new actionListenerBut2());

    panelOne.setAlignmentX(Component.CENTER_ALIGNMENT);
    return panelOne;
  }
  //Добавление второй(и последующей) значимой панели с графиком на окно
  public static JPanel addPanelTwoToPane(JFreeChart chart) {
    JPanel panelTwo = new JPanel();
    ChartPanel chPanel = new ChartPanel(chart);
    chPanel.setPreferredSize(WindowUtils.getDimensionFromPercent(45, 32));
    panelTwo.add(chPanel);
    panelTwo.setBackground(new Color(255,255,255));
    panelTwo.setVisible(true);
    return panelTwo;
  }
  //привязка списка к набору точек для графика series. text - это название графика
  public static XYSeries bindSeries(java.util.List<Double> doubles, String text){
    XYSeries series = new XYSeries(text);
    int i = 0;
    for (Double d : doubles) {
      series.add(i++, d);
    }
    return series;
  }
  //функция слежения и выполнения действий при нажатии кнопки 1
  public static class actionListenerBut implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.out.println("But1 was clicked");
    }
  }
  //функция слежения и выполнения действий при нажатии кнопки 2
  public static class actionListenerBut2 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.out.println("But2 was clicked");
    }
  }
  //создание окна с панелями (с графиками)
  public static void Drawing(XYSeries seriesLoc, XYSeries seriesProc){
    XYSeriesCollection xydataset = new XYSeriesCollection(); // добавление контейнера для построение 1 графика
    xydataset.addSeries(seriesLoc);// добавление в контейнер набора для графика исходного сигнала
    JFreeChart chart = ChartFactory.createXYLineChart("", "i", "mV", xydataset, PlotOrientation.VERTICAL, true, true, true); //построение
    XYSeriesCollection xydatasetProc = new XYSeriesCollection(); // добавление контейнера для построение 2 графика
    xydatasetProc.addSeries(seriesProc); // добавление в контейнер набора для графика обработанного сигнала
    JFreeChart chartProc = ChartFactory.createXYLineChart("", "i", "mV", xydatasetProc, PlotOrientation.VERTICAL, true, true, true);//построение

    JFrame frame = new JFrame("MinimalStaticChart");//создание окна
    //frame.getContentPane().add(addPanelOneToPane()); //добавление кнопок
    frame.getContentPane().add(addPanelTwoToPane(chart)); // добавление в окно первого графика
    frame.getContentPane().add(addPanelTwoToPane(chartProc)); // добавление в окно второго графика
    frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); // определение метода расположения панелей
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // закрывает программу при закрытии окна
    frame.setSize(WindowUtils.getDimensionFromPercent(50, 70)); // определяет размеры окна
    frame.setResizable(false);
    WindowUtils.centerOnScreenAndSetVisible(frame); //центрирует окно по экрану
  }
}
