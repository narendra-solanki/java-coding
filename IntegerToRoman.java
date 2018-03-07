/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

*/
class Solution {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuffer buf = new StringBuffer();
        for(int i=0; i < values.length; i++){
            while(num >= values[i]){ //reduce each number and append equivalent symbol in buffer
                num = num - values[i];
                buf.append(romans[i]);
            }
        }
        return buf.toString();
    }
}