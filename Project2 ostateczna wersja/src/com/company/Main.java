package com.company;

import java.util.Scanner;

/** Symulator Apokalipsy
 * @author Wiktor Dębek(lider)
 * @author Jakub Kryska
 */

public class Main {
    public static void main(String[] args) {

        int choice=0;
        int speed =0;
        /** START */
        Start start = new Start();
        start.Start();
        /** WYBÓR */
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        if (menu == 1) {

            start.modeinf();
            Scanner scanner2 = new Scanner(System.in);
            choice = scanner2.nextInt();
            if(choice == 1) speed = 3000;
            if(choice == 2) speed = 1500;
            if(choice == 3) speed = 2;


            /** GENEROWANIE MAPY*/
            start.sizeInf();
            Scanner scanner3 = new Scanner(System.in);
            int size=scanner3.nextInt();
            char[][] poleplanszy = new char[size][size];
            Map map = new Map(size, poleplanszy);

            int foodNumber = Getnumbers.getFood();
            int radNumber = Getnumbers.getRadioactive();
            int animalNumber = Getnumbers.getAnimal();
            int peopleNumber = Getnumbers.getPeople();

            map.draweverything(foodNumber, radNumber, animalNumber, peopleNumber);


            //pętla
            int day = 0;
            while (map.supplies.size() > 0 && (Map.humans.size()+ Map.animals.size())>0) {

                //dodaje dzień
                day += 1;

                //wyświetla który dzień
                System.out.println("    DZIEN " + day);

                //wyświetla mape
                map.drawboard(size);

                //zatrzymuje program na x sekund
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                //czyści ekran
                for (int k = 0; k < 100; k++) System.out.print("\n");


            }
            System.out.println("    DZIEN " + (day+=1));
            map.drawboard(size);
            System.out.print("\n\n");

            //wyświetla dane
            System.out.println("         Symulacja zakonczona! Jedzenie sie skonczylo lub ludnosc wyginela.");
            System.out.println(" STAN: " );
            System.out.println(" IL. LUDZI: " + Map.humans.size());
            System.out.println(" IL. ZWIERZAT: " + Map.animals.size());
            System.out.println(" IL. ZJEDZONEGO JEDZENIA:  " + (map.eatenFOOD_animals+map.eatenFOOD_humans));
            System.out.println(" IL. ZJEDZONYCH P.RADIOAKT: " + (map.eatenRADS_animals+map.eatenRADS_humans));
            System.out.println(" IL. WYGINIETYCH ZWIERZAT: " + map.deadAnimals);
            System.out.println(" IL. ZABITYCH LUDZI: " + map.deadPeople);


        }
        else
        {
            System.exit(0);
        }
    }


}



