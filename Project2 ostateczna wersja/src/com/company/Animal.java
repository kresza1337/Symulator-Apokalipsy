package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Animal extends Being{

    /**Animal dziedziczy name, hp, x, y  z Being  nie ma tu move() bo dziedziczy  z Being  */
    Animal(String name, int x, int y){super(name, x, y);
    }
    public static void movefromMAP(int x)
    {
        int direction;
        for(int i = 0; i<x; i++){
            direction = ThreadLocalRandom.current().nextInt(0, 2);
            if (direction==0) {
                Map.animals.get(i).x = Map.animals.get(i).move(Map.animals.get(i).x, Map.animals.get(i).y)[0];
            }
            else if (direction==1) {
                Map.animals.get(i).y=Map.animals.get(i).move(Map.animals.get(i).x, Map.animals.get(i).y)[1];
            }
        }


    }
}
