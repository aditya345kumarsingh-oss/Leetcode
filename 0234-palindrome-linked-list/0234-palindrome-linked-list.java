class Solution {
    public boolean isPalindrome(ListNode head) {

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        // Step 2: Reverse second half
        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }


        // Step 3: Compare
        ListNode curr1 = prev;
        ListNode curr2 = head;

        while (curr1 != null) {

            if (curr1.val != curr2.val) {
                return false;
            }

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return true;
    }
}