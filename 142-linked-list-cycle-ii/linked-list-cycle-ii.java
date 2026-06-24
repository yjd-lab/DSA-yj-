public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Edge Case: An empty list or a list with only 1 node cannot have a cycle
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        
        // PHASE 1: Find if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Moves 1 step
            fast = fast.next.next;    // Moves 2 steps
            
            if (slow == fast) {       // They met! A cycle exists.
                hasCycle = true;
                break;                // Stop the loop immediately
            }
        }
        
        // If the loop finished and no cycle was found, return null
        if (!hasCycle) {
            return null;
        }
        
        // PHASE 2: Find the entry point of the cycle
        ListNode pointer1 = head;     // Reset pointer1 to the very start (head)
        ListNode pointer2 = slow;     // Keep pointer2 at the Phase 1 meeting point
        
        // Move both pointers 1 step at a time until they collide
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        
        // Return either pointer, as both are now pointing to the cycle entrance
        return pointer1;
    }
}
