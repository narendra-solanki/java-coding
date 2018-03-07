/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        //pickup the first string and compare it with second string 
        //to check if it is substring
        //keep reducing the size of the first string by one after each loop/
        //repeat same steps with other strings till common string among all strings is found
        if(strs == null || strs.length == 0){
            return "";
        } 
        String prefix = strs[0];
        for(int i=1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){ //find common prefix with each string
                prefix = prefix.substring(0, prefix.length() - 1);
            }            
        }
        return prefix;
    }
}