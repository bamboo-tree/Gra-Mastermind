import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import window.*;
import window.board.*;
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


        // 
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        User user = null;



//         *    Dodać prostą instrukcję obsługi i zasady gry
//         *    Dodać możliwość wyboru trybu (inny sposób prezentowania odpowiedzi, uproszczony lub normalny) 







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
        System.out.println("wyszlo");

        welcomeScreen.killWelcomeScreen(frame);





        




        // tworzenie kombinacji kolorów, wyświetlanie ich na samej górze
        computer.generate();
        first.addColors(computer.getGeneratedColors(), false);
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






        while(currentRow < 10 && !computer.didWon()){

            // opoznienie dla poprawnego dzialania keyListener'a
            TimeUnit.MILLISECONDS.sleep(50);

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
                    for(int i : computer.getOutput())
                        System.out.printf("%d ", i);
                    System.out.println(computer.didWon());



                    // wyświetlenie wygenerowanych kolorów (tych do zgadnięcia)
                    for(int i : computer.getGeneratedColors())
                        System.out.printf("%d ", i);
                    System.out.println();
                    

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
        
        

        
    }
}