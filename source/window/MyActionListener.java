package source.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import source.window.main_board.Button;






public class MyActionListener implements ActionListener {

    private Button button;
    private boolean click = false;




    // konstruktor (towrzy ActionListener pod przycisk w grze)
    public MyActionListener(source.window.main_board.Button button){
        this.button = button;
    }


    // (pod zwyly przycisk)
    public MyActionListener(){
        this.button = null;
    }



    // po naciśnięciu zmienia się kolor przycisku
    @Override
    public void actionPerformed(ActionEvent e) {
        if(button != null)
            this.button.nextColor();
        else
            this.click = true;
    }

    

    // getter
    public boolean getClick(){
        return this.click;
    }
}
