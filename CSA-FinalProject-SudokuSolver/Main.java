import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        int[][] puzzle = {
            {0, 4, 7, 0, 0, 3, 0, 0, 9},
            {0, 3, 0, 0, 9, 2, 4, 0, 0},
            {5, 0, 6, 4, 8, 7, 2, 0, 1},
            {4, 1, 2, 3, 0, 0, 7, 0, 0},
            {0, 0, 0, 0, 4, 0, 0, 0, 6},
            {0, 6, 5, 0, 0, 9, 3, 0, 0},
            {6, 0, 4, 0, 0, 0, 0, 8, 0},
            {0, 5, 3, 8, 6, 0, 0, 7, 0},
            {7, 0, 1, 9, 2, 5, 6, 4, 0}
        };
        SwingUtilities.invokeLater(() -> new SudokuGUI(puzzle));
    }
}
