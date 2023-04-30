import window.*;
import window.board.*;;

public class Main{
    public static void main(String[] args) {
        Frame frame = new Frame();
        Board board = new Board();




        for(int i = 0; i < 11; i++){
            Row row = new Row();
            board.getBoard().add(row.getRow());
        }

        Row last = new Row();
        last.addButtons();
        board.getBoard().add(last.getRow());
        for(int i = 0; i < 4; i++){
            last.buttons[i].getButton().addActionListener(new MyActionListener(last.buttons[i]));
        }



        









        
        frame.getFrame().add(board.getBoard());
        frame.getFrame().setVisible(true);
    }
}