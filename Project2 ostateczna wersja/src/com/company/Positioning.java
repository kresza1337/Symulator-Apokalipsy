package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Positioning {

    /**losuje int pozycji x */
    public static int getRandomPositionX() {
        return ThreadLocalRandom.current().nextInt(1, Map.size-1 + 1);
    }
    /**losuje int pozycji y */
    public static int getRandomPositionY() {
        return ThreadLocalRandom.current().nextInt(1, Map.size-1 + 1);
    }
}
