/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }
        /*
         * ListNode prev = null;
         * ListNode current = head;
         * 
         * 
         * while(current.next != null){
         * prev = current ;
         * current = current.next;
         * 
         * if(prev.val == current.val){
         * delete(current , head);
         * }
         * }
         * return head;
         */

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /*
     * public void delete(ListNode node , ListNode head){
     * ListNode temp = head ;
     * 
     * while(temp.next != node){
     * temp =temp.next;
     * }
     * 
     * temp.next = node.next;
     * 
     * }
     */
}