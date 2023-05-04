package window.board;

import java.awt.Dimension;
import javax.swing.JButton;

public class Button {
    
    // zmienne
    private JButton button;
    protected int buttonColorIndex = 0;


    
    // konstruktor (tworzy JButton z grafiką odpowiedniego przcisku)
    public Button(){
        button = new JButton();
        button.setPreferredSize(new Dimension(Ball.SIZE, Ball.SIZE));
        button.setBackground(null);
        button.setFocusable(false);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setIcon(Ball.colors[this.buttonColorIndex]);
        button.setVisible(true);
    }



    // zmiana koloru przycisku na kolejny
    public void nextColor(){
        if(buttonColorIndex < Ball.colors.length-1){
            buttonColorIndex++;
        }
        else{
            buttonColorIndex = 0;
        }
        this.button.setIcon(Ball.colors[buttonColorIndex]);
    }



    // getter
    public JButton getButton(){
        return this.button;
    }
}
