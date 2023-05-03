import java.util.concurrent.TimeUnit;

import window.*;
import window.board.*;;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        Frame frame = new Frame();
        Board board = new Board();
        MyKeyListener keyListener = new MyKeyListener();

        Row[] rowArray = new Row[11];
        int[] submittedColors = new int[4];
        int currentRow = 0;



        for(int i = 10; i >= 0; i--){
            rowArray[i] = new Row();
            board.getBoard().add(rowArray[i].getRow());
        }

        Row last = new Row();
        last.addButtons();
        board.getBoard().add(last.getRow());
        board.getBoard().addKeyListener(keyListener);
        for(int i = 0; i < 4; i++){
            last.buttons[i].getButton().addActionListener(new MyActionListener(last.buttons[i]));
        }


        frame.getFrame().add(board.getBoard());
        frame.getFrame().setVisible(true);

        board.getBoard().requestFocus(true);


        while(currentRow < 10){
            TimeUnit.MILLISECONDS.sleep(100);
            if(keyListener.submitted){
                
                for(int i = 0; i < 4; i++){
                    submittedColors[i] = last.getButton(i);
                }
                for(int i : submittedColors)
                    System.out.printf("%d ", i);
                System.out.println(currentRow);

                
                rowArray[currentRow].addColors(submittedColors);
                frame.getFrame().add(board.getBoard());
                frame.getFrame().setVisible(true);
                board.getBoard().requestFocus(true);

                currentRow++;
                keyListener.submitted = false;
            }
        }
        









        
        
    }
}