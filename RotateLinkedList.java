/*
Given a list, rotate the list to the right by k places, where k is non-negative.


Example:

Given 1->2->3->4->5->NULL and k = 2,

return 4->5->1->2->3->NULL.
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
        First find the length of the list and take fast pointer till the last node
        Check if k is greater than count then, adjust k by taking modulus i.e. k = k%count
        Start moving slow pointer till (count - k) steps so that it is k steps behind fast pointer
        Now change pointers of nodes as desired
        
    */
    public ListNode rotateRight(ListNode head, int k) {
        //if list have fewer than 2 elements then no rotation is possible
        if(head == null || head.next == null) return head;
        
        //create a dummy Node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;  
        
        //assign fast node as dummy next element(whch is head)
        ListNode fast = dummy;
        int count = 0;
        //first count all the nodes and move fast pointer to last node
        while(fast.next != null){
            fast = fast.next;
            count++;
        }
        //adjust k if k is greater than length of the list
        k = k%count;        
        
        //Now start moving slow pointer which is k steps behind fast pointer
        ListNode slow = dummy;
        for(int i=0; i < count-k; i++){
            slow = slow.next;
        }          
        
        //make last node point to head
        fast.next = dummy.next;  
        //make next element of slow as the head
        dummy.next = slow.next;
        //make slow as the last elemnt of the list
        slow.next = null;
        
        return dummy.next;
        
    }
}
