/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
    /*
        First reach to the middle of the list
    */
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        
        //take slow pointer to mid point of the list
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        ListNode first = head;
        //now reverse the second half of the list
        ListNode second = reverse(slow);
        
        //now add nodes to first list, from second list at alternate positions
        while(first.next != null && second.next != null){
            ListNode fNext = first.next;
            first.next = second;            
            first = fNext;
            ListNode sNext = second.next;
            second.next = fNext;
            second = sNext;
        }
    }
    
    //Reverse the list starting from node start
    private ListNode reverse(ListNode start){
        ListNode pre = null;
        ListNode cur = start;
        
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        return pre;
    }
}