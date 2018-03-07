/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
*/
class Solution {
    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry 
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
    */
    public void rotate(int[][] matrix) {
        //first swap rows from top to bottom, i.e. 1 with n, 2 with n-1 and so on
        for(int j=0; j < matrix[0].length; j++){
            int i=0;
            int k = matrix.length -1;
            //swap the elements in column j
            while(i < k){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[k][j];
                matrix[k][j] = tmp;
                i++; k--;
            }            
        }
        
        //now swap elements diagonally
        for(int i=0; i< matrix.length; i++){
            for(int j = i+1; j<matrix[0].length; j++ ){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}