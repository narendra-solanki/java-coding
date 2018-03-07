/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.
*/
class Solution {
    public boolean search(int[] nums, int target) {
        //perform usual binary search method with some tweaks
        int lo = 0, hi = nums.length -1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(nums[mid] == target){ //if number found then return that index
                return true;
            }
            //No we will decide which half is uniformly sorted, i.e. pivoted element is in other half
            if(nums[hi] > nums[mid] ){ //it means right half of the array is in sorted order
                //now check if our target is in this half or not
                if(target > nums[mid] && target <= nums[hi]){ //target is in upper half
                     lo = mid+1;
                } else {
                    hi = mid -1;
                }
                    
            } else if(nums[hi] < nums[mid] ) { //it means left half of the array is in sorted order
                //now check if our target is in left half or not
                if(target < nums[mid] && target >= nums[lo]){ //target is in lower half
                     hi = mid-1;
                } else { 
                    lo = mid+1;
                }
            } else { //mid and hi elements are duplicates so reduce the search window
                hi--;
            }
        }  
        
        return false;
    }
}