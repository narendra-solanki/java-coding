/*
	There are two sorted arrays nums1 and nums2 of size m and n respectively.

	Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

	Example 1:
	nums1 = [1, 3]
	nums2 = [2]

	The median is 2.0
	Example 2:
	nums1 = [1, 2]
	nums2 = [3, 4]

	The median is (2 + 3)/2 = 2.5

*/
class Solution {
    /**
        1. merge two sorted array using and auxillary array
        2. if sum of lengths of both array is odd than pick mid-index
        3. if sum of lengths of both array is even than pick average of mid-index and mid-index+1
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        if((length1+length2) == 0) return 0;        
        
        int oddIndex = -1;
        if((length1+length2) % 2 == 1){ //odd number
            oddIndex = (length1+length2)/2;
        }
        int evenIndex = -1;
        if(oddIndex == -1){
            evenIndex = (length1+length2)/2 -1;
        }
        
        int[] comArr = new int[length1+length2];        
        int i = 0, j=0, k=0;
        while(i < length1 && j < length2){
            if(nums1[i] < nums2[j]){
                comArr[k++] = nums1[i++];
            } else{
                 comArr[k++] = nums2[j++];
            } 
            
            if(isHalfWay(k, oddIndex, evenIndex) == true) break;
        }
        
        while(i < length1){
            comArr[k++] = nums1[i++]; 
            if(isHalfWay(k, oddIndex, evenIndex) == true) break;
        }
        
        while(j < length2){
            comArr[k++] = nums2[j++]; 
            if(isHalfWay(k, oddIndex, evenIndex) == true) break;
        }
        
        if(oddIndex != -1){
            return comArr[oddIndex];
        } else {
            return (comArr[evenIndex] + comArr[evenIndex+1])/2.0;
        }
            
    }
    
    private boolean isHalfWay(int k, int oddIndex, int evenIndex){
        if(k > oddIndex && k > evenIndex+1) return true;
        return false;
    }
}