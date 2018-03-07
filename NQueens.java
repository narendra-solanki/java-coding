/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        
        List<List<String>> list = new ArrayList<>();
        
        placeQueen(board, 0, list);
        
        return list;     
    }
    
    /*
    	This method will add given configuration in the list
    */
    private List<String> addSolution(boolean[][] board){
        List<String> solution = new ArrayList<String>();  
        for(int i=0; i< board.length; i++){
            String row = "";
            for(boolean placed: board[i]){
                if(placed == true){
                    row+= "Q";
                } else {
                    row+= ".";
                }
            }
            solution.add(row);
        }
        
        return solution;
    }
    
    /*
        This method will keep adding solutions by placing queen in first column of each row.
        If we want to stop after first solution then check line 49
    */
    private boolean placeQueen(boolean[][] board, int col, List<List<String>> list){
        
        //recursive base case
        //We have reached beyond last column, it means we have placed all the queens
        if(col == board[0].length){
            list.add(addSolution(board)); //add this solution and move on
            return true;
        }
        //place 1 queen in every row
        for(int i=0; i<board.length; i++){
            
            //check if it is safe to place queen
            if(canPlace(board, i, col) == true){
                //place queen in this row
                board[i][col] = true;
                
                /*
                    This code will stop the program after first correct result is found
                    if(placeQueen(board, col+1, list) == true){
                        return true;
                    }
                */
                //now start placing in other rows and check if it leads to solution
                placeQueen(board, col+1, list); 
                //eventually this line will lead to solution but we will bactrack anyway to pursue other solutions
                
                //no solution it means backtrack from this position
                board[i][col] = false;
            }
            
        } 
        
        return false;
    }
    
    /*
        Check if queen can be placed in the position or not
        Since We have started to place queens from left side so no need to check right side of current column
    */    
    private boolean canPlace(boolean[][] board, int row, int col){
        //check in left side of this horizontal row
        for(int j=0; j<col; j++){
            if(board[row][j] == true){
                return false;
            }
        }
        
        //now check diagonaly upper side in the left
        for(int i=row, j=col; i >=0 && j>=0; i--, j--){
            if(board[i][j] == true){
                return false;
            }
        }
        
        //now check diagonaly lower side in the left
        for(int i=row, j=col; i < board.length && j>=0; i++, j--){
            if(board[i][j] == true){
                return false;
            }
        }
        
        //no conflicting position found
        return true;
    }
}