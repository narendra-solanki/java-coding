/*
Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the new length.
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        //start from 2nd index
        //if this element and previous element are equal
        // then: no need to advance newindex
        // else: store this element at newIndex 
        //This solution can be seen as if we are copying unique values in different array
        // but actual copying is in same array
        int newIndex = 1;
        int len = nums.length;
        
        if (len == 0 || len == 1)
            return len;
        
        for(int i=1; i<len; i++){
            if(nums[i] != nums[i-1]){ 
                //if values are same then newIndex will not advance
                //duplicate value will be eventually replaced with next element which is different
                nums[newIndex++] = nums[i];
            }
        }
        
        return newIndex;
    }
}