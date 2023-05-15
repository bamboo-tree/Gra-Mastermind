package window.end_screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndScreen {

    private JPanel container;
    
    final private int WIDTH = 900;
    final private int HEIGHT = 700;
    final private String text = "aaaa";

    final public Color RED = new Color(0xD00000);
    final public Color GREEN = new Color(0x37FF8B);
    final public Color BLUE = new Color(0x00A6FB);
    final public Color WHITE = new Color(0xFAF9F9);
    final public Color BLACK = new Color(0x131200);



    public EndScreen(){
        container = new JPanel();
        container.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        container.setLayout(new BorderLayout());



        // wygrana czy przegrana
        JLabel result = new JLabel();
        result.setPreferredSize(new Dimension(WIDTH, 200));
        result.setBackground(WHITE);
        result.setForeground(BLACK);
        result.setText("YOU won/lost");
        result.setFont(new Font("Century Gothic", Font.BOLD, 30));
        result.setHorizontalAlignment(JLabel.CENTER);
        result.setOpaque(true);

        container.add(result, BorderLayout.NORTH);




        // wynik gry
        JLabel stats = new JLabel();
        stats.setPreferredSize(new Dimension(WIDTH, 300));
        stats.setBackground(BLACK);
        stats.setForeground(WHITE);
        stats.setText(text);
        stats.setFont(new Font("Century Gothic", Font.BOLD, 20));
        stats.setHorizontalAlignment(JLabel.CENTER);
        stats.setOpaque(true);

        container.add(stats, BorderLayout.CENTER);


        // przyciski
        JPanel buttons = new JPanel();
        buttons.setPreferredSize(new Dimension(WIDTH, 200));
        buttons.setBackground(BLUE);
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        Button3 yes = new Button3();
        yes.getButton().setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
        yes.getButton().setText("YES");

        Button3 no = new Button3();
        no.getButton().setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
        no.getButton().setText("NO");

        buttons.add(yes.getButton());
        buttons.add(no.getButton());


        container.add(buttons, BorderLayout.SOUTH);


    }


    public JPanel getEndScreen(){
        return container;
    }
    
}
