package window.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class Output {


    // stałe
    final static protected int WIDTH = 200;
    final static protected int HEIGHT = 700;
    final static protected int ROWS = 12; // -2
    final private JPanel myOutput;


    // konstruktor (tworzy JPanel pod wyświetlanie odpowiedzi dla gracza)
    public Output(){
        myOutput = new JPanel();
        myOutput.setLayout(new GridLayout(ROWS, 4));
        myOutput.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        myOutput.setBackground(Color.BLUE);
    }


    // getter
    public JPanel getOutput(){
        return myOutput;
    }

}
