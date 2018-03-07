/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
    public int minDepth(TreeNode root) {
        //this will be called only if root is null
        if(root == null) return 0;
        
        //this is base case for recursion, will executed for leaf node
        if(root.left == null && root.right == null){
            return 1;
        }
        
        //return height of right subtree
        if(root.left == null) {
            return 1+ minDepth(root.right);
        }
        
        //return height of left subtree
        if(root.right == null) {
            return 1+ minDepth(root.left);
        }
        
        //return minimum of left height or right height
        return 1 + Math.min(minDepth(root.right),minDepth(root.left));
        
    }
}