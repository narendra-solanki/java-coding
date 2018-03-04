/*
	Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

	Example:

	Input: "babad"

	Output: "bab"

	Note: "aba" is also a valid answer.
	 

	Example:

	Input: "cbbd"

	Output: "bb"

*/
class Solution {
    
    private int start;
    private int maxLength;
    public String longestPalindrome(String s) {
        /*
            Assuming each character as mid character, check if left and right substrings are part of palindrome
            Keep looking from this character till palindrome is not found
        */
        if(s == null || s.trim().length() < 2){
            return s;
        }
        
        char[] str = s.toCharArray();
        for(int i=0; i < str.length; i++){
            //for odd length strings
            checkPalindrome(str, i,i); 
            
            //for even length strings
            checkPalindrome(str, i,i+1); 
        }
        
        //return maximum palindrome string
        return s.substring(start, start+maxLength);
    }
    /**
        Extend palindrome on both sides and compute length
    */
    private void checkPalindrome(char[] str, int left, int right){
        while(left >= 0 && right < str.length && str[left] == str[right]){
            left--;
            right++;
        }
        
        int len = right - left - 1;
        if(len > maxLength){
            start = left + 1;
            maxLength = len;
        }
    }
}