/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.

*/

class Solution {
    
    private char marker = '.';
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    /*Steps
    1. First get unassigned locations, if no unassigned location then sudoku is solved
    2. Check if unassigned location can be assigned with any number, one by one
    3. if location can be assigned with a number then assign the number and start filling succesive locations 
    4. else backtrack and try with next numbers that can be assigned
    
    */
    private boolean solve(char[][] board){
        //find unassigned location 
        boolean isSolved = true;
        int row = -1, col = -1;
        for(int i=0; i < 9; i++){
            for(int j=0; j < 9; j++){
                if(board[i][j] == marker){
                    row = i; col = j;
                    isSolved = false;
                }                    
            }
        }
        if(isSolved == true){
            return true;
        }
        
        for(char num='1'; num <= '9'; num++){
            if(isSafeToAssign(board,row,col,num) == true){
                //tentatively assign the number at location
                board[row][col] = num;
                
                //now fill succesive positions
                if(solve(board) == true){
                    return true;
                }
                
                board[row][col] = marker;
                
            }
        }
        return false;
    }
    
    private boolean isSafeToAssign(char[][] board, int row, int col, char num ){
        if(usedInRow(board, row, num) == true ||
          usedInCol(board, col, num) == true ||
          usedInBox(board, row-row%3, col-col%3, num) == true){
            return false;
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