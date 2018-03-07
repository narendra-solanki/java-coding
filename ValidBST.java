/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
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
        Perform an inorder traversal of tree, add each number in the list
        List must be in sorted order for valid BST
    */
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for(int i=0; i < list.size() - 1; i++){
            //if any number is not sorted then tree is not valid BST
            if(list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        
        return true;
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);        
        inorder(root.right);
    }
}