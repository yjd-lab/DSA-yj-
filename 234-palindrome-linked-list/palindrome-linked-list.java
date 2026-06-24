class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        // Step 1: Find the middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half
        ListNode prev = null;
        ListNode curr = slow; // Start reversing from the middle node
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        // Step 3: Compare both halves
        ListNode firstHalf = head;
        ListNode secondHalf = prev; // Head of the reversed second half
        
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false; // Mismatch found! Not a palindrome.
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true; // All values matched perfectly
    }
}
