import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class MainStarter {

  public static void main(String[] args) throws IOException {
    List<Double> inputSignal = ReadingFiles.readFile("01.txt"); // загрузка исходного текстового файла
    TryToProcess filteridze = new TryToProcess(); // создание объекта пользовательского класса
    BuildWindow.Drawing(BuildWindow.bindSeries(inputSignal, "WeAreTheChampions"),
        BuildWindow.bindSeries(filteridze.filterSig(inputSignal), "New Window"));//Построение двух графиков.
    // 1 - исходный с названием WeAreTheChampions
    // 2 - список List обработанного сигнала. Аргумент этой функции - inputSignal - исходный сигнал. Назване графика New window
    System.out.println(Collections.max(inputSignal));// вывод на экран максимума списка inputSignal
    System.out.println("Test");
  }
}
