package window;


import window.board.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {


    Button button;
    public boolean click = false;

    // konstruktor (towrzy ActionListener pod przycisk)
    public MyActionListener(window.board.Button button){
        this.button = button;
    }


    // po naciśnięciu zmienia się kolor przycisku
    @Override
    public void actionPerformed(ActionEvent e) {
        if(button != null){
            button.nextColor();
        }
        else{
            click = true;
        }
    }


    
}
