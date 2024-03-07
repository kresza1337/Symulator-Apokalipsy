package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Being {
    public final String name;
    public int x;
    public int y;

    Being(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    // move pobiera dane o aktualnym położeniu obiektu i zwraca tablice 2 elemetową z nową pozycją : pierwszy element to x a drugi to y
    protected int[] move(int x, int y)
    {
        int kierunek;

        kierunek = ThreadLocalRandom.current().nextInt(0, 4);
        if (kierunek == 0) {
            x+=1;
        }
        else if (kierunek == 1) {
            x-=1;
        }
        else if (kierunek == 2) {
            y+=1;
        }
        else if (kierunek == 3) {
            y-=1;
        }

        if (x == Map.size)x = 0;
        else if (x == -1)x = Map.size-1;
        if (y == Map.size)y = 0;
        else if (y == -1)y = Map.size-1;

        return new int[]{x, y};
    }


}
