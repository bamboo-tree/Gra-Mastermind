package window.end_screen;

import javax.swing.JButton;

public class Button3 {
    
    protected JButton button;
    
    public Button3(){
        button = new JButton();

        button.setBackground(null);
        button.setFocusable(false);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setVisible(true);
    }

    public JButton getButton(){
        return button;
    }
}
