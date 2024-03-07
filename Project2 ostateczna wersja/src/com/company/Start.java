package com.company;

public class Start {

    protected void Start() {
        for (int i = 0; i < 10; i++) {
            System.out.print("--");
        }
        System.out.println();
        System.out.println("Symulator Apokalipsy");
        System.out.println("AUTORZY:");
        System.out.println("Wiktor Debek");
        System.out.println("Jakub Kryska");
        for (int i = 0; i < 10; i++) {
            System.out.print("--");
        }
        System.out.println();
        System.out.println("KLIKNIJ: ");
        System.out.println("1 - ABY ROZPOCZAC SYMULACJE");
        System.out.println("INNY KLAWISZ - ABY WYJSC");
        for (int i = 0; i < 10; i++) {
            System.out.print("--");
        }
        System.out.println();
        System.out.print("Wybieram: ");
    }


    protected void modeinf()
    {
        System.out.println("Wybierz predkosc symulacji: ");
        System.out.println("1 - Wolna: ");
        System.out.println("2 - Standardowa: ");
        System.out.println("3 - Szybka: ");
    }

    protected void sizeInf()
    {
        System.out.println("Wybierz rozmiar mapy: ");
    }


}
