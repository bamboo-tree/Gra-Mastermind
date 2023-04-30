package window.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Row {

    final private Color GRAY = new Color(0x46494C);
    final private Color DARK_GRAY = new Color(0x252422);

    
    final private int BORDER_THICKNESS = 3;
    final private int HEIGHT = Board.HEIGHT/Board.ROWS;
    final private int H_GAP = 50;
    final private int V_GAP = (HEIGHT - Ball.SIZE) / 2 - (2 * BORDER_THICKNESS);


    private JPanel container;
    public Button[] buttons = new Button[4];

    
    public Row(){
        container = new JPanel();
        container.setPreferredSize(new Dimension(Board.WIDTH, Board.HEIGHT/Board.ROWS));
        container.setBackground(GRAY);
        container.setLayout(new FlowLayout(FlowLayout.CENTER, H_GAP, V_GAP));
        container.setBorder(BorderFactory.createLineBorder(DARK_GRAY, BORDER_THICKNESS, false));
    }

    public Row(int[] colorIndex){
        container = new JPanel();
        container.setPreferredSize(new Dimension(Board.WIDTH, Board.HEIGHT/Board.ROWS));
        container.setBackground(GRAY);
        container.setLayout(new FlowLayout(FlowLayout.CENTER, H_GAP, V_GAP));
        container.setBorder(BorderFactory.createLineBorder(DARK_GRAY, BORDER_THICKNESS, false));
        for(int i : colorIndex){
            JLabel temp = new JLabel();
            temp.setPreferredSize(new Dimension(Ball.SIZE, Ball.SIZE));
            temp.setBackground(null);
            temp.setOpaque(true);
            temp.setIcon(Ball.colors[i]);
            container.add(temp);
        }
    }


    public void addButtons(){
        for(int i = 0; i < 4; i++){
            Button button = new Button();
            buttons[i] = button;
            this.getRow().add(button.getButton());
        }
        this.getRow().setVisible(true);
    }


    public void submit(){
        int[] submittedColors = new int[4];
        for(int i = 0; i < 4; i++){
            submittedColors[i] = buttons[i].buttonColorIndex;
            System.out.println(submittedColors[i]);
        }
    }


    public JPanel getRow(){
        return container;
    }
}
