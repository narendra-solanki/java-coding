/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    
    /*
        Perform a preorder traversal
        if node is leaf node then return sum till now else
        find sum in left and right sub tree with current sum as parameter
    */
    public int sumNumbers(TreeNode root) {
        return rootToLeaf(root, 0);        
    }
    
    private int rootToLeaf(TreeNode root, int sum){
        if(root == null) return 0;
        
        int curSum = sum*10 + root.val;
        
        if(root.left == null && root.right == null){
            return curSum;
        }
        int left  = rootToLeaf(root.left, curSum);
        int right = rootToLeaf(root.right, curSum);
        return  left + right;     
    }
}