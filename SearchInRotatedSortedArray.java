/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
class Solution {
    public int search(int[] nums, int target) {
        //perform usual binary search method with some tweaks
        int lo = 0, hi = nums.length -1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(nums[mid] == target){ //if number found then return that index
                return mid;
            }
            //No we will decide which half is uniformly sorted, i.e. pivoted element is in other half
            if(nums[hi] > nums[mid] ){ //it means right half of the array is in sorted order
                //now check if our target is in this half or not
                if(target > nums[mid] && target <= nums[hi]){ //target is in upper half
                     lo = mid+1;
                } else {
                    hi = mid -1;
                }
                    
            } else { //it means left half of the array is in sorted order
                //now check if our target is in this half or not
                if(target < nums[mid] && target >= nums[lo]){ //target is in lower half
                     hi = mid-1;
                } else { 
                    lo = mid+1;
                }
            }
        }  
        
        return -1;
    }
}