/* Add Two Numbers as Lists */
/*
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain
 * a single digit. Add the two numbers and return it as a linked list.
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode iterA = A;
        ListNode iterB = B;
        ListNode retList = new ListNode(0);
        ListNode result = retList; // dummy pre-head
        int carry = 0;

        while (iterA != null && iterB != null) {
            int sum = iterA.val + iterB.val + carry;
            carry = 0;
            iterA = iterA.next;
            iterB = iterB.next;

            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            }

            result.next = new ListNode(sum);
            result = result.next;
        }

        // either one or both of the LL's have ended 
        if (iterA == null && iterB != null) {
            // continue with iterB
            while (iterB != null) {
                int sum = carry + iterB.val;
                iterB = iterB.next;
                carry = 0;

                if (sum >= 10) {
                    carry = 1;
                    sum -= 10;
                }
                result.next = new ListNode(sum);
                result = result.next;
            }
        }
        else if (iterB == null) {
            // continue with iterA
            while (iterA != null) {
                int sum = carry + iterA.val;
                iterA = iterA.next;
                carry = 0;

                if (sum >= 10) {
                    carry = 1;
                    sum -= 10;
                }
                result.next = new ListNode(sum);
                result = result.next;
            }
        }

        if (carry != 0) {
            result.next = new ListNode(1);
            result = result.next;
        }

        return retList.next;
    }   
}

