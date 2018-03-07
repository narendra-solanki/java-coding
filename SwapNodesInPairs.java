/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    //Need some serious work
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }      
        
        //create a dummy node and point it to the head
        ListNode d = new ListNode(-1);
        d.next = head;         
        
        //intialize current and previous pointers, prev will be dummy node and current will be head
        ListNode curr = head; 
        ListNode prev = d; 
        
        //We will split list in 4 parts
        //1. List before the current node
        //2. First node to be swapped
        //3. Second node to be swapped
        //4. Rest of the list
        
        //move forward only till there are atleast 2 nodes remaining
        while(curr != null && curr.next!=null){
            //store references of 2 nodes which needs swapping
            ListNode l1 = curr; 
            ListNode l2 = curr.next; 
            
            //store rest of the list
            ListNode rest = l2.next;
            
            //point previous list to second node, to make it next in the list
            prev.next = l2;
            //now second node should point to first node, to make it second
            l2.next = l1;
            //first node should point to rest of the list
            l1.next = rest;
            
            //update pointers for next pair of nodes
            prev = l1;
            curr = rest;            
        }
        
        return d.next;
    }
}