/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        
        //continue loop till tye end of the list
        while(cur != null && cur.next != null){            
            //if this node and next node are not duplicate, then move pointer
            if(cur.val != cur.next.val){
                cur = cur.next;
                pre = pre.next;
            } else {      
                //continue to move pointer till we reached last duplicate node
                while(cur.next != null && cur.val == cur.next.val){ 
                    cur = cur.next;
                    continue;
                }
                //now remove all duplicate nodes from the list
                pre.next = cur.next;
                //move current pointer by one
                cur = pre.next;
            }          
        }
        
        return dummy.next;
        
    }
}
