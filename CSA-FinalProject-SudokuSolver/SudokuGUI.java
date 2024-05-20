import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


public class SudokuGUI {

    private Cell[][] cells;
    private static final int SIZE = 9, GAP = 2;
    private final JFrame jFrame;

    public SudokuGUI() {

        jFrame = new JFrame("SudokuGUI");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        buildUi();
        jFrame.pack();
        jFrame.setVisible(true);
    }

    void buildUi() {

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(SIZE, SIZE, GAP, GAP));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        jFrame.add(gridPanel, BorderLayout.CENTER);

        cells = new Cell[SIZE][SIZE];
        Random rand = new Random();
        for(int row=0; row <cells.length; row++) {
            for(int col=0; col<cells[row].length; col++) {
                Cell cell = new Cell(rand.nextInt(SIZE+1)); //initialize with random number for demo
                cells[row][col] = cell;
                gridPanel.add(cell);
            }
        }

        jFrame.add(new JLabel("Help:           "),  BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new SudokuGUI()); 
    }  
}
class Cell extends JLabel {

    private static int CELL_H =35, CELL_W = 35;

    Cell(int value) {
        super(String.valueOf(value));
        setHorizontalAlignment(SwingConstants.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.BLUE));
        setPreferredSize(new Dimension(CELL_H , CELL_W));
        setOpaque(true);
    }
}