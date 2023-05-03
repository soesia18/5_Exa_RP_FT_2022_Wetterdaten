package at.kaindorf.obeserver;

import at.kaindorf.singleton.Calculator;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Exa_RP_FT_2022_Wetterdaten<br>
 * <b>User:</b> Simon SchÃ¶ggler<br>
 * <b>Date:</b> 23. April 2023<br>
 * <b>Time:</b> 9:43 AM<br>
 */

public class Console implements IObserver {
    @Override
    public void update() {
        System.out.println("Anzahl der Datensätze = " + Calculator.getInstance().getDataList().size());
        System.out.println(Calculator.getInstance().getStationNamesAsString());
    }
}
