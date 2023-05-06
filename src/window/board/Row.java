package window.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;


import javax.swing.BorderFactory;
import javax.swing.JPanel;



public class Row {

    // zdefiniowane kolory
    final private Color GRAY = new Color(0xD6E5E3);
    final private Color DARK_GRAY = new Color(0xCACFD6);

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
    public Row(boolean output){

        System.out.println(HEIGHT);

        container = new JPanel();
        container.setPreferredSize(new Dimension(Board.WIDTH, HEIGHT));
        

        if(!output){
            container.setBackground(GRAY);
            container.setLayout(new FlowLayout(FlowLayout.CENTER, H_GAP_BOARD, V_GAP_BOARD));
            container.setBorder(BorderFactory.createLineBorder(DARK_GRAY, BORDER_THICKNESS, false));
        }
        else{
            container.setBackground(DARK_GRAY);
            container.setLayout(new FlowLayout(FlowLayout.CENTER, H_GAP_OUTPUT, V_GAP_OUTPUT));
            container.setBorder(BorderFactory.createLineBorder(GRAY, BORDER_THICKNESS, false));
        }
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
