package at.kaindorf.data;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Exa_RP_FT_2022_Wetterdaten<br>
 * <b>User:</b> Simon SchÃ¶ggler<br>
 * <b>Date:</b> 21. April 2023<br>
 * <b>Time:</b> 6:26 PM<br>
 */

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    @XmlAttribute(name = "Station")
    private String name;
    @XmlElement(name = "Datum")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate date;
    @XmlElement(name = "Tmin")
    private float tmin;
    @XmlElement(name = "Tmax")
    private float tmax;
    @XmlElement(name = "Niederschlagsmenge")
    private float precipitation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (!Objects.equals(name, data.name)) return false;
        return Objects.equals(date, data.date);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format(getClass().getSimpleName() +
                " { " + name + ", " + date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +
                ", " + tmin + ", " + tmax + ", " + precipitation + " }");
    }
}
