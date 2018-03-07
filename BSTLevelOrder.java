/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        //Create a queue to store all elements at the same level
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);        
        
        while(q.isEmpty() == false){
            //List for each level
            List<Integer> level = new LinkedList<>();
            //For every element in this level, add element in the level list
            //All element added in queue in this loop will be traversed in next loop 
            //size of queue must be saved first, since it will keep growing
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode n = q.remove();
                level.add(n.val);
                if(n.left != null){
                    q.add(n.left);
                }

                if(n.right != null){
                    q.add(n.right);
                }
            }
            
            list.add(level);
        }
        
        return list;
    }
}