/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
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
    
    //Recursive solution
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {        
        
        if(l1 == null){
            return l2;
        }
        
        if(l2 == null){
            return l1;
        }
        
        ListNode result = null;
        
        if(l1.val <= l2.val){
            result = l1;
            result.next = mergeTwoLists(l1.next,l2);
        } else {
            result = l2;
            result.next = mergeTwoLists(l1,l2.next);
        }
        
        return result;        
    }
    
    //Non recursive solution
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        
        if(l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = dummy;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        
         if(p1 != null){
             p3.next = p1;             
         }
        
         if(p2 != null){
             p3.next = p2;            
         }
        
        return dummy.next;
        
        
    }
}