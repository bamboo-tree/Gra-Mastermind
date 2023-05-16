package source.window.main_board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

import source.window.Frame;






public class Board {
    
    // satłe
    final static protected int HEIGHT = 700;
    final static protected int WIDTH = 900;
    final static protected int ROWS = 12; // okresla ilosc podejsc do zgadniecia -2
    final static protected int COLORS = 4;

    private JPanel myBoard;




    // konstruktor (towrzy JPanel pod planszę gry)
    public Board(){
        this.myBoard = new JPanel();
        this.myBoard.setFocusable(true);
        this.myBoard.setLayout(new GridLayout(ROWS, COLORS));
        this.myBoard.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.myBoard.setBackground(Color.BLACK);
    }


    // getter
    public JPanel getBoard(){
        return this.myBoard;
    }


    // niszczenie JPanel'u
    public void killBoard(Frame frame){
        frame.getFrame().getContentPane().remove(this.myBoard);
        frame.getFrame().invalidate();
        frame.getFrame().validate();
        frame.getFrame().setVisible(true);
    }
}