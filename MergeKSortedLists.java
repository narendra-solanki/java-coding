/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        //merge lists recursively, 2 at a time
        int last = lists.length - 1;
        
        while(last != 0){
            int i=0, j = last; //values of last will be last,last/2,last/4,last/8 and so on, if it hasn't become 0 in the loop 
            //lists elements will be merged in first half
            while(i < j){
                lists[i] = merge2Lists(lists[i],lists[j]);
                i++; j--;
                // If all pairs are merged, update last
                if (i >= j) //now start merging first half, and so on
                    last = j;
            }
        }        
        
        return lists[0];
        
    }
    
    //recursive method to merge two sorted lists
    private ListNode merge2Lists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode result = null;
        if(l1.val <= l2.val){
            result = l1;
            result.next = merge2Lists(l1.next,l2);
        } else {
            result = l2;
            result.next = merge2Lists(l1, l2.next);
        }
        
        return result;
    }
}