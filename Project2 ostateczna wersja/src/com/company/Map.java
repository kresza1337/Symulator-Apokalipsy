package com.company;

import java.util.ArrayList;
import java.util.List;

public class Map {

    protected static int size;
    private char[][] board;
    Map(int size, char[][] board){
        this.size = size;
        this.board = board;
    }

    //listy ludzi i zwierząt
    public static List<People> humans = new ArrayList<People>();
    public static List<Animal> animals = new ArrayList<Animal>();
    public static List<Food> supplies = new ArrayList<Food>();
    public static List<Radioactive> rads = new ArrayList<Radioactive>();

    public int eatenFOOD_humans, eatenFOOD_animals, eatenRADS_animals, eatenRADS_humans,deadPeople, deadAnimals =0;

    private void draw()  //rysowanie planszy
    {
        for (int i = 0; i <= size; i++) // szerokosc gora
        {
            System.out.print("--");
        }
        System.out.println();

        for (int i = 0; i < size; i++) // boki wysokosc
        {
            System.out.print("|");  // lewa
            for (int s = 0; s < size; s++) {
                /** POLA PUSTE */
                if (board[s][i] == 'p') System.out.print("  "); //puste
                /** POLA RADIOAKTYWNE */
                if (board[s][i] == 'R') //radioaktywne
                {
                    System.out.print("R ");
                }
                /** POLA POKARM */
                if (board[s][i] == 'J') //Pokarm
                {
                    System.out.print("J ");
                }
                /** POLA ZWIERZĘTA */
                if (board[s][i] == 'A') //Zwierzęta
                {
                    System.out.print("A ");
                }
                /** POLA LUDZIE */
                if (board[s][i] == 'P') //Ludzie
                {
                    System.out.print("P ");
                }
            }
            System.out.println("|"); // prawa
        }

        //dokańczanie rysowania
        for (int i = 0; i <= size; i++) // szerokosc dol
        {
            System.out.print("--");
        }
        System.out.println(" ");
    }

