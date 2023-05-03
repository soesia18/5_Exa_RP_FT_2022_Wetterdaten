package at.kaindorf.singleton;

import at.kaindorf.data.Data;
import at.kaindorf.data.DataCollection;

import javax.xml.bind.JAXB;
import java.nio.file.Path;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Exa_RP_FT_2022_Wetterdaten<br>
 * <b>User:</b> Simon SchÃ¶ggler<br>
 * <b>Date:</b> 23. April 2023<br>
 * <b>Time:</b> 10:25 AM<br>
 */

public class XmlDal {
    private static XmlDal instance;

    private XmlDal () {

    }

    public synchronized static XmlDal getInstance() {
        if (instance == null) {
            instance = new XmlDal();
        }
        return instance;
    }

    public Data loadData (Path file) {
        return JAXB.unmarshal(file.toFile(), Data.class);
    }

    public DataCollection loadDataCollection (Path file) {
        return JAXB.unmarshal(file.toFile(), DataCollection.class);
    }
}
