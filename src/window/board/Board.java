package window.board;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;



public class Board {
    
    // satłe
    final static protected int WIDTH = 400;
    final static protected int HEIGHT = 700;
    final static protected int ROWS = 12; // -2
    final private JPanel myBoard;


    // konstruktor (towrzy JPanel pod planszę gry)
    public Board(){
        myBoard = new JPanel();
        myBoard.setFocusable(true);
        myBoard.setLayout(new GridLayout(ROWS, 4));
        myBoard.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        myBoard.setBackground(Color.BLUE);
    }

    // getter
    public JPanel getBoard(){
        return myBoard;
    }
}
