/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"

*/

class Solution {
    public String countAndSay(int n) {               
        //keep first two outputs harcoded
        if(n == 1) return "1";
        if(n == 2) return "11";
        StringBuffer prev = null;
        StringBuffer cur = new StringBuffer("11");
        //start from 3rd sequence
        for(int i=3; i <= n; i++){
            prev = cur; //store saying till now in previous
            prev.append("$"); //increase length by one to run loop 1 extra time
            cur = new StringBuffer();//create a new buffer for next set of saying
            int cnt = 1;
            for(int j=1; j < prev.length();j++){ //iterate over previous saying to generate new saying 
                if(prev.charAt(j) == prev.charAt(j-1)){ //keep counting till previous character and this character matches
                    cnt++; 
                } else { //prev and this char did not match, append the say till now
                    String say = cnt+""+prev.charAt(j-1);
                    cur.append(say);       
                    cnt = 1; //reset the counter again
                }
            }            
        } 
        
        return cur.toString();
        
    }
}

