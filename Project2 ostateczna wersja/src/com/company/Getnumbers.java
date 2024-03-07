package com.company;

import java.util.Scanner;

public class Getnumbers {
    /**brane są na początku ilości przedmiotów i istot */
    protected static int getRadioactive()
    {
        int getR;
            for (int i = 0; i < 5; i++) {
                System.out.print("--");
            }
            System.out.println();
            System.out.println("Podaj ilosc generacji p.radioaktywnych");
            for (int i = 0; i < 5; i++) {
                System.out.print("--");
            }
            System.out.println();
            System.out.println("ILOSC: ");
            Scanner scanner = new Scanner(System.in);
             getR = scanner.nextInt();
             return getR;
    }

    protected static int getFood()
    {
        int getF;
        do {
            for (int i = 0; i < 5; i++) {
                System.out.print("--");
            }
            System.out.println();
            System.out.println("Podaj ilosc generacji jedzenia");
            for (int i = 0; i < 5; i++) {
                System.out.print("--");
            }
            System.out.println();
            System.out.println("ILOSC: ");
            Scanner scanner = new Scanner(System.in);
            getF = scanner.nextInt();
            if(getF == 0) System.out.println("ILOSC MUSI BYC WIEKSZA OD 0");
        }while(getF == 0);
        return getF;
    }

    protected static int getAnimal()
    {
        for(int i=0;i<5;i++)
        {
            System.out.print("--");
        }
        System.out.println();
        System.out.println("Podaj ilosc generacji zwierzat");
        for(int i=0;i<5;i++)
        {
            System.out.print("--");
        }
        System.out.println();
        System.out.println("ILOSC: ");
        Scanner scanner = new Scanner(System.in);
        int getA = scanner.nextInt();
        return getA;
    }

    protected static int getPeople()
    {
        for(int i=0;i<5;i++)
        {
            System.out.print("--");
        }
        System.out.println();
        System.out.println("Podaj ilosc generacji ludzi");
        for(int i=0;i<5;i++)
        {
            System.out.print("--");
        }
        System.out.println();
        System.out.println("ILOSC: ");
        Scanner scanner = new Scanner(System.in);
        int getA = scanner.nextInt();
        return getA;
    }
}
