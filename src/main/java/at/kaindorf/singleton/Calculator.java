package at.kaindorf.singleton;

import at.kaindorf.data.Data;
import at.kaindorf.data.DataCollection;
import at.kaindorf.data.DataComparator;

import javax.xml.bind.JAXB;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Exa_RP_FT_2022_Wetterdaten<br>
 * <b>User:</b> Simon SchÃ¶ggler<br>
 * <b>Date:</b> 23. April 2023<br>
 * <b>Time:</b> 9:44 AM<br>
 */

public class Calculator {
    private static Calculator instance;

    private List<Data> dataList;
    private Path workingDirectory;

    private Calculator () {
        dataList = new ArrayList<>();
    }

    public synchronized static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    public void addDataFromXmlFiles (List<Path> xmlFiles) {
        dataList.addAll(xmlFiles.stream().map(path -> XmlDal.getInstance().loadData(path)).filter(data -> data.getName() != null).toList());
    }

    public void addDataFromDataCollection (Path file) {
        dataList.addAll(XmlDal.getInstance().loadDataCollection(file).getData());
    }

    public void removeDuplicates1 () {
        dataList.sort(new DataComparator());

        int i = 1;
        while (i < dataList.size()) {
            if (dataList.get(i).equals(dataList.get(i - 1))) {
                dataList.remove(i);
            } else {
                i++;
            }
        }

    }

    public void removeDuplicates2 () {
        dataList = dataList.stream().distinct().collect(Collectors.toList());
    }

    public String getStationNamesAsString () {
        return dataList.stream().map(Data::getName).distinct().collect(Collectors.joining(", "));
    }

    public Map<String, List<Data>> getMaxTemperatureOfAllStations() {

        if (dataList.size() == 0 || containDup()) {
            return new HashMap<>();
        }

        Map<String, List<Data>> map =
                dataList.stream().sorted(Comparator.comparing(Data::getName)).collect(Collectors.groupingBy(Data::getName));

        map.forEach((s, data) -> {
            float max = (float)data.stream().mapToDouble(Data::getTmax).max().getAsDouble();

            data =
                    data
                            .stream()
                            .filter(data1 -> data1.getTmax() <= max*1.03 && data1.getTmax() >= max*0.97)
                            .sorted(Comparator.comparing(Data::getName))
                            .collect(Collectors.toList());
            map.put(s, data);
        });

        return map;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    private boolean containDup () {
        return dataList.size() != dataList.stream().distinct().count();
    }
}
