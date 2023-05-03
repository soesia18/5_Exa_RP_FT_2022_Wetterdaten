package at.kaindorf.obeserver;

import at.kaindorf.data.Data;
import at.kaindorf.singleton.Calculator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Exa_RP_FT_2022_Wetterdaten<br>
 * <b>User:</b> Simon SchÃ¶ggler<br>
 * <b>Date:</b> 23. April 2023<br>
 * <b>Time:</b> 9:43 AM<br>
 */

public class Html implements IObserver {


    private String dataStr;

    public Html() {

    }

    @Override
    public void update() {
        try {
            FileWriter fw;
            File file = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "max.html").toFile();

            fw = new FileWriter(file);


            dataStr = "";
            Map<String, List<Data>> map = Calculator.getInstance().getMaxTemperatureOfAllStations();
            map.keySet().stream().sorted(Comparator.naturalOrder()).forEach(s -> {
                List<Data> data = map.get(s);
                dataStr += String.format("<p>" + s + "(" + data.size() + ")</p>\n<br>");
                data.forEach(data1 -> dataStr += String.format("\t<span>" + data1 + "</span>\n<br>"));
            });
            String str = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>WetterDaten</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    dataStr +
                    "</body>\n" +
                    "</html>";

            fw.write(str);
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
