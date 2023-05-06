package window.board;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ball {

    // satłe
    final static protected int SIZE = 36;
    final static protected int SPECIAL_SIZE = 30;

    JLabel ball;



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


    final static protected ImageIcon[] outputColors = {EMPTY, WHITE, BLACK};


    // konstruktor (towrzy JLabel zawierający odpowienią grafikę)
    public Ball(int index, boolean output){

        ball = new JLabel();
        ball.setBackground(null);
        ball.setOpaque(true);

        if(!output){
            ball.setPreferredSize(new Dimension(Ball.SIZE, Ball.SIZE));
            ball.setIcon(Ball.colors[index]);
        }
        else{
            ball.setPreferredSize(new Dimension(Ball.SPECIAL_SIZE, Ball.SPECIAL_SIZE));
            ball.setIcon(Ball.outputColors[index]);
        }

        ball.setVisible(true);
        
    }


    // gettery
    protected ImageIcon getWhite(){
        return WHITE;
    }
    
    protected ImageIcon getBlack(){
        return BLACK;
    }

    public JLabel getBall(){
        return ball;
    }

}
