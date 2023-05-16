package source;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import source.window.Frame;
import source.window.MyActionListener;
import source.window.MyKeyListener;
import source.window.main_board.Board;
import source.window.main_board.Output;
import source.window.main_board.Row;
import source.window.welcome_guide_end_screens.Description;
import source.window.welcome_guide_end_screens.EndScreen;
import source.window.welcome_guide_end_screens.WelcomeScreen;






public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        
        // obiekty do JFrame
        Frame frame = new Frame();
        WelcomeScreen welcomeScreen = new WelcomeScreen();

        User user;
        MyKeyListener myKeyListener = new MyKeyListener();


        // zmienne pomocnicze
        boolean game = true;
        int gamemode = -1;




            /*

            ETAP 1:
            - okno powitalne
            - pobieranie nazwy uzytkownika
            - tworzenie lub wczytywanie danych uzytkownika z pliku
         
            */


        // tworzenie folderu pod graczy
        File theDir = new File("./all_users");
        if (!theDir.exists()){
            theDir.mkdirs();
        }
        


        // dodanie okna powitalnego do Frame'a
        welcomeScreen.getTextField().addKeyListener(myKeyListener);
        frame.getFrame().add(welcomeScreen.getWelcomeScreen(), BorderLayout.CENTER);
        frame.getFrame().setVisible(true);
        welcomeScreen.getTextField().requestFocus(true);


        // tworzenie uztkownika
        while(true){
           TimeUnit.MILLISECONDS.sleep(100);

           // sprawdzanie czy nazwa uzytkownika jest zgodna ze standardem
           if(myKeyListener.getCode() == 10 && welcomeScreen.getTextField().getText().length() > 0){

               // niezgodna
               if(!User.checkSpelling(welcomeScreen.getTextField().getText())){
                   welcomeScreen.getMyJLabel().setText("Username is incorrect, try something else");
                   welcomeScreen.getMyJLabel().setBackground(Computer.RED);
               }


               // zgodna, tworzenie nowego uzytkownika lub wczytywanie istniejacego
               else{
                   String path = "./all_users/" + welcomeScreen.getTextField().getText() + ".txt";

                   // istnieje
                   if(new File(path).isFile()){
                       File file = new File(path);
                       file.createNewFile();
                       user = new User(file);
                       welcomeScreen.getMyJLabel().setText("Welcome back " + welcomeScreen.getTextField().getText() + "!");
                   }

                   // nie istnieje
                   else{
                       File file = new File(path);
                       file.createNewFile();
                       user = new User(file);
                       welcomeScreen.getMyJLabel().setText("User " + user.getName() + " has been successfully created.");
                   }

                   // zmiana koloru na zielony
                   welcomeScreen.getMyJLabel().setBackground(Computer.GREEN);
                   TimeUnit.MILLISECONDS.sleep(1000);
                   break;
               }
           }
        }
        // niszczenie okna powitalnego, wiecej sie juz nie pokaze
        welcomeScreen.killWelcomeScreen(frame);






        // petla gry
        while(game){

           /*

           ETAP 2:
           - krotki opis oraz zasady sprawdzania
           - wybor trudnosci gry:
               * latwy - pozycja odpowiedzi jest taka sama jak koloru ktorego dotyczy
               * normalny - kolejnosc odpowiedzi jest zawsze taka sama i nie wiadomo do ktorego koloru sie odnosi

           */


           // obiekty potrzebne do opisu gry
           Description description = new Description();
           MyActionListener easy = new MyActionListener();
           MyActionListener normal = new MyActionListener();

           Computer computer = new Computer();


           // dodanie opisu do Frame'a
           frame.getFrame().add(description.getDescription(), BorderLayout.CENTER);
           frame.getFrame().setVisible(true);

           // dodanie ActionListener'a do przyciskow
           description.getEasyButton().addActionListener(easy);
           description.getNormalButton().addActionListener(normal);


           // wybor trudnosci gry
           while(gamemode < 0){
               TimeUnit.MILLISECONDS.sleep(computer.getDELAY());

               if(easy.getClick())
                   gamemode = 0;
               else if(normal.getClick())
                   gamemode = 1;
           }

           // zniszczenie opisu gry
           description.killDescription(frame);




            /*
           
            ETAP 3:
            - przygotowanie do gry

            */



            // obiekty i zmienne do utworzenia planszy
            Board board = new Board();
            Output output = new Output();

            Row[] rowArray = new Row[10];
            Row[] outputRow = new Row[10];
            Row last = new Row(false, Computer.DARK, Computer.BLACK);
            Row first = new Row(false, Computer.DARK, Computer.BLACK);

            int[] submittedColors = new int[4];
            int currentRow = 0;




            // tworzenie kombinacji kolorow do odgadniecia
            computer.generate();


            // pusty rzad na gorze
            board.getBoard().add(first.getRow());
            output.getOutput().add(new Row(true, Computer.DARK, Computer.BLACK).getRow());

            // kolejne rzedy na odpowiedzi gracza i wyniki
            for(int i = 9; i >= 0; i--){
                rowArray[i] = new Row(false, Computer.GRAY, Computer.BLACK);
                board.getBoard().add(rowArray[i].getRow());

                outputRow[i] = new Row(true, Computer.LIGHT, Computer.BLACK);
                output.getOutput().add(outputRow[i].getRow());
            }

            // pusty rzad na dole odutput
            output.getOutput().add(new Row(true, Computer.DARK, Computer.BLACK).getRow());


            // dodanie przycisków do wyboru kolorów
            last.addButtons();
            board.getBoard().add(last.getRow());
            board.getBoard().addKeyListener(myKeyListener);
            for(int i = 0; i < 4; i++){
                last.buttons[i].getButton().addActionListener(new MyActionListener(last.buttons[i]));
            }


            // dodanie board i output do ekranu
            frame.getFrame().add(board.getBoard(), BorderLayout.CENTER);
            frame.getFrame().add(output.getOutput(), BorderLayout.EAST);
            frame.getFrame().setVisible(true);

            // umożliwa poprawne zczytywanie keyListner'a
            board.getBoard().requestFocus(true);


            // god mode
            if(user.getName().equals("GODMODE321")){
                first.addColors(computer.getGeneratedColors(), false);
                frame.getFrame().setVisible(true);
            }




            /*
            
            ETAP 4:
            - rozgrywka

            */


            // dane do statystyk gracza
            long time = System.currentTimeMillis();
            int score;


            // petla gry
            while(currentRow < 10 && !computer.didWon()){

                TimeUnit.MILLISECONDS.sleep(computer.getDELAY());

                // sprawdzanie czy odpowiedz zostala zatwierdzona
                if(myKeyListener.getSubmitted()){

                    // zapisanie odpowiedzi
                    for(int i = 0; i < 4; i++)
                        submittedColors[i] = last.getButton(i);
                    

                    // przesałanie odpowiedzi w celu podjęcia dalszych kroków
                    computer.setInput(submittedColors);


                    // jezeli kolory sie nie powtarzaja przechodzi dalej
                    if(!computer.colorsRepeat()){
                        
                        // porownanie odpowiedzi ze wzorcem
                        computer.check();

                        // jezeli trudnosc jest normalna posrtuj odpowiedz
                        if(gamemode == 1)
                            computer.sort();
                        
                        // wyswietlenie wyniku
                        outputRow[currentRow].addColors(computer.getOutput(), true);
                        frame.getFrame().add(output.getOutput(), BorderLayout.EAST);


                        // dodanie kolorow wybranych przez gracza
                        rowArray[currentRow].addColors(submittedColors, false);
                        frame.getFrame().add(board.getBoard(), BorderLayout.CENTER);
                        board.getBoard().requestFocus(true);

                        frame.getFrame().setVisible(true);

                        // aktualizacja indeksu wiersza
                        currentRow++;
                    }

                    // reset keyListener'a
                    myKeyListener.setSubmitted(false);
                }
            }

            // gra sie skonczyla
            gamemode = -1;

            // pokazanie wyniku
            if(!user.getName().equals("GODMODE321")){
                first.addColors(computer.getGeneratedColors(), false);
                frame.getFrame().setVisible(true);
            }

            // opoznienie, zeby zobaczyc wynik
            TimeUnit.MILLISECONDS.sleep(1000);




            /*
            
            ETAP 5:
            - aktualizacja danych uzytkownika
            - przygotowanie i wyswietlenie ekranu koncowego
            - co dalej

            */
            



            // obiekty do ekranu koncowego
            EndScreen endScreen = new EndScreen();
            MyActionListener exit = new MyActionListener();
            MyActionListener again = new MyActionListener();

            // dodanie ActionListener'a do przyciskow
            endScreen.getEndGameButton().getButton().addActionListener(exit);
            endScreen.getPlayAgainButton().getButton().addActionListener(again);



            // statystyki gracza
            user.increaseGamesPlayed();
            score = 10 - currentRow;
            time = System.currentTimeMillis() - time;

            // aktualizacja statystyk
            user.updateStats(score, (int)time);
            String path = "./all_users/" + user.getName() + ".txt";
            File file = new File(path);
            user.save(file);


            // niszczenie planszy
            board.killBoard(frame);
            output.killOutput(frame);


            // zaktualizowanie pol tekstowych
            endScreen.createText(user);
            endScreen.setResultText(currentRow < 10);

            endScreen.getResult().setText(endScreen.getResultText());
            endScreen.getStats().setText(endScreen.getStatsText());
            //endScreen.getStats().setVisible(true);


            // dodanie ekranu kocowego do Frame'a
            frame.getFrame().add(endScreen.getEndScreen(), BorderLayout.CENTER);
            frame.getFrame().setVisible(true);


            // kolejna lub koniec gry
            while(true){
                TimeUnit.MILLISECONDS.sleep(computer.getDELAY());
                if(exit.getClick()){
                    System.out.println("EXIT");
                    game = false;
                    System.exit(0);
                }
                else if(again.getClick()){
                    System.out.println("PLAY");
                    game = true;
                    endScreen.killEndScreen(frame);
                    break;
                }
            }
        }
    }
}
