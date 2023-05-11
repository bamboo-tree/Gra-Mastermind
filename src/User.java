import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {

    String name;
    int bestScore;
    int gamesPlayed;
    float bestTime;

    FileWriter writer;
    Scanner reader;

    // tworzenie lub wczytywanie gracza (pliku)
    public User(File userData) throws IOException {
        if(userData.length() == 0){
            System.out.println(1);
            writer = new FileWriter(userData);
            this.name = userData.getPath().substring(12, userData.getPath().length()-4);
            this.bestTime = -1;
            this.bestScore = -1;
            this.gamesPlayed = 0;

            writer.write("NAME:"+this.name+"\n");
            writer.write("BEST_SCORE:-1\n");
            writer.write("BEST_TIME:-1\n");
            writer.write("GAMES_PLAYED:0");
            writer.close();
        }
        else{
            System.out.println(2);
            reader = new Scanner(userData);
            this.name = reader.nextLine().substring(5);
            this.bestScore = Integer.parseInt(reader.nextLine().substring(11));
            this.bestTime = Integer.parseInt(reader.nextLine().substring(10));
            this.gamesPlayed = Integer.parseInt(reader.nextLine().substring(13));
            reader.close();
        }
        System.out.println(3);
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
            if((c < 48 || c > 57) && (c < 65 || c > 90) && (c < 97 || c > 122)){
                return false;
            }
        }
        return true;
    }

    // aktualizowanie najlepszych osiagniec
    public void updateStats(int score, long time){
        if(score > bestScore){
            bestScore = score;
        }
        if(time < bestTime || bestTime < 0){
            bestTime = time;
        }
    }


    public void save(File userData) throws IOException{
        writer = new FileWriter(userData);
        writer.write("NAME:" + this.name + "\n");
        writer.write("BEST_SCORE:" + this.bestScore + "\n");
        writer.write("BEST_TIME:" + (int)this.bestTime + "\n");
        writer.write("GAMES_PLAYED:" + this.gamesPlayed);
        writer.close();
    }



    // getter
    public String getName() {
        return name;
    }

}

