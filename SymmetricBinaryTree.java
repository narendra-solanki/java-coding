/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
        /*
            A tree is symmetric if following conditions are met
            1. Root node's value should be same
            2. Left subtree of left and right subtree of right are symmetric
            3. Right subtree of left and left subtree of right are symmetric
        */
        return isMirror(root, root);
    }
    
    private boolean isMirror(TreeNode r1, TreeNode r2){
        //if both of them are null then return false
        if(r1 == null && r2 == null){
            return true;
        }
        //if only one of them is null then return false
        if(r1 == null || r2 == null){
            return false;
        }
        
        //if values are different then return false
        if(r1.val != r2.val){
            return false;
        }
        //check if step 2 and step 3 satisfies
        return isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left);
    }
}