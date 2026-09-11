class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int[] counter = new int[]{0};
        return removeHelper(head, n, counter);
    }

    private ListNode removeHelper(ListNode head, int n, int[] counter) {
        if (head == null) {
            counter[0] = 0;
            return null;
        }

        head.next = removeHelper(head.next, n, counter);
        
        counter[0]++;

        if (counter[0] == n) {
            return head.next;
        }

        return head;
    }
}
