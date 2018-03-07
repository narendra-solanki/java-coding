/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

class Solution {
    public int romanToInt(String s) {
        char[] numerals = s.toCharArray();
        int[] nums = new int[numerals.length];
        for(int i=0; i < numerals.length; i++){
            switch (numerals[i]){ //convert each roman numeral to its equivalent decimal
            case 'M':
                nums[i]=1000;
                break;
            case 'D':
                nums[i]=500;
                break;
            case 'C':
                nums[i]=100;
                break;
            case 'L':
                nums[i]=50;
                break;
            case 'X' :
                nums[i]=10;
                break;
            case 'V':
                nums[i]=5;
                break;
            case 'I':
                nums[i]=1;
                break;
            }           
        }
        int sum = 0;
            
        for(int i=0; i < nums.length-1; i++){
            //if first character in pair is smaller then subtract first number from final sum
            //e.g. IV will be calculated as -1+5 = 4, in two iterations
            if(nums[i] < nums[i+1]){ 
                sum = sum - nums[i];
            } else {//else just add the decimal equivalent in final sum
                sum = sum + nums[i];
            }
        }
        
        return sum + nums[nums.length -1];
    }
}