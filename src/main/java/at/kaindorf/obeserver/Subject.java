package at.kaindorf.obeserver;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Exa_RP_FT_2022_Wetterdaten<br>
 * <b>User:</b> Simon SchÃ¶ggler<br>
 * <b>Date:</b> 23. April 2023<br>
 * <b>Time:</b> 9:40 AM<br>
 */

public abstract class Subject {
    private List<IObserver> iObservers = new ArrayList<>();

    public void registerObserver (IObserver o) {
        iObservers.add(o);
    }

    public void unregisterObserver (IObserver o) {
        iObservers.remove(o);
    }

    public void notifyObservers() {
        iObservers.forEach(IObserver::update);
    }
}
