package window;


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


    // konstruktor (tworzy JFrame; okno i nadaje mu właściwości)
    public Frame(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setLayout(new BorderLayout());
        myFrame.setSize(WIDTH, HEIGHT);
        myFrame.setVisible(true);
        myFrame.setLocation(dimension.width/2 - WIDTH/2, dimension.height/2 - HEIGHT/2);
        myFrame.setVisible(true);
        myFrame.setResizable(false);
        myFrame.setTitle("MASTERMIND");
        myFrame.setIconImage(new ImageIcon("./img/icon.png").getImage());
    }

    //getter
    public JFrame getFrame(){
        return myFrame;
    }
}
