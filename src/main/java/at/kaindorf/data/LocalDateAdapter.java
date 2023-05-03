package at.kaindorf.data;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Exa_RP_FT_2022_Wetterdaten<br>
 * <b>User:</b> Simon SchÃ¶ggler<br>
 * <b>Date:</b> 21. April 2023<br>
 * <b>Time:</b> 6:26 PM<br>
 */

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private static final DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public LocalDate unmarshal(String s) throws Exception {
        return LocalDate.parse(s, dTF);
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return localDate.format(dTF);
    }
}
