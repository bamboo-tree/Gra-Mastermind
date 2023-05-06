package window.board;

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
    private JPanel container;
    public Button[] buttons = new Button[4];
    public Ball[] balls = new Ball[4];

    
    // konstruktor (tworzy JPanel)
    public Row(boolean output, Color background, Color border){

        System.out.println(HEIGHT);

        container = new JPanel();
        container.setPreferredSize(new Dimension(Board.WIDTH, HEIGHT));
        container.setBackground(background);
        container.setBorder(BorderFactory.createLineBorder(border, BORDER_THICKNESS, false));
        
        if(!output)
            container.setLayout(new FlowLayout(FlowLayout.CENTER, H_GAP_BOARD, V_GAP_BOARD));
        else
            container.setLayout(new FlowLayout(FlowLayout.CENTER, H_GAP_OUTPUT, V_GAP_OUTPUT));
    }


    // dodanie przycisków
    public void addButtons(){
        for(int i = 0; i < 4; i++){
            Button button = new Button();
            buttons[i] = button;
            this.getRow().add(button.getButton());
        }
        this.getRow().setVisible(true);
    }


    // zapisanie wybranych przez gracza kolorów w tablicy
    public void submit(){
        int[] submittedColors = new int[4];
        for(int i = 0; i < 4; i++){
            submittedColors[i] = buttons[i].buttonColorIndex;
            System.out.println(submittedColors[i]);
        }
    }


    // dodanie/zaktualizowanie kolorów na podstawie tablicy z indeksami
    public void addColors(int[] index, boolean output){
        for(int i = 0; i < 4; i++){
            balls[i] = new Ball(index[i], output);
            this.container.add(balls[i].getBall());
        }
    }


    // gettery
    public JPanel getRow(){
        return container;
    }

    public int getButton(int index){
        return buttons[index].buttonColorIndex;
    }
}
