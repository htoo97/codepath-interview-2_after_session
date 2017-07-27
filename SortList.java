/* Sort Linked List */
/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *    public int val;
 *    public ListNode next;
 *    ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode middle = getMiddle(A);
        ListNode middleNext = middle.next;
        middle.next = null;

        ListNode left = sortList(A);
        ListNode right = sortList(middleNext);

        return merge(left, right);
    }

    private ListNode getMiddle(ListNode A) {
        if (A == null) {
            return A;
        }

        ListNode slow = A;
        ListNode fast = A.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        return slow;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (one != null && two != null) {
            if (one.val <= two.val) {
                cur.next = one;
                one = one.next;
            }
            else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }

        cur.next = (one == null)? two : one;

        return dummy.next;
    }
}

