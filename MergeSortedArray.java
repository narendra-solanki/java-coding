/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //start merging from the end,
        //since there is enough space for both arrays in nums1, there will be no overwrite of values
        int i = m-1, j = n -1, k = m+n-1;
        //start comparing from the end, consider nums1 as third array
        while(i >=0 && j >=0){
            nums1[k--] = nums1[i] > nums2[j]? nums1[i--]:nums2[j--]; //assign greater number at the end
        }
        //we need to arrange only remaining elements from nums2 if any
        //because if nums1 has more elemnts then they are already there in sorted order
        //if nums2 has more elemnts then they simply need to be copied
        while(j>=0){
            nums1[k--] = nums2[j--]; 
        }
    }
}