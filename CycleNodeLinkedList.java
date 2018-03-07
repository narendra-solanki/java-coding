/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //first check if there is a cycle or not
        ListNode slow = head;
        ListNode fast = head;
        
        //first detect if there is a cycle in linked list or not
        boolean cycleFound = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                cycleFound = true;
                break;
            }
        }
        
        //if no cycle found then return from this point
        if(cycleFound == false) return null;
        
        //now start from head and move slow pointer one by one
        ListNode start = head;
        while(start != slow){
            start = start.next;
            slow = slow.next;
        }
        
        return start;      
        
    }
}