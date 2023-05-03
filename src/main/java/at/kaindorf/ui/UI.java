package at.kaindorf.ui;

import at.kaindorf.data.Data;
import at.kaindorf.obeserver.Console;
import at.kaindorf.obeserver.Html;
import at.kaindorf.obeserver.Subject;
import at.kaindorf.singleton.Calculator;
import at.kaindorf.visitor.SearchXmlFiles;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Exa_RP_FT_2022_Wetterdaten<br>
 * <b>User:</b> Simon SchÃ¶ggler<br>
 * <b>Date:</b> 23. April 2023<br>
 * <b>Time:</b> 9:39 AM<br>
 */

public class UI extends Subject {
    public static void main(String[] args) {

        UI ui = new UI();
        SearchXmlFiles searchXmlFiles = new SearchXmlFiles(Paths.get(System.getProperty("user.dir"), "src", "main",
                "resources", "Weatherdata_xml"));

        List<Path> paths = searchXmlFiles.getXmlFiles(Paths.get(System.getProperty("user.dir"), "src", "main",
                "resources", "Weatherdata_xml"));

        Path allDataPath = Paths.get(System.getProperty("user.dir"), "src", "main",
                "resources", "Weatherdata_xml", "allData.xml");

        Console console = new Console();
        Html html = new Html();
        ui.registerObserver(console);
        ui.registerObserver(html);

        int selection = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("0 ... Beenden");
            System.out.println("1 ... Daten vom Verzeichnis 'resources' laden");
            System.out.println("2 ... Daten von der Datei 'allData.xml' laden");
            System.out.println("3 ... Duplikate entfernen (mit WHILE Schleife)");
            System.out.println("4 ... Duplikate entfernen (mit Stream API)");
            System.out.println("5 ... Maximaler Temperaturwert von allen Stationen");
            System.out.print("\nWahl[0,5] = ");
            selection = scanner.nextInt();
            System.out.println("\nGewählt wurde = " + selection);

            switch (selection) {
                case 1 -> {
                    Calculator.getInstance().addDataFromXmlFiles(paths);
                    ui.notifyObservers();
                }
                case 2 -> {
                    Calculator.getInstance().addDataFromDataCollection(allDataPath);
                    ui.notifyObservers();
                }
                case 3 -> {
                    Calculator.getInstance().removeDuplicates1();
                    ui.notifyObservers();
                }
                case 4 -> {
                    Calculator.getInstance().removeDuplicates2();
                    ui.notifyObservers();
                }
                case 5 -> ui.printMaxTempOfAllStations(Calculator.getInstance().getMaxTemperatureOfAllStations());
            }

        } while (selection != 0);
    }

    private void printMaxTempOfAllStations(Map<String, List<Data>> map) {

        map.keySet().stream().sorted(Comparator.naturalOrder()).forEach(s -> {
            List<Data> data = map.get(s);
            System.out.println(s + "(" + data.size() + ")");
            data.forEach(data1 -> System.out.println("\t" + data1));
        });

        /*map.forEach((s, data) -> {
            System.out.println(s + "(" + data.size() + ")");
            data.forEach(data1 -> System.out.println("\t" + data1));
        });*/
    }
}
