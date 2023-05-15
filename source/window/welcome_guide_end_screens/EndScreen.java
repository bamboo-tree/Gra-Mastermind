package source.window.welcome_guide_end_screens;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;






public class EndScreen {

    final private String text = "aaaa";

    private JPanel myEndScreen;
    private Button endGame;
    private Button playAgain;
    



    public EndScreen(){
        this.myEndScreen = new JPanel();
        this.myEndScreen.setPreferredSize(new Dimension(MyJLabel.WIDTH, MyJLabel.HEIGHT));
        this.myEndScreen.setLayout(new BorderLayout());



        // wygrana czy przegrana
        MyJLabel result = new MyJLabel(
            "YOU won/lost", 
            new Dimension(MyJLabel.WIDTH, 200), 
            32,
            MyJLabel.BLACK, 
            MyJLabel.WHITE, 
            JLabel.CENTER
        );
        this.myEndScreen.add(result.getMyJLabel(), BorderLayout.NORTH);


        // wynik gry
        MyJLabel stats = new MyJLabel(
            text, 
            new Dimension(MyJLabel.WIDTH, 300), 
            18, 
            MyJLabel.WHITE, 
            MyJLabel.BLACK, 
            JLabel.CENTER
        );
        this.myEndScreen.add(stats.getMyJLabel(), BorderLayout.CENTER);


        // przyciski
        JPanel buttons = new JPanel();
        buttons.setPreferredSize(new Dimension(MyJLabel.WIDTH, 200));
        buttons.setBackground(MyJLabel.BLUE);
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        this.playAgain = new Button();
        this.playAgain.getButton().setPreferredSize(new Dimension(MyJLabel.WIDTH/2, MyJLabel.HEIGHT));
        this.playAgain.getButton().setText("YES");
        this.playAgain.getButton().setBackground(MyJLabel.BLACK);

        this.endGame = new Button();
        this.endGame.getButton().setPreferredSize(new Dimension(MyJLabel.WIDTH/2, MyJLabel.HEIGHT));
        this.endGame.getButton().setText("NO");
        this.endGame.getButton().setBackground(MyJLabel.GREEN);

        buttons.add(this.playAgain.getButton());
        buttons.add(this.endGame.getButton());


        this.myEndScreen.add(buttons, BorderLayout.SOUTH);
    }


    public JPanel getEndScreen(){
        return this.myEndScreen;
    }
    
    public Button getEndGameButton(){
        return this.endGame;
    }

    public Button getPlayAgainButton(){
        return this.playAgain;
    }
}