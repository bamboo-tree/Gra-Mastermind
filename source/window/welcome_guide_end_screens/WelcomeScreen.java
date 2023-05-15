package source.window.welcome_guide_end_screens;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import source.window.Frame;




public class WelcomeScreen {
    
    private JPanel myWelcomeScreen;
    private JTextField usernameInput;
    private MyJLabel userInfo;

    


    public WelcomeScreen(){
        this.myWelcomeScreen = new JPanel();
        this.myWelcomeScreen.setLayout(new BorderLayout());
        this.myWelcomeScreen.setPreferredSize(new Dimension(MyJLabel.WIDTH, MyJLabel.HEIGHT));


        // nazwa gry
        MyJLabel title = new MyJLabel(
            "Mastermind",
            new Dimension(MyJLabel.WIDTH, 300),
            52,
            MyJLabel.BLACK,
            MyJLabel.BLUE,
            JLabel.CENTER
        );
        this.myWelcomeScreen.add(title.getMyJLabel(), BorderLayout.NORTH);


        // informacje o autorze
        MyJLabel info = new MyJLabel(
            "Maciej Kamiński 2023",
            new Dimension(MyJLabel.WIDTH,50),
            16,
            MyJLabel.WHITE,
            MyJLabel.BLACK,
            JLabel.CENTER
        );
        this.myWelcomeScreen.add(info.getMyJLabel(), BorderLayout.SOUTH);


        // JPanel pod wejście
        JPanel inputSection = new JPanel();
        inputSection.setOpaque(true);
        inputSection.setBackground(MyJLabel.WHITE);
        inputSection.setLayout(new GridLayout(3,1));


        // zachęta
        MyJLabel text = new MyJLabel(
            "◄ Enter username ►", 
            null, 
            36, 
            MyJLabel.BLACK, 
            MyJLabel.WHITE, 
            JLabel.CENTER
        );
        inputSection.add(text.getMyJLabel());


        // pole tekstowe pod nazwę użytkownika
        this.usernameInput = new JTextField();
        this.usernameInput.setToolTipText("username should contain letters and digits: A-Z, a-z, 0-9 spaces and other special characters are unallowed");
        this.usernameInput.setFont(new Font("Century Gothic", Font.BOLD, 30));
        this.usernameInput.setHorizontalAlignment(JTextField.CENTER);
        this.usernameInput.setBackground(MyJLabel.WHITE);
        this.usernameInput.setForeground(MyJLabel.BLACK);
        this.usernameInput.setBorder(null);
        inputSection.add(this.usernameInput);

        
        // pamiętaj o ładnej nazwie użytkownika <3
        this.userInfo = new MyJLabel(
            "remember to make it pretty :D", 
            null, 
            18, 
            MyJLabel.BLACK, 
            MyJLabel.WHITE, 
            JLabel.CENTER
        );
        inputSection.add(userInfo.getMyJLabel());

        myWelcomeScreen.add(inputSection, BorderLayout.CENTER);
    }



    // usuwanie zawartosci z okna
    public void killWelcomeScreen(Frame frame){
        frame.getFrame().getContentPane().remove(myWelcomeScreen);
        frame.getFrame().invalidate();
        frame.getFrame().validate();
        frame.getFrame().setVisible(true);
    }



    // getter
    public JPanel getWelcomeScreen(){
        return myWelcomeScreen;
    }

    public JLabel getMyJLabel(){
        return this.userInfo.getMyJLabel();
    }

    public JTextField getTextField(){
        return this.usernameInput;
    }
}