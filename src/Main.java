import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



import window.*;
import window.board.*;
import window.guide.Description;
import window.welcome_screen.WelcomeScreen;;

public class Main{
    public static void main(String[] args) throws InterruptedException, IOException {

        // tworzenie obiektów
        Frame frame = new Frame();
        Board board = new Board();
        Output output = new Output();
        Computer computer = new Computer();
        MyKeyListener keyListener = new MyKeyListener();


        // obiekty i tablice pomocnicze dla board
        Row[] rowArray = new Row[10];
        Row last = new Row(false, computer.DARK, computer.BLACK);
        Row first = new Row(false, computer.DARK, computer.BLACK);
        int[] submittedColors = new int[4];
        int currentRow = 0;
        Row[] outputRow = new Row[10];


        // inne
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        MyActionListener easy = new MyActionListener(null);
        MyActionListener normal = new MyActionListener(null);
        Description description = new Description();
        User user = null;
        int gamemode = -1;
        long time = 0;
        int score = 0;







        // sekacja 1
        // okno powitalne
        // pobieranie nazwy użytkownika

        welcomeScreen.usernameInput.addKeyListener(keyListener);
        frame.getFrame().add(welcomeScreen.getWelcomeScreen(), BorderLayout.CENTER);
        frame.getFrame().setVisible(true);
        welcomeScreen.usernameInput.requestFocus(true);

        while(true){
            TimeUnit.MILLISECONDS.sleep(computer.DELAY);

            if(keyListener.code == 10){
                if(!User.checkSpelling(welcomeScreen.usernameInput.getText())){
                    welcomeScreen.userInfo.setText("Username is incorrect, try something else");
                    welcomeScreen.userInfo.setBackground(welcomeScreen.RED);
                }
                else{
                    String path = "./all_users/" + welcomeScreen.usernameInput.getText() + ".txt";

                    // tworzenie nowego uzytkownika, lub wczytywanie istniejacego

                    if(new File(path).isFile()){
                        File file = new File(path);
                        file.createNewFile();
                        user = new User(file);
                        welcomeScreen.userInfo.setText("Welcome back " + welcomeScreen.usernameInput.getText() + "!");
                    }
                    else{
                        File file = new File(path);
                        file.createNewFile();
                        user = new User(file);
                        welcomeScreen.userInfo.setText("User " + user.getName() + " has been successfully created.");
                    }

                    welcomeScreen.userInfo.setBackground(welcomeScreen.GREEN);
                    TimeUnit.MILLISECONDS.sleep(500);
                    break;
                }
            }
        }
        welcomeScreen.killWelcomeScreen(frame);



        // sekcja 2
        // krotki opis
        // wybor trybu gry

        frame.getFrame().add(description.getDescription(), BorderLayout.CENTER);
        frame.getFrame().setVisible(true);

        description.getEasyButton().addActionListener(easy);
        description.getNormalButton().addActionListener(normal);

        while(gamemode == -1){
            TimeUnit.MILLISECONDS.sleep(100);
            if(easy.click){
                gamemode = 0;
            }
            else if(normal.click){
                gamemode = 1;
            }
        }
        description.killDescription(frame);



        // sekcja 3
        // gra

        while(gamemode != -1){

            // tworzenie kombinacji kolorow
            computer.generate();

            // pusty rzad na gorze
            board.getBoard().add(first.getRow());


            // dodanie pustego rzedu na gorze output
            output.getOutput().add(new Row(true, computer.DARK, computer.BLACK).getRow());


            // tworzenie rzędów w których będą kolejne odpowiedzi gracza
            for(int i = 9; i >= 0; i--){
                rowArray[i] = new Row(false, computer.GRAY, computer.BLACK);
                board.getBoard().add(rowArray[i].getRow());

                outputRow[i] = new Row(true, computer.LIGHT, computer.BLACK);
                output.getOutput().add(outputRow[i].getRow());
            }

            // dodanie pustego rzedu na dole output
            output.getOutput().add(new Row(true, computer.DARK, computer.BLACK).getRow());


            // dodanie przycisków do wyboru kolorów (na samym dole)
            last.addButtons();
            board.getBoard().add(last.getRow());
            board.getBoard().addKeyListener(keyListener);
            for(int i = 0; i < 4; i++){
                last.buttons[i].getButton().addActionListener(new MyActionListener(last.buttons[i]));
            }



            // dodanie board do ekranu
            frame.getFrame().add(board.getBoard(), BorderLayout.CENTER);

            // dodanie output do ekranu
            frame.getFrame().add(output.getOutput(), BorderLayout.EAST);
            frame.getFrame().setVisible(true);

            // umożliwa poprawne zczytywanie keyListner'a
            board.getBoard().requestFocus(true);

            // usun
            first.addColors(computer.getGeneratedColors(), false);
            frame.getFrame().setVisible(true);


            // sekcja 4
            // rozgrywka

            time = System.currentTimeMillis();
            while(currentRow < 10 && !computer.didWon()){

                // opoznienie dla poprawnego dzialania keyListener'a
                TimeUnit.MILLISECONDS.sleep(100);


                // sprawdzanie czy odpowiedź została zatwierdzona
                if(keyListener.submitted){ 
                    
                    // zapisanie indeksów kolorów w tablicy
                    for(int i = 0; i < 4; i++)
                        submittedColors[i] = last.getButton(i);
                    

                    // wyświetlenie tablicy z odpowiedzią
                    for(int i : submittedColors)
                        System.out.printf("%d ", i);
                    System.out.println();




                    // przesałanie odpowiedzi w celu podjęcia dalszych kroków
                    computer.setInput(submittedColors);


                    // sprawdza czy kolory się nie powtarzają, jeżeli tak trzeba poprawić swoją odpowiedź
                    if(!computer.colorsRepeat()){

                        // porównanie odpowiedzi ze wzorcem
                        computer.check();




                        // wyświetlenie odpowiedzi

                        // tryb normalny
                        if(gamemode == 1){
                            computer.sort();
                        }
                        
                        for(int i : computer.getOutput())
                            System.out.printf("%d ", i);
                        System.out.println(computer.didWon());

                        

                        // wyświetlenie odpowiedzi po prawej stronie
                        outputRow[currentRow].addColors(computer.getOutput(), true);
                        frame.getFrame().add(output.getOutput(), BorderLayout.EAST);
                        


                        // dodanie do wiersza zatwierdzonych kolorów, oraz ich wyświetlenie
                        rowArray[currentRow].addColors(submittedColors, false);
                        frame.getFrame().add(board.getBoard(), BorderLayout.CENTER);
                        board.getBoard().requestFocus(true);

                        frame.getFrame().setVisible(true);

                        // aktualizacja indeksu wiersza
                        currentRow++;
                    }


                    // reset keyListener'a
                    keyListener.submitted = false;
                }
            }
            // wyświetlenie wygenerowanych kolorów (tych do zgadnięcia)
            for(int i : computer.getGeneratedColors())
                System.out.printf("%d ", i);
            System.out.println();

            first.addColors(computer.getGeneratedColors(), false);
            frame.getFrame().setVisible(true);

            // statystyki gracza
            user.gamesPlayed++;
            score = 10 - currentRow;
            time = System.currentTimeMillis() - time;
            System.out.println(time);

            user.updateStats(score, (int)time);
            String path = "./all_users/" + user.name + ".txt";
            File file = new File(path);
            user.save(file);

            gamemode = -1;
        }
    }
}