public class SudokuSolver {
    private int[][] sudokuTable;

    public static void main(String[] args) {
        SudokuSolver unsolvedSudoku = new SudokuSolver();
        unsolvedSudoku.solve();
    }

    public SudokuSolver() {
        sudokuTable = new int[][] {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
    }

    public boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sudokuTable[row][col] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (isValid(row, col, number)) {
                            sudokuTable[row][col] = number;
                            if (solve()) {
                                return true;
                            } else {
                                sudokuTable[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (sudokuTable[row][i] == number || sudokuTable[i][col] == number) {
                return false;
            }
        }
        int localBoxRow = row - row % 3;
        int localBoxCol = col - col % 3;
        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxCol; j < localBoxCol + 3; j++) {
                if (sudokuTable[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }
}
