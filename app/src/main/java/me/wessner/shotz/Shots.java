package me.wessner.shotz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manue on 27.10.2016.
 */

public class Shots {

    private static List<Shot> shots;

    public static List<Shot> getShots() {
        if (shots == null) {
            shots = new ArrayList<>(260);
            for (int i = 0; i < 260; i++) {
                shots.add(new Shot("Shot " + i));
            }
        }
        return shots;
    }
}
