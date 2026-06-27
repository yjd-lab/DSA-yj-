import java.util.ArrayList;
import java.util.List;

class Solution {
    // Keep your exact validation logic
    private boolean issafe(char[][] board, int rows, int col, int n) {
        // 1. Check the horizontal row
        for (int j = 0; j < n; j++) {
            if (board[rows][j] == 'Q') {
                return false;
            }
        }

        // 2. Check the vertical column
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 3. Check Top-Left diagonal
        for (int i = rows, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 4. Check Top-Right diagonal
        for (int i = rows, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Keep your exact recursive backtracking logic
    private void nqueens(char[][] board, int row, int n, List<List<String>> ans) {
        if (row == n) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                res.add(new String(board[i]));
            }
            ans.add(res);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (issafe(board, row, j, n)) {
                board[row][j] = 'Q';             // 1. PLACE the Queen
                nqueens(board, row + 1, n, ans); // 2. RECURSE to the next row
                board[row][j] = '.';             // 3. BACKTRACK (Reset the cell)
            }
        }
    }

    // Renamed from solve to solveNQueens to match LeetCode's method signature
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        nqueens(board, 0, n, ans);
        return ans;
    }
}
