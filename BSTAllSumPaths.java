/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    
    ArrayList<Integer> stack = new ArrayList<Integer>(); 
    List<List<Integer>> finallist;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        finallist = new ArrayList<>();
        hasPathSum(root, sum);
        return finallist;
    }
    
    /*
        Use Preorder traversal
        Keep adding nodes in stack as and when encountered, in preorder fashion
        When leaf node is found
            - if pathSum is found
                - Add all nodes till now from stack in a temp list
                - add this list to final list
                - remove node from stack
            - else
                check in left list
                check in right list
        After visiting both left and right children, we will be visiting ancestor of parent(for next path),
        so remove the parent node from stack
    */
    public void hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return;
        }
        
        stack.add(root.val);
        int value = sum - root.val;
        //leaf node
        if(root.left == null && root.right == null && value == 0){
            List<Integer> list = new ArrayList<>();
            for(int num : stack){
                list.add(num);
            }
            finallist.add(list);
            stack.remove(stack.size()-1);    
            return;
        } else {
             hasPathSum(root.left, value);
             hasPathSum(root.right, value);
        }       
        
        stack.remove(stack.size() - 1);
        
    }    
    
}