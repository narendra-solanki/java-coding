/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
       
        ListNode pre = null;        
        ListNode cur = head;
        int count = 1;
        //reach the node just behind the (m)th node
        while(count < m){
            pre = cur;  
            cur = cur.next;
            count++;
        }      
        
        //save the position of node m and node before m
        ListNode nodeBeforeM = pre;     
        ListNode nodeM = cur;
        //now perform usual reversal of n-m+1 nodes
        while(count <= n){            
            ListNode next = cur.next;             
            cur.next = pre;
            pre = cur;
            cur = next;
            count++;
        }        
        
        //it means m is 1 and head should be the node last reversed
        if(nodeBeforeM == null){
            head = pre;
        } else { //else last reversed node should be placed at position m
            nodeBeforeM.next = pre;   
        }
        //node at mth position should reverse its direction and point to next node after n
        nodeM.next = cur;          
        
        return head;
    }
    
}