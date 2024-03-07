package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class People extends Being {

    /**People dziedziczy name, x, y  z Being  nie ma tu move() bo dziedziczy  z Being */
    People(String name, int x, int y){
        super(name, x, y);
    }

    public static void movefromMAP(int x)
    {
        int direction;
        for (int i = 0; i<x; i++){
            direction = ThreadLocalRandom.current().nextInt(0, 2);

            if (direction==0){
                Map.humans.get(i).x=Map.humans.get(i).move(Map.humans.get(i).x, Map.humans.get(i).y)[0];
            }
            else if (direction==1) {
                Map.humans.get(i).y=Map.humans.get(i).move(Map.humans.get(i).x, Map.humans.get(i).y)[1];
            }

        }
    }


}
