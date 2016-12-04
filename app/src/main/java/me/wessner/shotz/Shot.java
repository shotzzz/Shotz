package me.wessner.shotz;

/**
 * Created by manue on 27.10.2016.
 */

public class Shot {

    private final String name;

    public Shot(String name) {
        this.name = name;
    }

    public static Shot of(String name){
        return new Shot(name);
    }

    public String getName() {
        return name;
    }
}
