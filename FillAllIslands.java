/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

class Solution {
    /*        
        First we need to find out all the regions which are on the edges, since these regions should not be changed
        1. Replace all O's to some marker character say '-'
        2. Flood fill all the points on edges, replacing '-' with O's
        3. Now replace all remianing '-' with X
        
    */
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        //replace all O's with a marker '-'
        replaceAll(board, 'O','-');
        
        int rows = board.length;
        int cols = board[0].length;
        
        //convert all contiguous regions starting from top edge to 'O'
        for(int j=0; j < cols ; j++){
            if(board[0][j] == '-'){
                floodFill(board, 0, j, '-','O');
            }
        }
        
        //convert all contiguous regions starting from bottom edge to 'O'
        for(int j=0; j < cols ; j++){
            if(board[rows-1][j] == '-'){
                floodFill(board, rows-1, j, '-','O');
            }
        }
        
        //convert all contiguous regions starting from left edge to 'O'
        for(int i=0; i < rows ; i++){
            if(board[i][0] == '-'){
                floodFill(board, i, 0, '-','O');
            }
        }
        
        //convert all contiguous regions starting from right edge to 'O'
        for(int i=0; i < rows ; i++){
            if(board[i][cols-1] == '-'){
                floodFill(board, i, cols-1, '-','O');
            }
        }
        
        //Now replace all remaining '-' to 'X'
        replaceAll(board, '-','X');
    }
    
    //Flood fill all contiguous area wth same character
    private void floodFill(char[][] board, int i, int j, char oldChar, char newChar){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }
        
        if(board[i][j] != oldChar) return;
        board[i][j] = newChar;
        floodFill(board,i,j+1,oldChar,newChar); //go right
        floodFill(board,i+1,j,oldChar,newChar); //go down
        floodFill(board,i,j-1,oldChar,newChar);//go left
        floodFill(board,i-1,j,oldChar,newChar);//go up
    }
    
    //Replace all oldChars to newChars on the board
    private void replaceAll(char[][] board, char oldChar, char newChar){
        for(int i=0; i<board.length; i++){
            for(int j=0; j <board[0].length; j++){
                if(board[i][j] == oldChar){
                    board[i][j] = newChar;
                }
            }
        }
    }
}