/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(digits[n-1] < 9){
            digits[n-1]++;
            return digits;
        }
        
        int i = n-1;
        while(i >= 0 && digits[i] == 9){
            digits[i--] = 0;
        }
        if(i >= 0){
            digits[i]++;
            return digits;
        } else {
            
            int[] arr = new int[n+1];
            arr[0] = 1; //all other digits are by default 0            
            return arr;
        }        
        
    }
}