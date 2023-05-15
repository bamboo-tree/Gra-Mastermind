package source.window.welcome_guide_end_screens;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import source.User;






public class EndScreen {

    private String statsText;
    private String resultText;
    

    private JPanel myEndScreen;
    private MyJLabel stats;
    private MyJLabel result;
    private Button endGame;
    private Button playAgain;
    



    public EndScreen(){
        this.myEndScreen = new JPanel();
        this.myEndScreen.setPreferredSize(new Dimension(MyJLabel.WIDTH, MyJLabel.HEIGHT));
        this.myEndScreen.setLayout(new BorderLayout());



        // wygrana czy przegrana
        this.result = new MyJLabel(
            this.resultText, 
            new Dimension(MyJLabel.WIDTH, 250), 
            32,
            MyJLabel.BLACK, 
            MyJLabel.WHITE, 
            JLabel.CENTER
        );
        this.myEndScreen.add(result.getMyJLabel(), BorderLayout.NORTH);


        // wynik gry
        this.stats = new MyJLabel(
            this.statsText, 
            new Dimension(MyJLabel.WIDTH, 3500), 
            18, 
            MyJLabel.WHITE, 
            MyJLabel.BLACK, 
            JLabel.CENTER
        );
        this.myEndScreen.add(this.stats.getMyJLabel(), BorderLayout.CENTER);


        // przyciski
        JPanel buttons = new JPanel();
        buttons.setPreferredSize(new Dimension(MyJLabel.WIDTH, 100));
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




    public void createText(User user){
        this.statsText = String.format("<html><h1>%s</h1><h2>TIME: %5.3f s [ %5.3f s ]</h2><h2>SCORE: %d [ %d ]</h2><h2>GAMES PLAYED: %d</h2></html>", user.getName(), user.getTime()/1000, user.getBestTime()/1000, user.getScore(), user.getBestScore(), user.getGamesPlayed());
    }

    public void setResultText(boolean win){
        if(win){
            this.result.getMyJLabel().setBackground(MyJLabel.GREEN);
            this.resultText = "Congratulations! You won!";
        }
        else{
            this.result.getMyJLabel().setBackground(MyJLabel.RED);
            this.resultText = "You lose. Better luck next time!";
        }
    }



    // gettery
    public JPanel getEndScreen(){
        return this.myEndScreen;
    }
    
    public Button getEndGameButton(){
        return this.endGame;
    }

    public Button getPlayAgainButton(){
        return this.playAgain;
    }

    public JLabel getStats(){
        return this.stats.getMyJLabel();
    }

    public JLabel getResult(){
        return this.result.getMyJLabel();
    }

    public String getResultText(){
        return this.resultText;
    }

    public String getStatsText(){
        return this.statsText;
    }
}