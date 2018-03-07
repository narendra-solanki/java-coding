/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        //calculate area for which each height can contribute
        /*
            This is O(n2) solution
            To find how much area can this index contribute
                search array till left heights are equal or greater than this height and add the area
                search array till right heights are equal or greater than this height and add the area
                update the maxArea
        */
        for(int i=0; i< heights.length; i++){            
            int height = heights[i];
            int tempArea = height;
            for(int j=i-1;j>=0;j--){
                if(heights[j] >= height){
                    tempArea+= height;
                } else {
                    break;
                }
            }
            for(int j=i+1;j<heights.length;j++){
                if(heights[j] >= height){
                    tempArea+= height;
                } else {
                    break;
                }
            }
            //System.out.println("Index " + i + ": " + tempArea);
            if(tempArea > maxArea){
                maxArea = tempArea;
            }            
        }
        return maxArea;
    }
    
}