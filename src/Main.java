import java.util.concurrent.TimeUnit;

import window.*;
import window.board.*;;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        Frame frame = new Frame();
        Board board = new Board();
        Computer computer = new Computer();
        MyKeyListener keyListener = new MyKeyListener();

        Row[] rowArray = new Row[10];
        Row last = new Row();
        Row first = new Row();
        int[] submittedColors = new int[4];
        int currentRow = 0;

        
        computer.generate();
        first.addColors(computer.getGeneratedColors());
        board.getBoard().add(first.getRow());




        for(int i = 9; i >= 0; i--){
            rowArray[i] = new Row();
            board.getBoard().add(rowArray[i].getRow());
        }

        
        last.addButtons();
        board.getBoard().add(last.getRow());
        board.getBoard().addKeyListener(keyListener);
        for(int i = 0; i < 4; i++){
            last.buttons[i].getButton().addActionListener(new MyActionListener(last.buttons[i]));
        }

        frame.getFrame().add(board.getBoard());
        frame.getFrame().setVisible(true);
        board.getBoard().requestFocus(true);





        while(currentRow < 10 && !computer.didWon()){
            TimeUnit.MILLISECONDS.sleep(100);
            if(keyListener.submitted){
                
                for(int i = 0; i < 4; i++)
                    submittedColors[i] = last.getButton(i);
                
                for(int i : submittedColors)
                    System.out.printf("%d ", i);
                System.out.println();


                computer.setInput(submittedColors);
                if(!computer.colorsRepeat()){


                    computer.check();
                    for(int i : computer.getOutput())
                        System.out.printf("%d ", i);
                    System.out.println(computer.didWon());



                    for(int i : computer.getGeneratedColors())
                        System.out.printf("%d ", i);
                    System.out.println();
                    

                
                    rowArray[currentRow].addColors(submittedColors);
                    frame.getFrame().add(board.getBoard());
                    frame.getFrame().setVisible(true);
                    board.getBoard().requestFocus(true);


                    currentRow++;
                }






                keyListener.submitted = false;
            }
        }
        

        System.out.println("WYGRAŁ");







        
        
    }
}