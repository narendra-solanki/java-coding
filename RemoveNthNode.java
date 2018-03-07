/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
            Maintain two pointers, one pointer n steps behind another 
            Iterate over list with fast pointer and keep count of nodes so far
            when count == n, start iterating with slow pointer
            Keep moving forward(advance both fast and slow) one step at a time while fast.next is not null
            delete the node pointed by slow.next
        */
        if(head == null) return null;
        //Create a dummy node to store the list
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i=1; i < n+1; i++){ //move fast pointer n steps ahead
            if(fast == null){
                return null;
            }
            fast = fast.next;
        }
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }        
        slow.next = slow.next.next;  
        
        return dummy.next;
    }
}