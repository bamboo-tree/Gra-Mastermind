package window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener{

    // zmienna określa, czy odpowiedź została zatwierdzona
    public boolean submitted = false;
    public int code = -1;


    @Override
    public void keyTyped(KeyEvent e) {}

    // jeżeli zostanie wciśnięta spacja lub enter, odpowiedź jest zatwierdzona
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 32 || e.getKeyCode() == 10){
            System.out.println("submit");
            this.submitted = true;
        }
        code = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
