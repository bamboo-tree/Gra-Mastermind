package source;

import java.awt.Color;
import java.util.Random;






public class Computer {


    // kolory
    final static protected Color WHITE = new Color(0xF4F7F5);
    final static protected Color LIGHT = new Color(0xA7A2A9);
    final static protected Color GRAY = new Color(0x575A5E);
    final static protected Color BLACK = new Color(0x08090A);
    final static protected Color DARK = new Color(0x222823);
    final static protected Color RED = new Color(0xD00000);
    final static protected Color GREEN = new Color(0x37FF8B);


    // zmienne pomocnicze
    private int[] generatedColors = new int[4];
    private int[] output = {-1, -1, -1, -1};
    private int[] input = {-1, -1, -1, -1};
    private final int DELAY = 50;




    // tworzenie losowych kolorów do zgadnięcia
    public void generate(){
        Random random = new Random();
        int[] temp = new int[8];
        int rnd;
        int mem;

        // stworzenie tablicy ze wszystkimi indeksami
        for(int i = 0; i < 8; i++){
            temp[i] = i;
        }

        // mieszanie tablicy
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 8; j++){
                rnd = random.nextInt(8);
                mem = temp[j];
                temp[j] = temp[rnd];
                temp[rnd] = mem;
            }
        }

        // zapisanie pierwszych 4 indeksów
        for(int i = 0; i < 4; i++){
            generatedColors[i] = temp[i];
        }
    }


    // sortowanie bombelkowe :)
    public void sort(){
        for(int i = 0; i < 4; i++){
            for(int j = i; j < 4; j++){
                if(output[i] < output[j]){
                    int temp = output[i];
                    output[i] = output[j];
                    output[j] = temp;
                }
            }
        }
    }


    // sprawdza poprawność przesłanej odpowiedzi: 0 - nie ma, 1 - w zlym miejscu, 2 - na dobrym miejscu
    public void check(){
        // tworzenie tablicy, przechowującej inforamcję, czy kolor zostal już sprawdzony
        boolean[] ignore = new boolean[8];
        for(int i = 0; i < 8; i++)
            ignore[i] = false;
        output = new int[4];

        // sprawdzanie popraności
        for(int i = 0; i < 4; i++){
            output[i] = 0;
            for(int j = 0; j < 4; j++){
                if(input[i] == generatedColors[j] && !ignore[input[i]]){
                    ignore[input[i]] = true;
                    if(i == j)
                        output[i] = 2;
                    else
                        output[i] = 1;
                    break;
                }
            }
        }
    }


    // sprawdzanie, czy wzorzec został odgadnięty
    public boolean didWon(){
        for(int i : output){
            if(i != 2){
                return false;
            }
        }
        return true;
    }


    // sprawdza, czy kolory się powtarzają (nie mogą)
    public boolean colorsRepeat(){
        for(int i = 0; i < 4; i++){
            for(int j = i+1; j < 4; j++){
                if(input[i] == input[j]){
                    System.out.println("kolory nie moga sie powtarzac");
                    return true;
                }
            }
        }
        return false;
    }



    // gettery
    public int[] getGeneratedColors(){
        return generatedColors;
    }

    public int[] getOutput(){
        return output;
    }

    public int getDELAY(){
        return DELAY;
    }

    // setter
    public void setInput(int[] input){
        this.input = input;
    }
}