/*
Problem:
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Input: arr[]   = {2, 0, 2}
Output: 2
Structure is like below
| |
|_|
We can trap 2 units of water in the middle gap.

Input: arr[]   = {3, 0, 0, 2, 0, 4}
Output: 10
Structure is like below
     |
|    |
|  | |
|__|_| 
We can trap "3*2 units" of water between 3 an 2,
"1 unit" on top of bar 2 and "3 units" between 2 
and 4.  See below diagram also.

Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Output: 6
       | 
   |   || |
_|_||_||||||
Trap "1 unit" between first 1 and 2, "4 units" between
first 2 and 3 and "1 unit" between second last 1 and last 2 
*/

public class TrappingRainWater{
	public int calculate(int[] elevations){
		/* 
		 * Idea is to find amount of water that can be trapped at a particular index
         * For all indexes, first find maxheight to the left and to the right including self height
         * Water trapped at any index will be (minheight(left, right) - height_at_index)
		*/
        int n = elevations.length;
        if(elevations == null || n <= 2){ //atleast 3 elevations are needed to trap water
            return 0;
        }
        
        //create left array to store highest element from the left, for every index
        int[] left = new int[n];
        left[0] = elevations[0];
        for(int i=1; i < n; i++){ //succesively compute max-height left to every element
            left[i] = left[i-1] > elevations[i] ? left[i-1]: elevations[i];
        }
        
        //create right array to store highest element from the right, for every index
        int[] right = new int[n];
        right[n-1] = elevations[n-1];
        for(int i=n-2; i >= 0; i--){ //succesively compute max-height right to every element
            right[i] = right[i+1] > elevations[i] ? right[i+1]: elevations[i];
        }
        
        //add water trapped at every height
        int water = 0;
        for(int i=0; i < elevations.length; i++){
            int lower = left[i] < right[i] ? left[i]: right[i];
            water+= lower-elevations[i];
        }
        
        return water;
	}
}