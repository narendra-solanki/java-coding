/*
Determine whether an integer is a palindrome. Do this without extra space.
*/

class Solution {
    public boolean isPalindrome(int x) {
        //negative numbers cannot be palindrome number
        //multiple of 10(number ending with 0) except 0 cannot be palindrome
        if((x < 0) || (x!=0 && x%10 == 0)){
            return false;
        }
        
        //create reverse number only till original number is greater than reverse number
        //loop only till half number of digits
        int rev = 0;
        while(x > rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }
}