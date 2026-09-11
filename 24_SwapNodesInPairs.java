class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode previous = head;
        ListNode current = head.next;
        ListNode connection = dummy;

        while (previous != null && current != null) {
            connection.next = current;
            previous.next = current.next;
            current.next = previous;

            connection = previous; 
            previous = previous.next;
            if (previous != null) {
                current = previous.next;
            }
        }

        return dummy.next;
    }
}
