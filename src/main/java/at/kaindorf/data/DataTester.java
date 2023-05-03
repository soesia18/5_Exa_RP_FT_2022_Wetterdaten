package at.kaindorf.data;

import at.kaindorf.visitor.SearchXmlFiles;

import javax.xml.bind.JAXB;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Exa_RP_FT_2022_Wetterdaten<br>
 * <b>User:</b> Simon SchÃ¶ggler<br>
 * <b>Date:</b> 22. April 2023<br>
 * <b>Time:</b> 10:18 AM<br>
 */

public class DataTester {
    public static void main(String[] args) {
        File file = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "Weatherdata_xml", "allData" +
                ".xml").toFile();

        DataCollection dataCollection = JAXB.unmarshal(file, DataCollection.class);

        SearchXmlFiles searchXmlFiles = new SearchXmlFiles(Paths.get(System.getProperty("user.dir"), "src", "main",
                "resources", "Weatherdata_xml"));

        List<Path> paths = searchXmlFiles.getXmlFiles(Paths.get(System.getProperty("user.dir"), "src", "main",
                "resources", "Weatherdata_xml"));

        System.out.println();
    }
}
