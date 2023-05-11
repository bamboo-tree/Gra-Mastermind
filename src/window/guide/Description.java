package window.guide;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import window.Frame;


public class Description {

    final public Color RED = new Color(0xD00000);
    final public Color GREEN = new Color(0x37FF8B);
    final public Color BLUE = new Color(0x00A6FB);
    final public Color WHITE = new Color(0xFAF9F9);
    final public Color BLACK = new Color(0x131200);

    final private ImageIcon EASY = new ImageIcon(new ImageIcon("./img/easy_mode.png").getImage().getScaledInstance(120, 25, Image.SCALE_DEFAULT));
    final private ImageIcon NORMAL = new ImageIcon(new ImageIcon("./img/normal_mode.png").getImage().getScaledInstance(120, 25, Image.SCALE_DEFAULT));



    private JPanel container;
    private Button2 easyButton;
    private Button2 normalButton;
    private String text = "<html><h1>BASIC RULES</h1><p>Your gola is to guess hidden color pattern in smallest number of attempts.<br><br>Every time you submit (ENTER or space) you will get output,<br>depending on gamemode it can be more or less helpful.<br><br><br>BLACK - color is in right place<br>WHITE - color is in wrong place<br>EMPTY - color doesn't occur<br><br><h3>To start choose difficulty below</h3></p></html>";
    private final int WIDTH = 900;
    private final int HEIGHT = 700;


    public Description(){

        // ustawianie JPanelu
        container = new JPanel();
        container.setLayout(new BorderLayout());
        container.setFocusable(true);


        // zasady gry
        JLabel rules = new JLabel();
        rules.setPreferredSize(new Dimension(WIDTH, 500));
        rules.setBackground(BLACK);
        rules.setForeground(WHITE);
        rules.setText(text);
        rules.setFont(new Font("Century Gothic", Font.BOLD, 16));
        rules.setHorizontalAlignment(JLabel.CENTER);
        rules.setOpaque(true);

        container.add(rules, BorderLayout.NORTH);






        // wybor trybu

        //latwy
        JPanel easyPanel = new JPanel();
        easyPanel.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
        easyPanel.setLayout(new BorderLayout());
        easyPanel.setBackground(BLACK);

        JLabel easyLabel = new JLabel();
        easyLabel.setText("◄      E A S Y");
        easyLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
        easyLabel.setHorizontalAlignment(JLabel.CENTER);
        easyLabel.setOpaque(true);
        easyLabel.setBackground(null);
        easyLabel.setForeground(GREEN);


        easyButton = new Button2();
        easyButton.button.setPreferredSize(new Dimension(WIDTH/4, HEIGHT));
        easyButton.button.setIcon(EASY);
        easyButton.button.setHorizontalAlignment(JLabel.CENTER);
        easyButton.button.setVerticalAlignment(JLabel.CENTER);
        

        easyPanel.add(easyButton.button, BorderLayout.WEST);
        easyPanel.add(easyLabel, BorderLayout.CENTER);
        container.add(easyPanel, BorderLayout.WEST);
        easyPanel.setVisible(true);
        


        //normalny
        JPanel normalPanel = new JPanel();
        normalPanel.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
        normalPanel.setLayout(new BorderLayout());
        normalPanel.setBackground(BLACK);


        JLabel normalLabel = new JLabel();
        normalLabel.setText("N O R M A L      ►");
        normalLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
        normalLabel.setHorizontalAlignment(JLabel.CENTER);
        normalLabel.setOpaque(true);
        normalLabel.setBackground(null);
        normalLabel.setForeground(RED);


        normalButton = new Button2();
        normalButton.button.setIcon(NORMAL);
        normalButton.button.setPreferredSize(new Dimension(WIDTH/4, HEIGHT));
        normalButton.button.setHorizontalAlignment(JLabel.CENTER);
        normalButton.button.setVerticalAlignment(JLabel.CENTER);

        normalPanel.add(normalButton.button, BorderLayout.EAST);
        normalPanel.add(normalLabel, BorderLayout.CENTER);
        container.add(normalPanel, BorderLayout.EAST);



    }


    // usuwanie zawartosci z okna
    public void killDescription(Frame frame){
        frame.getFrame().getContentPane().remove(container);
        frame.getFrame().invalidate();
        frame.getFrame().validate();
        frame.getFrame().setVisible(true);
    }


    // getter
    public JPanel getDescription(){
        return container;
    }

    public JButton getEasyButton(){
        return easyButton.button;
    }

    public JButton getNormalButton(){
        return normalButton.button;
    }
    
}
