/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);  // Extra node for conveninence
        ListNode current = result;
        
        int d1 = 0, d2 = 0, digit = 0;
        boolean carryFlag = false;
        
        // While a new digit is available
        while (l1 != null || l2 != null || carryFlag) {
            d1 = 0;
            d2 = 0;
            
            // Fetch digit in l1
            if (l1 != null) {
                d1 = l1.val;
                l1 = l1.next;
            }
            
            // Fetch digit in l2
            if (l2 != null) {
                d2 = l2.val;
                l2 = l2.next;
            }
            
            digit = d1 + d2 + (carryFlag ? 1 : 0);
            
            // If the digit exceeds 10 (carry)
            carryFlag = false;
            if (digit >= 10) {
                carryFlag = true;
                digit -= 10;
            }

            // Update linked list
            ListNode next = new ListNode(digit);
            current.next = next;
            current = next;
        }
        
        return result.next;
    }
}