package source.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;






public class Frame {
    
    // stałe
    final private int WIDTH = 900;
    final private int HEIGHT = 700;
    final private JFrame myFrame;




    // konstruktor (tworzy JFrame)
    public Frame(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        this.myFrame = new JFrame();
        this.myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.myFrame.setLayout(new BorderLayout());
        this.myFrame.setSize(WIDTH, HEIGHT);
        this.myFrame.setVisible(true);
        this.myFrame.setLocation(dimension.width/2 - WIDTH/2, dimension.height/2 - HEIGHT/2);
        this.myFrame.setVisible(true);
        this.myFrame.setResizable(false);
        this.myFrame.setTitle("MASTERMIND");
        this.myFrame.setIconImage(new ImageIcon("./img/icon.png").getImage());
    }

    //getter
    public JFrame getFrame(){
        return this.myFrame;
    }

}