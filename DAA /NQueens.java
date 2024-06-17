public class NQueens {
    private int[] x; // Array to store the positions of queens on the board
    private int n;   // Size of the chessboard

    // Constructor to initialize the board size
    public NQueens(int n) {
        this.n = n;
        x = new int[n + 1];
    }

    // Method to check if a queen can be placed at row k and column i
    private boolean place(int k, int i) {
        for (int j = 1; j < k; j++) {
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }

    // Method to solve the N-Queens problem using backtracking
    public void solveNQueens(int k) {
        for (int i = 1; i <= n; i++) {
            if (place(k, i)) {
                x[k] = i;
                if (k == n) {
                    printSolution();
                } else {
                    solveNQueens(k + 1);
                }
            }
        }
    }

    // Method to print the solution
    private void printSolution() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Main method to test the N-Queens problem solution
    public static void main(String[] args) {
        int n = 8; // Size of the chessboard
        NQueens nQueens = new NQueens(n);
        nQueens.solveNQueens(1);
    }
}
