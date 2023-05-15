package source.window.main_board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;






public class Row {

    // stałe
    final private int BORDER_THICKNESS = 3;
    final private int HEIGHT = Board.HEIGHT/Board.ROWS;
    final private int H_GAP_BOARD = 50;
    final private int H_GAP_OUTPUT = 15;
    final private int V_GAP_BOARD = (HEIGHT - 2*BORDER_THICKNESS - Ball.SIZE) / 2;  
    final private int V_GAP_OUTPUT = (HEIGHT - 2*BORDER_THICKNESS - Ball.SPECIAL_SIZE) / 2;  

    // zmienne
    private JPanel myRow;
    public Button[] buttons = new Button[4];
    public Ball[] balls = new Ball[4];



    
    // konstruktor (tworzy JPanel)
    public Row(boolean output, Color background, Color border){

        this.myRow = new JPanel();
        this.myRow.setPreferredSize(new Dimension(Board.WIDTH, HEIGHT));
        this.myRow.setBackground(background);
        this.myRow.setBorder(BorderFactory.createLineBorder(border, BORDER_THICKNESS, false));
        
        if(!output)
            this.myRow.setLayout(new FlowLayout(FlowLayout.CENTER, H_GAP_BOARD, V_GAP_BOARD));
        else
            this.myRow.setLayout(new FlowLayout(FlowLayout.CENTER, H_GAP_OUTPUT, V_GAP_OUTPUT));
    }


    // dodanie przycisków
    public void addButtons(){
        for(int i = 0; i < 4; i++){
            Button button = new Button();
            this.buttons[i] = button;
            this.myRow.add(button.getButton());
        }
        this.myRow.setVisible(true);
    }


    // zapisanie wybranych przez gracza kolorów w tablicy
    public void submit(){
        int[] submittedColors = new int[4];
        for(int i = 0; i < 4; i++)
            submittedColors[i] = this.buttons[i].getButtonColorIndex();
    }


    // dodanie/zaktualizowanie kolorów na podstawie tablicy z indeksami
    public void addColors(int[] index, boolean output){
        for(int i = 0; i < 4; i++){
            this.balls[i] = new Ball(index[i], output);
            this.myRow.add(this.balls[i].getBall());
        }
    }


    // gettery
    public JPanel getRow(){
        return this.myRow;
    }

    public int getButton(int index){
        return this.buttons[index].getButtonColorIndex();
    }
}