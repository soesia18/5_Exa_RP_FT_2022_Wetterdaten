package at.kaindorf.data;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Exa_RP_FT_2022_Wetterdaten<br>
 * <b>User:</b> Simon SchÃ¶ggler<br>
 * <b>Date:</b> 21. April 2023<br>
 * <b>Time:</b> 6:26 PM<br>
 */

@Getter
@XmlRootElement(name = "Umweltschutzanalyse")
public class DataCollection {
    @XmlElementWrapper(name = "Messungen")
    @XmlElement(name = "Messung")
    private List<Data> data;
}
