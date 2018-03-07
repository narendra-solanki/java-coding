/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
class Solution {
    public String addBinary(String a, String b) {       
        int al= a.length();
        int bl= b.length();
        
        //first make both strings equal by prepending 0s in shorter string
        if(al < bl){
            StringBuffer sa = new StringBuffer();
            int diff = bl-al;
            while(diff > 0){
                sa.append("0");
                diff--;
            }
            a = sa.toString()+a;
        } else if(bl < al) {
            StringBuffer sb = new StringBuffer();
            int diff = al-bl;
            while(diff > 0){
                sb.append("0");
                diff--;
            }
            b = sb.toString()+b;
        }          
        
        int index = a.length()-1;
        StringBuffer buf = new StringBuffer();
        int carry = 0;
        while(index >= 0){
            int ai = Integer.parseInt(a.charAt(index)+"");
            int bi = Integer.parseInt(b.charAt(index)+"");
            
            //full adder logic, add two bits plus input carry bit
            int result = ai ^ bi ^ carry; 
            carry = (ai & bi) | (bi & carry) | (carry & ai);
            buf.append(result);
            index--;
        }
        if(carry == 1){
            buf.append(1);
        }        
                
        return buf.reverse().toString();
        
    }
}