/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
*/
class Solution {
    
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        
        //keep track of min value seen so far 
        //find difference between current element and min element so far
        //Max difference will be our answer
        int minTillNow = prices[0];      
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] > minTillNow){
                maxProfit = Math.max(maxProfit, prices[i] - minTillNow);
            } else {
                minTillNow = prices[i];
            }
            
        }      
       
        return maxProfit;
    }
    //This is O(n) solution
    //This same solution applies to trapping rain water problem
    public int maxProfit1(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        
        //find the min value at each point
        int[] left = new int[prices.length];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            min = Math.min(prices[i], min);
            left[i] = min;
        }
        
        //find max value at each point
        int[] right = new int[prices.length];
        int max = Integer.MIN_VALUE;
        for(int i=prices.length-1; i>=0; i--){
            max = Math.max(prices[i], max);
            right[i] = max;
        }
        
        //max profit will be max difference between max and min values 
        int maxprofit = 0;
        for(int i=0; i<prices.length; i++){
            maxprofit = Math.max(maxprofit, right[i] - left[i]);
        }
        
        
        return maxprofit;
    }
    
    //this is O(n)2 solution
    public int maxProfit2(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int diff = prices[1] - prices[0];
        
        int maxProfit = diff;
        //iterate all the elements and find maximum difference
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j < prices.length; j++){
                int d = prices[j] - prices[i];
                maxProfit = Math.max(d,maxProfit);                
            }            
        }
        
        return maxProfit > 0? maxProfit: 0;
    }
}