    private void emptyboard() //czyszczenie planszy
    {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[j][i] = 'p';
            }
        }
    }

    private void supplies_elements(int humFOOD, int animFOOD, int humRADS, int animRADS, int numberDeadPeople, int numberDeadAnimals) //stan obiektów w ciagu dnia
    {
        int suma;
        suma = humFOOD+animFOOD+humRADS+animRADS;
        System.out.println("Elementy zjedzone przez: ");
        System.out.println("Zwierzeta: " + "JEDZ: " + animFOOD + " RAD: " + animRADS);
        System.out.println("Ludzi: "  + "JEDZ: " + humFOOD + " RAD: " + humRADS);
        System.out.println("Lacznie: " + suma);
        System.out.println("Ilosc wymarlych ludzi: " + numberDeadPeople + " Zwierzat: " + numberDeadAnimals);
    }

    /** tworzy obiekty i wypełnia*/
    private void fill(int foodNumber,int radNumber,int animalNumber,int peopleNumber){
        for (int i = 0; i < foodNumber; i++) {
            Food f = new Food("food"+ Integer.toString(i), Positioning.getRandomPositionX(),Positioning.getRandomPositionY());
            while (board[f.x][f.y] != 'p') {
                f.x = Positioning.getRandomPositionX();
                f.y = Positioning.getRandomPositionY();
            }
            board[f.x][f.y] = 'J';
            //dodaje obiekt do listy
            supplies.add(f);
        }

        for (int i = 0; i < radNumber; i++) {
            Radioactive r = new Radioactive("radioactive"+ Integer.toString(i), Positioning.getRandomPositionX(),Positioning.getRandomPositionY());
            while (board[r.x][r.y] != 'p') {
                r.x = Positioning.getRandomPositionX();
                r.y = Positioning.getRandomPositionY();
            }
            board[r.x][r.y] = 'R';
            //dodaje obiekt do listy
            rads.add(r);
        }

        for (int i = 0; i < animalNumber; i++) {
            Animal a = new Animal("animal" + Integer.toString(i), Positioning.getRandomPositionX(), Positioning.getRandomPositionY());
            while (board[a.x][a.y] != 'p') {
                a.x = Positioning.getRandomPositionX();
                a.y = Positioning.getRandomPositionY();
            }
            board[a.x][a.y] = 'A';
            //dodaje obiekt do listy
            animals.add(a);
        }

        for (int i = 0; i < peopleNumber; i++) {
            /**tworzy obiekt */
            People p = new People("people" + Integer.toString(i), Positioning.getRandomPositionX(), Positioning.getRandomPositionY());
            /**wpisuje na mapie w pozycji z tego obiektu zrobionego wyżej*/
            while (board[p.x][p.y] != 'p') {
                p.x = Positioning.getRandomPositionX();
                p.y = Positioning.getRandomPositionY();
            }
            board[p.x][p.y] = 'P';
            //dodaje obiekt do listy
            humans.add(p);
        }
    }

    /**generowanie planszy i obiektów*/
    public void draweverything(int foodNumber, int radNumber, int animalNumber, int peopleNumber)
    {

        /**CZYSZCZENIE*/
        emptyboard();

        /**WYPELNIANIE*/
        fill(foodNumber,radNumber,animalNumber,peopleNumber);

        /**robienie mapy*/
        draw();
    }
    /**
     * ---------------------------------------------------------- RYSUJ PLANSZE --------------------------------------------------------------------
     */

    /**rysowanie planszy wraz z relacjami miedzy stworzonymi obiektami i ich poruszaniem*/
    public void drawboard(int size)
    {

        /**CZYSZCZENIE*/
        emptyboard();

        /**PORUSZANIE SIE*/
        People.movefromMAP(humans.size());
        Animal.movefromMAP(animals.size());
        /////////////////////////////
        /** ZJADANIE */
        eating();

        ///////////////////////
        //ustawia je na planszy
        for(int i = 0; i<humans.size(); i++){
            board[humans.get(i).x][humans.get(i).y] = 'P';
        }
        for(int i = 0; i<animals.size(); i++){
            board[animals.get(i).x][animals.get(i).y] = 'A';
        }
        for(int i = 0; i<supplies.size(); i++){
            board[supplies.get(i).x][supplies.get(i).y] = 'J';
        }
        for(int i = 0; i<rads.size(); i++){
            board[rads.get(i).x][rads.get(i).y] = 'R';
        }
        /**RYSOWANIE MAPY*/
            draw();

        supplies_elements(eatenFOOD_humans, eatenFOOD_animals,eatenRADS_humans,eatenRADS_animals, deadPeople, deadAnimals);
    }



    /**zjadanie*/
    private void eating(){
        if(supplies.size() > 0 && humans.size()>0) {
            for (int h = 0; h < supplies.size(); h++) {
                for (int o = 0; o < humans.size(); o++)
                    if (supplies.get(h).x == humans.get(o).x && supplies.get(h).y == humans.get(o).y) {
                        eatenFOOD_humans++;
                        supplies.remove(h);
                        break;
                    }
            }
        }

        if(supplies.size() > 0 && animals.size()>0) {
            for (int h = 0; h < supplies.size(); h++) {
                for (int o = 0; o < animals.size(); o++)
                    if ((supplies.get(h).x == animals.get(o).x) && (supplies.get(h).y == animals.get(o).y)) {
                        eatenFOOD_animals++;
                        supplies.remove(h);
                        break;
                    }
            }
        }

        if(rads.size() > 0 && animals.size()>0) {
            for (int h = 0; h < rads.size(); h++) {
                for (int o = 0; o < animals.size(); o++)
                    if ((rads.get(h).x == animals.get(o).x) && (rads.get(h).y == animals.get(o).y)) {
                        eatenRADS_animals++;
                        deadAnimals++;
                        rads.remove(h);
                        animals.remove(o);
                        break;

                    }
            }
        }

        if(rads.size() > 0 && humans.size()>0) {
            for (int h = 0; h < rads.size(); h++) {
                for (int o = 0; o < humans.size(); o++)
                    if (rads.get(h).x == humans.get(o).x && rads.get(h).y == humans.get(o).y) {
                        eatenRADS_humans++;
                        deadPeople++;
                        rads.remove(h);
                        humans.remove(o);
                        break;
                    }
            }
        }
    }


}




