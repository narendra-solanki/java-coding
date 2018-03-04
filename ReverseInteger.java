/*
	Given a 32-bit signed integer, reverse digits of an integer.

	Example 1:

	Input: 123
	Output:  321
	Example 2:

	Input: -123
	Output: -321
	Example 3:

	Input: 120
	Output: 21
	Note:
	Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.



*/
class Solution {
    public int reverse(int x) {
        if(x == 0){
            return 0;
        }
        int sign = x < 0 ? -1: 1;
        
        x = x * sign; //make the number positive
        
        int reverseNum = 0;
        while(x > 0){
            int digit = x % 10;            
            x = x/10;            
            
            //check if integer will overflow on next iteration
            if(Integer.MAX_VALUE/10 < reverseNum || (Integer.MAX_VALUE/10 == reverseNum && Integer.MAX_VALUE%10 < digit)){
                return 0;
            }
            
            reverseNum = reverseNum * 10 + digit;
            
        }
        
        return reverseNum * sign;       
              
        
    }
}