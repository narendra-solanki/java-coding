/*
	Container With Most Water
	Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
	n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
	Find two lines, which together with x-axis forms a container, such that the container contains the most water.

	Note: You may not slant the container and n is at least 2.
*/

class Solution {    
    
    public int maxArea(int[] height) {
        //This is O(n)2 solution
        //First calculate for each height, find max rectangle this height can create, either on left or right
        //lowest height will create rectangle with every other height on the left or right
        int[] maxArea = new int[height.length];
        int max = 0;
        for(int i=0; i< height.length; i++){            
            int base = 0;
            for(int j=i-1; j >=0; j--){
                if(height[j] >= height[i]){ //if height greater or equal to this height is found then update the base width
                    base = i - j;
                } 
            }
            
            int leftArea = height[i] * base; //calculate area of rectangle in left side
            
            base = 0;            
            for(int j=i+1; j < height.length; j++){
                if(height[j] >= height[i]){  //if height greater or equal to this height is found then update the base width
                    base = j -i;
                } 
            }
            
            int rightArea =  height[i] * base; //calculate area of rectangle in right side
            maxArea[i] = Math.max(rightArea,leftArea); //max area will be maximum of left and right
            if(maxArea[i] > max){ //keep updating max area found till now
                max = maxArea[i];
            }
        }
        
        return max;
    }
}