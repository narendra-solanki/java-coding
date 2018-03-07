/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length -1;
        int s = -1, e = -1;
        //first search the target using simple binary search
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(nums[mid] == target){ //if target is found
                //now search array in left and right direction till duplicates value are found
                s = mid-1;
                e = mid+1;               
                while(s >= 0 && nums[s] == target){
                    s--;
                }
                
                while(e < nums.length && nums[e] == target){
                    e++;
                }
                //return the desired range
                return new int[] {++s,--e};
            }
            
            if(target > nums[mid]){
                lo = mid+1;
            } else {
                hi = mid-1;
            }
               
        }
        
        return new int[] {s,e};
        
    }
}