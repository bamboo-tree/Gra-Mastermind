package source.window.main_board;

import java.awt.Dimension;
import javax.swing.JButton;






public class Button {
    
    // zmienne
    private JButton button;
    private int buttonColorIndex = 0;





    
    // konstruktor (tworzy JButton z grafiką odpowiedniego przcisku)
    public Button(){
        this.button = new JButton();
        this.button.setPreferredSize(new Dimension(Ball.SIZE, Ball.SPECIAL_SIZE));
        this.button.setBackground(null);
        this.button.setFocusable(false);
        this.button.setContentAreaFilled(false);
        this.button.setBorder(null);
        this.button.setIcon(Ball.colors[this.buttonColorIndex]);
        this.button.setVisible(true);
    }



    // zmiana koloru przycisku na kolejny
    public void nextColor(){
        if(this.buttonColorIndex < Ball.colors.length-1){
            this.buttonColorIndex++;
        }
        else{
            this.buttonColorIndex = 0;
        }
        this.button.setIcon(Ball.colors[this.buttonColorIndex]);
    }



    // getter
    public JButton getButton(){
        return this.button;
    }

    protected int getButtonColorIndex(){
        return this.buttonColorIndex;
    }
}
