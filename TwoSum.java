/*
	Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution, and you may not use the same element twice.

	Example:
	Given nums = [2, 7, 11, 15], target = 9,

	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] larrResult = new int[2];
        int liCurrentIndex = 0;
        if(nums.length == 1)
        {
            if(nums[0] == target)
            {
                larrResult[0] = liCurrentIndex;  
                return larrResult;
            }                
        }
        
        if(nums.length < 2)
            return null;
        
        boolean lbFound = false;
        
        while(!lbFound)
        {            
            for(int liIndex = liCurrentIndex+1; liIndex<nums.length; liIndex++)
            {
                if(nums[liCurrentIndex] + nums[liIndex] == target)
                {
                    larrResult[0] = liCurrentIndex;
                    larrResult[1] = liIndex;
                    return larrResult;
                }
            }
            liCurrentIndex++;
        }   
        
        
        return null;
    }
}