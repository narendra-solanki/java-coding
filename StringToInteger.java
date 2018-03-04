/*
	Implement atoi to convert a string to an integer.
	
	The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

	The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

	If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

	If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

*/
class Solution {
    public int myAtoi(String str) {
        str = str.trim(); 
        int sign = 1;       
        int number = 0;
        
        if(str.length() == 0){
            return 0;                      
        }
        for(int i=0; i < str.length(); i++){
            char c = str.charAt(i);
            if(i==0 && (c== '+' || c=='-')){                
                sign = (c == '-')? -1: 1;  
                continue;
            }
            //System.out.println(sign);
            int digit = c - '0';//System.out.println(digit);
            if(digit < 0 || digit > 9 ){
                break;
            }
            //check if integer overflows after next iteration
            if(Integer.MAX_VALUE/10 < number ||  (Integer.MAX_VALUE/10 == number && Integer.MAX_VALUE%10 < digit)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            number = number * 10 + digit;
        }        
        
        return number * sign;
    }
}