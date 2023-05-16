package source.window.welcome_guide_end_screens;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import source.window.Frame;






public class Description {

    // grafiki do przyciskow, wskazuja na sposob sprawdzania
    final private ImageIcon EASY = new ImageIcon(new ImageIcon("./img/easy_mode.png").getImage().getScaledInstance(120, 30, Image.SCALE_DEFAULT));
    final private ImageIcon NORMAL = new ImageIcon(new ImageIcon("./img/normal_mode.png").getImage().getScaledInstance(120, 30, Image.SCALE_DEFAULT));


    // obiekty do stworzenia opisu
    private JPanel myDescription;
    private Button easyButton;
    private Button normalButton;
    private String text = "<html><h1>BASIC RULES</h1><p>Your gola is to guess hidden color pattern in smallest number of attempts.<br><br>Every time you submit (ENTER or space) you will get an output,<br>depending on gamemode it can be more or less helpful.<br>Colors in your answer can not repeat.<br><br><br>BLACK - color is in right place<br>WHITE - color is in wrong place<br>EMPTY - color doesn't occur<br><br><h3>To start choose difficulty below</h3></p></html>";



    public Description(){

        // ustawianie JPanelu
        this.myDescription = new JPanel();
        this.myDescription.setLayout(new BorderLayout(0,0));
        this.myDescription.setFocusable(true);


        // zasady gry
        MyJLabel rules = new MyJLabel(
            text, 
            new Dimension(MyJLabel.WIDTH, 500), 
            20, 
            MyJLabel.WHITE, 
            MyJLabel.BLACK, 
            JLabel.CENTER
        );
        this.myDescription.add(rules.getMyJLabel(), BorderLayout.CENTER);



        // przyciski z trybami gry
        JPanel buttons = new JPanel();
        buttons.setPreferredSize(new Dimension(MyJLabel.WIDTH, 150));
        buttons.setLayout(new GridLayout(1,2));
        buttons.setBackground(MyJLabel.BLACK);


        //latwy
        MyJLabel easyLabel = new MyJLabel(
            "E A S Y", 
            new Dimension(MyJLabel.WIDTH, 150), 
            24, 
            MyJLabel.BLACK, 
            null, 
            JLabel.CENTER
        );

        // dodanie tekstu i grafiki do przycisku
        easyLabel.getMyJLabel().setIcon(EASY);
        easyLabel.getMyJLabel().setVerticalTextPosition(JLabel.TOP);
        easyLabel.getMyJLabel().setHorizontalTextPosition(JLabel.CENTER);
        easyLabel.getMyJLabel().setIconTextGap(10);

        this.easyButton = new Button();
        this.easyButton.getButton().setPreferredSize(new Dimension(MyJLabel.WIDTH/2, MyJLabel.HEIGHT));
        this.easyButton.getButton().setOpaque(true);
        this.easyButton.getButton().setBackground(MyJLabel.GREEN);
        this.easyButton.getButton().setHorizontalAlignment(JLabel.CENTER);
        this.easyButton.getButton().setVerticalAlignment(JLabel.CENTER);
        this.easyButton.getButton().setLayout(new BorderLayout());
        this.easyButton.getButton().add(easyLabel.getMyJLabel(), BorderLayout.NORTH);
        
        
        // dodanie do JPanel'u
        buttons.add(this.easyButton.getButton());
        this.myDescription.add(buttons, BorderLayout.WEST);
        



        //normalny
        MyJLabel normalLabel = new MyJLabel(
            "N O R M A L", 
            new Dimension(MyJLabel.WIDTH, 150), 
            24, 
            MyJLabel.BLACK, 
            null, 
            JLabel.CENTER
        );

        // dodanie tekstu i grafiki do przycisku
        normalLabel.getMyJLabel().setIcon(NORMAL);
        normalLabel.getMyJLabel().setVerticalTextPosition(JLabel.TOP);
        normalLabel.getMyJLabel().setHorizontalTextPosition(JLabel.CENTER);
        normalLabel.getMyJLabel().setIconTextGap(10);
        
        this.normalButton = new Button();
        this.normalButton.getButton().setPreferredSize(new Dimension(MyJLabel.WIDTH/2, MyJLabel.HEIGHT));
        this.normalButton.getButton().setOpaque(true);
        this.normalButton.getButton().setBackground(MyJLabel.BLUE);
        this.normalButton.getButton().setHorizontalAlignment(JLabel.CENTER);
        this.normalButton.getButton().setVerticalAlignment(JLabel.CENTER);
        this.normalButton.getButton().setLayout(new BorderLayout());
        this.normalButton.getButton().add(normalLabel.getMyJLabel(), BorderLayout.NORTH);


        // dodanie do JPanel'u
        buttons.add(this.normalButton.getButton());
        this.myDescription.add(buttons, BorderLayout.EAST);
        


        // dodanie do opisu
        buttons.setVisible(true);
        this.myDescription.add(buttons, BorderLayout.SOUTH);
    }



    // niszczenie JPanel'u
    public void killDescription(Frame frame){
        frame.getFrame().getContentPane().remove(this.myDescription);
        frame.getFrame().invalidate();
        frame.getFrame().validate();
        frame.getFrame().setVisible(true);
    }



    // getter
    public JPanel getDescription(){
        return this.myDescription;
    }

    public JButton getEasyButton(){
        return this.easyButton.getButton();
    }

    public JButton getNormalButton(){
        return this.normalButton.getButton();
    }
    
}

