package source;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;






public class User {

    private String name;
    private int bestScore;
    private int score;
    private int gamesPlayed;
    private float bestTime;
    private float time;

    private FileWriter writer;
    private Scanner reader;




    // tworzenie lub wczytywanie gracza (pliku)
    public User(File userData) throws IOException {

        // gracz nie istnieje, tworzenie nowego pliku
        if(userData.length() == 0){
            this.name = userData.getPath().substring(12, userData.getPath().length()-4);
            this.bestTime = -1;
            this.bestScore = -1;
            this.gamesPlayed = 0;

            // wpisanie poczatkowych wartosci
            save(userData);
        }

        // gracz istnieje
        else{
            // przepisanie do pamieci podrecznej jego wynikow
            this.reader = new Scanner(userData);

            this.name = reader.nextLine().substring(5);
            this.bestScore = Integer.parseInt(reader.nextLine().substring(11));
            this.bestTime = Integer.parseInt(reader.nextLine().substring(10));
            this.gamesPlayed = Integer.parseInt(reader.nextLine().substring(13));

            reader.close();
        }
        // wyswietlenie danych uzytkownika
        printUserInfo();
    }



    // wypisanie statystyk
    public void printUserInfo(){
        System.out.println("name : " + this.name);
        System.out.println("best score : " + this.bestScore);
        System.out.println("best time : " + this.bestTime);
        System.out.println("games played : " + this.gamesPlayed);
    }



    // sprawdzenie poprawnosci nazwy
    public static boolean checkSpelling(String name){
        char[] array = name.toCharArray();
        for(char c : array){
            if((c < 48 || c > 57) && (c < 65 || c > 90) && (c < 97 || c > 122))
                return false;
        }
        return true;
    }



    // aktualizowanie najlepszych osiagniec
    public void updateStats(int score, long time){
        this.score = score;
        this.time = time;

        if(this.score > this.bestScore)
            this.bestScore = this.score;

        if(this.time < this.bestTime || this.bestTime < 0)
            this.bestTime = this.time;
    }



    // zaspisanie wartosci do pliku
    public void save(File userData) throws IOException{
        this.writer = new FileWriter(userData);

        this.writer.write("NAME:" + this.name + "\n");
        this.writer.write("BEST_SCORE:" + this.bestScore + "\n");
        this.writer.write("BEST_TIME:" + (int)this.bestTime + "\n");
        this.writer.write("GAMES_PLAYED:" + this.gamesPlayed);

        this.writer.close();
    }


    public void increaseGamesPlayed(){
        this.gamesPlayed++;
    }


    // getter
    public String getName() {
        return this.name;
    }

    public float getBestTime(){
        return this.bestTime;
    }

    public float getTime(){
        return this.time;
    }

    public int getBestScore(){
        return this.bestScore;
    }

    public int getScore(){
        return this.score;
    }

    public int getGamesPlayed(){
        return gamesPlayed;
    }


}