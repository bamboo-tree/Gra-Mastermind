package source.window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;






public class MyKeyListener implements KeyListener{

    // zmienna określa, czy odpowiedź została zatwierdzona
    private boolean submitted = false;
    private int code = -1;




    @Override
    public void keyTyped(KeyEvent e) {}


    // jeżeli zostanie wciśnięta spacja lub enter, odpowiedź jest zatwierdzona
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 32 || e.getKeyCode() == 10)
            this.submitted = true;

        this.code = e.getKeyCode();
    }


    @Override
    public void keyReleased(KeyEvent e) {}
    


    // gettery
    public boolean getSubmitted(){
        return this.submitted;
    }
    
    public int getCode(){
        return this.code;
    }

    // setter
    public void setSubmitted(boolean bool){
        this.submitted = bool;
    }
}