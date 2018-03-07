/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

class Solution {    
    /*
        Logic:
        1. null and empty strings are valid
        2. if string length is odd the return false
        3. iterate through each character
        3. push any opening character in stack
        4. if closing character found then pop and check if matching character is in stack
        5. return true if stack is empty at the end
    */
    public boolean isValid(String s) {
        //null or empty strings are valid string
        if(s == null || s.length() == 0){
            return true;
        }
        //first check the length of the string
        if(s.length()%2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();    
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else if(stack.isEmpty() == true) {
                return false;
            } else {
                char ch = stack.pop();
                if(!((ch == '(' && c ==')') || (ch == '{' && c =='}') || (ch == '[' && c ==']'))){
                        return false;
                    }
            }
        }
        
        return stack.isEmpty();       
    }              
}