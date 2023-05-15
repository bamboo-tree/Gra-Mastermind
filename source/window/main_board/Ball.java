package source.window.main_board;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;






public class Ball {

    // satłe
    final static protected int SIZE = 36;
    final static protected int SPECIAL_SIZE = 30;


    private JLabel ball;




    // grafiki kolorów
    final static private ImageIcon EMPTY = new ImageIcon(new ImageIcon("./img/empty.png").getImage().getScaledInstance(SPECIAL_SIZE, SPECIAL_SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon BLACK = new ImageIcon(new ImageIcon("./img/black.png").getImage().getScaledInstance(SPECIAL_SIZE, SPECIAL_SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon WHITE = new ImageIcon(new ImageIcon("./img/white.png").getImage().getScaledInstance(SPECIAL_SIZE, SPECIAL_SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon RED = new ImageIcon(new ImageIcon("./img/red.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon ORANGE = new ImageIcon(new ImageIcon("./img/orange.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon YELLOW = new ImageIcon(new ImageIcon("./img/yellow.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon GREEN = new ImageIcon(new ImageIcon("./img/green.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon BLUE = new ImageIcon(new ImageIcon("./img/blue.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon INDIGO = new ImageIcon(new ImageIcon("./img/indigo.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon PURPLE = new ImageIcon(new ImageIcon("./img/purple.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon PINK = new ImageIcon(new ImageIcon("./img/pink.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    

    // tablica z kolorami do wyboru
    final static protected ImageIcon[] colors = {RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, PURPLE, PINK};


    // tablica z kolorami do zwracania wyniku
    final static protected ImageIcon[] outputColors = {EMPTY, WHITE, BLACK};



    // konstruktor (towrzy JLabel zawierający odpowienią grafikę)
    public Ball(int index, boolean output){

        this.ball = new JLabel();
        this.ball.setBackground(null);
        this.ball.setOpaque(true);

        // sprawdza czy nie jest pobierany kolor do wyniku
        if(!output){
            this.ball.setPreferredSize(new Dimension(SIZE, SIZE));
            this.ball.setIcon(colors[index]);
        }
        else{
            this.ball.setPreferredSize(new Dimension(SPECIAL_SIZE, SPECIAL_SIZE));
            this.ball.setIcon(outputColors[index]);
        }

        this.ball.setVisible(true);
    }



    // getter
    public JLabel getBall(){
        return this.ball;
    }
}