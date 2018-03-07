/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

class Solution {
    public boolean isPalindrome(String s) {
        /*
          Scan string from left and right simultaneously, scan till left and right pointers meet 
          If non alphanumeric character is found at any index, then increment that pointer
          If both chars are alphanumeric are they are not equal, return false
        */
        char[] str = s.toLowerCase().toCharArray();
        int i = 0, j = str.length-1;
        while(i <= j){
            if(isAlphaNumeric(str[i]) == false){
                i++; 
            } else if(isAlphaNumeric(str[j]) == false){
                j--; 
            } else {
                if(str[i]!=str[j]){
                    return false;
                } 
                
                i++;j--;
            }                     
        }
        
        return true;
        
    }
    
    boolean isAlphaNumeric(char c){
        if((c >= '0' && c <= '9') || (c>= 'a' && c<='z'))
            return true;
        return false;
    }
}