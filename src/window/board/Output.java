package window.board;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class Output {


    // stałe
    final static protected int WIDTH = 300;
    final private JPanel myOutput;


    // konstruktor (tworzy JPanel pod wyświetlanie odpowiedzi dla gracza)
    public Output(){
        myOutput = new JPanel();
        myOutput.setFocusable(false);
        myOutput.setLayout(new GridLayout(Board.ROWS, Board.colors));
        myOutput.setPreferredSize(new Dimension(WIDTH, Board.HEIGHT));
        myOutput.setBackground(Color.BLACK);
    }


    // getter
    public JPanel getOutput(){
        return myOutput;
    }

}
