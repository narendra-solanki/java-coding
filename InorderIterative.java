/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(p != null || stack.isEmpty() == false){
            //keep adding left childs in the stack
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            //visit the node
            p = stack.pop();
            list.add(p.val);
            //now go to right node of the subtree to go to left of it in next iteration
            p = p.right;      
            
        }
        
        return list;
    }
}