/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

class Solution {
    public String multiply(String num1, String num2) {        
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        //length of multiplication of 2 numbers cannot be greater than len1+len2
        int[] products = new int[arr1.length + arr2.length];
        //start multiplying first string with second string, with one digit at a time in second string 
        for(int i = arr1.length-1; i>=0; i-- ){
            int d1 = arr1[i] - '0';
            for(int j=arr2.length-1; j>=0; j--){
                int d2 = arr2[j] - '0';
                //at each position store cumulative sum of products (just like multiplication with pen and paper)
                //we are not worrying about carry here
                products[i+j+1] = products[i+j+1] +  (d1*d2);
            }
        }
        
        //input carry
        int carry = 0;
        //now reduce each position to single digit by adding carry to next digit
        //we will replace each position with single digit 'modulus' value
        for(int i=products.length-1; i >= 0; i--){
            int p = (products[i]+carry)%10;
            //this will be forward carry
            carry = (products[i]+carry)/10;
            products[i] = p;
        }
        //there won't be any overflow carry, since product length cannot exceed sum of two lengths
        int index = 0;
        while(index < products.length && products[index] == 0){ //skip all leading zeroes
            index++;
        }
        StringBuffer buf = new StringBuffer();
        for(int i=index;i<products.length;i++){
            buf.append(products[i]);
        }
        if(buf.length() == 0){//if products is 0,then buffer will be empty
            return "0";
        }
        return buf.toString();
    }
}