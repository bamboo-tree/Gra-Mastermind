package window.board;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Ball {

    final static protected int SIZE = 36;
    final static protected int SPECIAL_SIZE = 20;


    final static private ImageIcon BLACK = new ImageIcon(new ImageIcon("./img/black.png").getImage().getScaledInstance(SPECIAL_SIZE, SPECIAL_SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon WHITE = new ImageIcon(new ImageIcon("./img/white.png").getImage().getScaledInstance(SPECIAL_SIZE, SPECIAL_SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon RED = new ImageIcon(new ImageIcon("./img/red.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon ORANGE = new ImageIcon(new ImageIcon("./img/orange.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon YELLOW = new ImageIcon(new ImageIcon("./img/yellow.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon GREEN = new ImageIcon(new ImageIcon("./img/green.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon CYAN = new ImageIcon(new ImageIcon("./img/cyan.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon BLUE = new ImageIcon(new ImageIcon("./img/blue.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon INDIGO = new ImageIcon(new ImageIcon("./img/indigo.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    final static private ImageIcon pink = new ImageIcon(new ImageIcon("./img/pink.png").getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
    
    final static protected ImageIcon[] colors = {RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, INDIGO, pink};


    protected ImageIcon getWhite(){
        return WHITE;
    }
    protected ImageIcon getBlack(){
        return BLACK;
    }

}
