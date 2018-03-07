/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
 
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        //perform binary search to pick mid elements and create a tree
        if(nums == null || nums.length == 0){
            return null;
        }
        
        return createTree(nums, 0, nums.length - 1);
    }
    
    TreeNode createTree(int[] nums, int low, int hi){        
        if(low > hi){
            return null;
        }
        int mid = low + (hi-low)/2; //to avoid integre overflow
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums, low, mid-1);
        root.right = createTree(nums,mid+1,hi);
        return root;        
    }
}