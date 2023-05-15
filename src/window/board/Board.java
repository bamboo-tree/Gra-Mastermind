package window.board;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

import window.Frame;



public class Board {
    
    // satłe
    final static protected int HEIGHT = 700;
    final static protected int WIDTH = 900;
    final static protected int ROWS = 12; // -2
    static protected int colors = 4;
    final private JPanel myBoard;


    // konstruktor (towrzy JPanel pod planszę gry)
    public Board(){
        myBoard = new JPanel();
        myBoard.setFocusable(true);
        myBoard.setLayout(new GridLayout(ROWS, colors));
        myBoard.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        myBoard.setBackground(Color.BLACK);
    }

    // getter
    public JPanel getBoard(){
        return myBoard;
    }


    public void killBoard(Frame frame){
        frame.getFrame().getContentPane().remove(myBoard);
        frame.getFrame().invalidate();
        frame.getFrame().validate();
        frame.getFrame().setVisible(true);
    }
}
