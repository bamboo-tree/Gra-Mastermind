package source.window.main_board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

import source.window.Frame;






public class Output {

    // stałe
    final protected int WIDTH = 300;
    final private JPanel myOutput;



    
    // konstruktor (tworzy JPanel pod wyświetlanie odpowiedzi dla gracza)
    public Output(){
        this.myOutput = new JPanel();
        this.myOutput.setFocusable(false);
        this.myOutput.setLayout(new GridLayout(Board.ROWS, Board.COLORS));
        this.myOutput.setPreferredSize(new Dimension(WIDTH, Board.HEIGHT));
        this.myOutput.setBackground(Color.BLACK);
    }


    // niszczenie JPanel'u
    public void killOutput(Frame frame){
        frame.getFrame().getContentPane().remove(this.myOutput);
        frame.getFrame().invalidate();
        frame.getFrame().validate();
        frame.getFrame().setVisible(true);
    }


    // getter
    public JPanel getOutput(){
        return this.myOutput;
    }

}