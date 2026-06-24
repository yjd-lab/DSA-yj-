class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        // 1. Move fast pointer N steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // 2. Move both together until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // 3. Skip the Nth node
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
