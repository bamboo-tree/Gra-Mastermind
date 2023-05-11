package window.guide;

import javax.swing.JButton;

public class Button2 {

    protected JButton button;
    
    public Button2(){
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
