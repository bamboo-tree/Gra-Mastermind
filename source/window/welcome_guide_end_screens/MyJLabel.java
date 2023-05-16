package source.window.welcome_guide_end_screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class MyJLabel {

    // stale
    final static protected int WIDTH = 900;
    final static protected int HEIGHT = 700;

    // zdefinowane kolory
    final static protected Color RED = new Color(0xD00000);
    final static protected Color GREEN = new Color(0x37FF8B);
    final static protected Color BLUE = new Color(0x00A6FB);
    final static protected Color WHITE = new Color(0xFAF9F9);
    final static protected Color BLACK = new Color(0x131200);


    private JLabel myJLabel;



    // konstrukt dosc czesto uzywanego schematu JLabel, wiec zrobilem z niego klase
    protected MyJLabel(String text, Dimension preferedSize, int fontSize, Color fontColor, Color backgroundColor, int alignment){
        this.myJLabel = new JLabel();
        this.myJLabel.setPreferredSize(preferedSize);
        this.myJLabel.setText(text);
        this.myJLabel.setFont(new Font("Century Gothic", Font.BOLD, fontSize));
        this.myJLabel.setForeground(fontColor);
        this.myJLabel.setBackground(backgroundColor);
        this.myJLabel.setHorizontalAlignment(alignment);
        this.myJLabel.setOpaque(true);
        this.myJLabel.setVisible(true);
    }



    // gettery
    protected JLabel getMyJLabel(){
        return this.myJLabel;
    }
}
