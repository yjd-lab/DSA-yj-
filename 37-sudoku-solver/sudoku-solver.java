class Solution {
    public boolean issafe(char[][] board, int row, int col, char digit){
        // 1. Check the horizontal row
        for(int j = 0; j < 9; j++){
            if(board[row][j] == digit){ 
                return false;
            }
        } 
        
        // 2. Check the vertical column
        for(int i = 0; i < 9; i++){
            if(board[i][col] == digit){ 
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
        // Start the recursion at the very first cell: row 0, col 0
        solve(board, 0, 0);
    }

    // Helper method using your cell-by-cell approach
    private boolean solve(char[][] board, int row, int col) {
        // Base Case: If we successfully pass row 8 (index 9), the entire board is full
        if(row == 9){
            return true;
        }
        
        // Calculate the next cell coordinates
        int nextrow = row;
        int nextcol = col + 1;
        if(nextcol == 9){ // Fixed typo: nectcol to nextcol
            nextrow = row + 1;
            nextcol = 0;
        }
        
        // If the current cell already has a fixed clue number, skip it and move on
        if(board[row][col] != '.'){
            return solve(board, nextrow, nextcol); // Fixed: changed 'helper' to 'solve'
        }

        // Try placing digits '1' through '9' in the empty cell
        for (char digit = '1'; digit <= '9'; digit++) {
            if (issafe(board, row, col, digit)) {
                
                board[row][col] = digit; // 1. PLACE the digit
                
                // 2. RECURSE to the next cell calculated above
                if (solve(board, nextrow, nextcol)) { 
                    return true; 
                }
                
                board[row][col] = '.';   // 3. BACKTRACK (Reset if it failed)
            }
        }
        
        return false; // Triggers backtracking if no digit 1-9 works here
    }
}
