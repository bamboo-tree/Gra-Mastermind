package window.welcome_screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import window.Frame;




public class WelcomeScreen {
    
    final static protected int WIDTH = 900;
    final static protected int HEIGHT = 700;


    final public Color RED = new Color(0xD00000);
    final public Color GREEN = new Color(0x37FF8B);
    final public Color BLUE = new Color(0x00A6FB);
    final public Color WHITE = new Color(0xFAF9F9);
    final public Color BLACK = new Color(0x131200);




    public JPanel container;
    public JTextField usernameInput;
    public JLabel userInfo;

    

    public WelcomeScreen(){
        container = new JPanel();
        container.setLayout(new BorderLayout());
        container.setPreferredSize(new Dimension(WIDTH, HEIGHT));


        // nazwa gry
        JLabel title = new JLabel();
        title.setPreferredSize(new Dimension(WIDTH, 300));
        title.setText("Mastermind");
        title.setFont(new Font("Century Gothic", Font.BOLD, 52));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setOpaque(true);
        title.setBackground(BLUE);
        title.setForeground(BLACK);
        container.add(title, BorderLayout.NORTH);

        // informacje o autorze
        JLabel info = new JLabel();
        info.setPreferredSize(new Dimension(WIDTH, 50));
        info.setText("Maciej Kamiński 2023");
        info.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        info.setHorizontalAlignment(JLabel.CENTER);
        info.setOpaque(true);
        info.setBackground(BLACK);
        info.setForeground(WHITE);
        container.add(info, BorderLayout.SOUTH);

        // JPanel pod wejście
        JPanel inputSection = new JPanel();
        inputSection.setOpaque(true);
        inputSection.setBackground(WHITE);
        inputSection.setLayout(new GridLayout(3,1));

        // zachęta
        JLabel text = new JLabel();
        text.setText("◄ Enter username ►");
        text.setFont(new Font("Century Gothic", Font.BOLD, 36));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setOpaque(true);
        text.setBackground(WHITE);
        text.setForeground(BLACK);
        inputSection.add(text);

        // pole tekstowe pod nazwę użytkownika
        usernameInput = new JTextField();
        usernameInput.setToolTipText("username should contain letters and digits: A-Z, a-z, 0-9 spaces and other special characters are unallowed");
        usernameInput.setFont(new Font("Century Gothic", Font.BOLD, 30));
        usernameInput.setHorizontalAlignment(SwingConstants.CENTER);
        usernameInput.setBackground(WHITE);
        usernameInput.setForeground(BLACK);
        usernameInput.setBorder(null);
        inputSection.add(usernameInput);

        // pamiętaj o ładnej nazwie użytkownika <3
        userInfo = new JLabel();
        userInfo.setText("remember to make it pretty :D");
        userInfo.setFont(new Font("Century Gothic", Font.BOLD, 18));
        userInfo.setHorizontalAlignment(JLabel.CENTER);
        userInfo.setOpaque(true);
        userInfo.setBackground(WHITE);
        userInfo.setForeground(BLACK);
        inputSection.add(userInfo);


        container.add(inputSection, BorderLayout.CENTER);
        
    }


    // usuwanie zawartosci z okna
    public void killWelcomeScreen(Frame frame){
        frame.getFrame().getContentPane().remove(container);
        frame.getFrame().invalidate();
        frame.getFrame().validate();
        frame.getFrame().setVisible(true);
    }


    // getter
    public JPanel getWelcomeScreen(){
        return container;
    }


}
