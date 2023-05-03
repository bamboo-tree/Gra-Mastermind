package window.board;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;



public class Board {
    
    final static protected int WIDTH = 400;
    final static protected int HEIGHT = 700;
    final static protected int ROWS = 12; // -2
    final private JPanel myBoard;

    Row hidden;
    Row player;
    Row button;


    public Board(){
        myBoard = new JPanel();
        myBoard.setFocusable(true);
        myBoard.setLayout(new GridLayout(ROWS, 4));
        myBoard.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        myBoard.setBackground(Color.BLUE);
    }

    

    public JPanel getBoard(){
        return myBoard;
    }
}
