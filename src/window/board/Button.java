package window.board;

import java.awt.Dimension;
import javax.swing.JButton;

public class Button {
    
    private JButton button;
    protected int buttonColorIndex = 0;

    public Button(){
        button = new JButton();
        button.setPreferredSize(new Dimension(Ball.SIZE, Ball.SIZE));
        button.setBackground(null);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setIcon(Ball.colors[this.buttonColorIndex]);
        button.setVisible(true);
    }



    public void nextColor(){
        if(buttonColorIndex < Ball.colors.length-1){
            buttonColorIndex++;
        }
        else{
            buttonColorIndex = 0;
        }
        this.button.setIcon(Ball.colors[buttonColorIndex]);
    }

    public JButton getButton(){
        return this.button;
    }
}
