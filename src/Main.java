import java.awt.BorderLayout;
import java.util.concurrent.TimeUnit;

import window.*;
import window.board.*;;

public class Main{
    public static void main(String[] args) throws InterruptedException {

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

        //
        Row[] outputRow = new Row[10];


        




//         *    Dodać tworzenie gracza
//         *    Dodać prostą instrukcję obsługi i zasady gry
//         *    Dodać możliwość wyboru trybu (inny sposób prezentowania odpowiedzi, uproszczony lub normalny) 














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