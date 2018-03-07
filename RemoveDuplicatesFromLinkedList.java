/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
        if(head == null)
            return head;
        ListNode p = head;
       
        while(p.next != null){            
            if(p.val == p.next.val ){ //next element has same value as this
                p.next = p.next.next; //delete duplicate node                
            } else { //advance pointer to next node only if it's not a duplicate
                 p = p.next;
            }           
            
        }
        return head;
        
    }
}