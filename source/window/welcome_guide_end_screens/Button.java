package source.window.welcome_guide_end_screens;

import javax.swing.JButton;






public class Button {

    private JButton button;
    


    // konstruktor (tworzy czysty JButton)
    public Button(){
        this.button = new JButton();
        this.button.setBackground(null);
        this.button.setFocusable(false);
        this.button.setContentAreaFilled(false);
        this.button.setBorder(null);
        this.button.setVisible(true);
    }

    // getter
    public JButton getButton(){
        return this.button;
    }
}