class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // Break the link between first and second halves
        
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        // Step 3: Merge/Weave the two sorted halves together
        ListNode first = head;
        ListNode second = prev; // 'prev' is the head of the reversed second half
        
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            
            first.next = second;
            second.next = temp1;
            
            first = temp1;
            second = temp2;
        }
    }
}
