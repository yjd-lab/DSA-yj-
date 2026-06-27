class Solution {
    public boolean issafe(char[][] board, int row, int col, char digit){
        // 1. Check the horizontal row
        for(int j = 0; j < 9; j++){
            if(board[row][j] == digit){ // Fixed typo: changed dig to digit
                return false;
            }
        } 
        
        // 2. Check the vertical column
        for(int i = 0; i < 9; i++){
            if(board[i][col] == digit){ // Fixed typo: changed dig to digit
                return false;
            }
        }

        // 3. Check the 3x3 sub-box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == digit) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    // Helper method that returns a boolean to stop the recursion immediately once solved
    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                
                // Find an empty cell represented by '.'
                if (board[row][col] == '.') {
                    
                    // Try placing digits '1' through '9'
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (issafe(board, row, col, digit)) {
                            
                            board[row][col] = digit;           // 1. PLACE the digit
                            
                            if (solve(board)) {                // 2. RECURSE
                                return true; // If successful, keep the placement and propagate up
                            }
                            
                            board[row][col] = '.';             // 3. BACKTRACK (Reset if it failed)
                        }
                    }
                    
                    return false; // If no digit 1-9 fits in this empty cell, trigger backtracking
                }
            }
        }
        return true; // If no empty cells are left, the entire Sudoku puzzle is solved!
    }
}
