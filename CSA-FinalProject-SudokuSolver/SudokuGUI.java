import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SudokuGUI {

    private Cell[][] cells;
    private static final int SIZE = 9, GAP = 2;
    private final JFrame jFrame;
    private int[][] board;

    public SudokuGUI(int[][] puzzle) {
        jFrame = new JFrame("SudokuGUI");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        this.board = puzzle;
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
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Cell cell = new Cell(board[row][col]);
                cells[row][col] = cell;
                gridPanel.add(cell);
            }
        }

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> {
                    SudokuSolver solver = new SudokuSolver(SudokuGUI.this);
                    if (!solver.solveSudoku(board)) {
                        System.out.println("No solution exists");
                    }
                }).start();
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(solveButton, BorderLayout.CENTER);

        jFrame.add(bottomPanel, BorderLayout.SOUTH);
    }

    public void updateBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col].setValue(board[row][col]);
            }
        }
        jFrame.repaint();
    }
}
