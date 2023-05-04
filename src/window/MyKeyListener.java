package window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener{

    // zmienna określa, czy odpowiedź została zatwierdzona
    public boolean submitted = false;


    @Override
    public void keyTyped(KeyEvent e) {}

    // jeżeli zostanie wciśnięta spacja lub enter, odpowiedź jest zatwierdzona
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 32 || e.getKeyCode() == 10){
            System.out.println("submit");
            this.submitted = true;
        }
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
