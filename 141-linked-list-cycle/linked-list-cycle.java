/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 1. Check for empty or single-node lists. 
// If there are 0 or 1 nodes, they cannot form a loop.
if (head == null || head.next == null) return false;

// 2. Put both runners at the starting line (the head node).
ListNode slow = head;
ListNode fast = head;

// 3. Keep running AS LONG AS the fast runner hasn't hit the end of the track.
while (fast != null && fast.next != null) {
    
    slow = slow.next;         // 🐢 Tortoise takes 1 step ahead
    fast = fast.next.next;    // 🐇 Hare takes 2 steps ahead
    
    // 4. Check if the Hare just caught up to the Tortoise from behind.
    if (slow == fast) {       
        return true;          // Found a loop!
    }
}

// 5. If the while loop finishes, it means 'fast' hit null.
return false;                 // Track ended, no loop found.

    }
}