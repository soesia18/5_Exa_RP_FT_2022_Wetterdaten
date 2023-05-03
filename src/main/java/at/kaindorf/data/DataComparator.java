package at.kaindorf.data;

import java.util.Comparator;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Exa_RP_FT_2022_Wetterdaten<br>
 * <b>User:</b> Simon SchÃ¶ggler<br>
 * <b>Date:</b> 21. April 2023<br>
 * <b>Time:</b> 6:26 PM<br>
 */

public class DataComparator implements Comparator<Data> {


    @Override
    public int compare(Data o1, Data o2) {
        int comName = o1.getName().compareTo(o2.getName());

        if (comName != 0) {
            return comName;
        }
        return o1.getDate().compareTo(o2.getDate());
    }
}
