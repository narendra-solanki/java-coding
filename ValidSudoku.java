/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check if assignment in every row is valid
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char c = board[i][j];
                if(c == '.'){
                    continue;
                } 
                board[i][j] = '*'; //mark this position as being checked to bypass checking the character with this position
                if(usedInRow(board, i, c) == true ||
                  usedInCol(board,j,c) == true ||
                  usedInBox(board, i-i%3, j-j%3, c) == true){
                    board[i][j] = c;
                    return false;
                }
                board[i][j] = c;
            }
        }
        
        return true;
    }
    
    private boolean usedInRow(char[][] board, int row, char c){
        for(int col = 0; col < 9; col++){
            if(board[row][col] == c){
                return true;
            }
                
        }
        return false;
    }
    
    private boolean usedInCol(char[][] board, int col, char c){
        for(int row = 0; row < 9; row++){
            if(board[row][col] == c){
                return true;
            }
                
        }
        return false;
    }
    
    private boolean usedInBox(char[][] board, int startRow, int startCol, char c){        
        for(int i=0; i < 3; i++){
            for(int j=0; j < 3; j++){
                if(board[i+startRow][j+startCol] == c)
                    return true;
            }
        }
        return false;        
    }
}