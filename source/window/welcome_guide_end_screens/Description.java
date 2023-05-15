package source.window.welcome_guide_end_screens;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import source.window.Frame;






public class Description {

    final private ImageIcon EASY = new ImageIcon(new ImageIcon("./img/easy_mode.png").getImage().getScaledInstance(160, 40, Image.SCALE_DEFAULT));
    final private ImageIcon NORMAL = new ImageIcon(new ImageIcon("./img/normal_mode.png").getImage().getScaledInstance(160, 40, Image.SCALE_DEFAULT));



    private JPanel myDescription;
    private Button easyButton;
    private Button normalButton;
    private String text = "<html><h1>BASIC RULES</h1><p>Your gola is to guess hidden color pattern in smallest number of attempts.<br><br>Every time you submit (ENTER or space) you will get output,<br>depending on gamemode it can be more or less helpful.<br><br><br>BLACK - color is in right place<br>WHITE - color is in wrong place<br>EMPTY - color doesn't occur<br><br><h3>To start choose difficulty below</h3></p></html>";



    public Description(){

        // ustawianie JPanelu
        this.myDescription = new JPanel();
        this.myDescription.setLayout(new BorderLayout());
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
        this.myDescription.add(rules.getMyJLabel(), BorderLayout.NORTH);



        // przyciski z trybami gry
        //latwy
        JPanel easyPanel = new JPanel();
        easyPanel.setPreferredSize(new Dimension(MyJLabel.WIDTH/2, MyJLabel.HEIGHT));
        easyPanel.setLayout(new BorderLayout(10, 10));
        easyPanel.setBackground(MyJLabel.BLACK);

        MyJLabel easyLabel = new MyJLabel(
            "◄      E A S Y", 
            null, 
            18, 
            MyJLabel.GREEN, 
            null, 
            JLabel.CENTER
        );

        this.easyButton = new Button();
        this.easyButton.getButton().setPreferredSize(new Dimension(MyJLabel.WIDTH/4, MyJLabel.HEIGHT));
        this.easyButton.getButton().setIcon(EASY);
        this.easyButton.getButton().setHorizontalAlignment(JLabel.CENTER);
        this.easyButton.getButton().setVerticalAlignment(JLabel.CENTER);
        
        easyPanel.add(this.easyButton.getButton(), BorderLayout.WEST);
        easyPanel.add(easyLabel.getMyJLabel(), BorderLayout.CENTER);
        this.myDescription.add(easyPanel, BorderLayout.WEST);
        easyPanel.setVisible(true);
        



        //normalny
        JPanel normalPanel = new JPanel();
        normalPanel.setPreferredSize(new Dimension(MyJLabel.WIDTH/2, MyJLabel.HEIGHT));
        normalPanel.setLayout(new BorderLayout(10, 10));    ////////////////////////////////////////////////
        normalPanel.setBackground(MyJLabel.BLACK);

        MyJLabel normalLabel = new MyJLabel(
            "N O R M A L      ►", 
            null, 
            18, 
            MyJLabel.RED, 
            null, 
            JLabel.CENTER
        );
        
        this.normalButton = new Button();
        this.normalButton.getButton().setIcon(NORMAL);
        this.normalButton.getButton().setPreferredSize(new Dimension(MyJLabel.WIDTH/4, MyJLabel.HEIGHT));
        this.normalButton.getButton().setHorizontalAlignment(JLabel.CENTER);
        this.normalButton.getButton().setVerticalAlignment(JLabel.CENTER);

        normalPanel.add(this.normalButton.getButton(), BorderLayout.EAST);
        normalPanel.add(normalLabel.getMyJLabel(), BorderLayout.CENTER);
        this.myDescription.add(normalPanel, BorderLayout.EAST);
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

