class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        // find length and tail
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        k = k % n;
        if (k == 0)
            return head;

        // make circular
        tail.next = head;

        // find new tail: n - k steps
        int steps = n - k;
        ListNode newTail = tail;
        while (steps-- > 0) {
            newTail = newTail.next;
        }

        // break circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
