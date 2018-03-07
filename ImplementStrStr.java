/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
*/

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()){ //empty string will always be found at index 0
            return 0;
        }
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        
        //Start matching character from first index of haystack
        //If at any point mismatch found then break the loop and start matching again whole needle from next character in haystack
        for(int i=0; i<h.length;i++){ //start matching characters from 0th index
            int j;
            for(j=0; j < n.length; j++){ //match characters one by one 
                if((i+j) >= h.length || n[j] != h[i+j]){ //if any character is not matching, then break
                    break;   
                }
            }
            if(j == n.length){ //needle has been completely traversed, it means needle has been matched
                return i; //return index of first matching character
            }
        }
        
        return -1;
    }
}