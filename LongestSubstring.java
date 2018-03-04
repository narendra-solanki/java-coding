/*
	Given a string, find the length of the longest substring without repeating characters.

	Examples:

	Given "abcabcbb", the answer is "abc", which the length is 3.

	Given "bbbbb", the answer is "b", with the length of 1.

	Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        /*
            Start scanning from left and keep storing character vs its index
            If duplicate character found, then mark its index and store number of chars till now as max length, and keep scanning
            If next duplicate character found then calculate length from last duplicate character till now and update max if length is greater than last length
            
        */
        int max=0,j=0;
        for(int i=0; i<str.length;i++){
            if(map.containsKey(str[i])){ //if a duplicate character is found
                int index = map.get(str[i]) + 1; //get the index of next character of the duplicate character
                if(index > j){
                    j = index; //only update if new index is greater than last stored index
                }                
            }
            map.put(str[i],i); //store index of each character
            int newLength = i - j + 1; //length from last duplicate character
            if(newLength > max){
                max = newLength;
            }           
        }
        
        return max;
        
    }
}