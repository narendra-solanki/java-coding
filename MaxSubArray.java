/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //keep track of maxsum till now
        //keep updating maximum sum value
        int maxSum = nums[0];
        int maxTillNow = nums[0];
        for(int i=1; i < nums.length; i++){
            //maximum sum till now will be either (this number), or (sum till now + this number)
            maxTillNow = Math.max(maxTillNow + nums[i], nums[i]);
            maxSum = Math.max(maxTillNow, maxSum);
        }
        
        return maxSum;
    }
}