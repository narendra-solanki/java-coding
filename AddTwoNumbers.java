/*
	You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

	You may assume the two numbers do not contain any leading zero, except the number 0 itself.

	Example

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	Explanation: 342 + 465 = 807.

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode p1 = l1; 
        ListNode p2 = l2;
        
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        //initial input carry is 0
        int carry = 0;
        //loop till both lists become null
        while( p1 != null || p2 != null )
        {
            //if any list become empty then assume value 0 at that place
            int val1 = p1 != null? p1.val : 0;
            int val2 = p2 != null? p2.val : 0;
            
            int sum = val1 + val2 + carry;
            
            //insert single digit only
            curr.next = new ListNode(sum%10);
            //determine output carry
            carry = sum/10;
            curr = curr.next;
            
            //advance lists only if list has more elements
            if(p1 != null)
            {
                p1 = p1.next;
            }
            
            if(p2 != null)
            {
                p2 = p2.next;
            }           
        }
        //last output carry
         if(carry > 0)
         {
             curr.next = new ListNode(carry);
         }
       
        return dummyHead.next;
        
    }   
    
}

