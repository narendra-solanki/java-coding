/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(p != null || stack.isEmpty() == false){
            //keep adding left childs in the stack
            while(p != null){
                //first keep visiting all left nodes
                list.add(p.val);
                stack.push(p);
                p = p.left;
            }
            //remove the node from stack to visit its right child
            p = stack.pop();            
            //now go to right node of the subtree to go to left of it in next iteration
            p = p.right;      
            
        }
        
        return list;
    }
}