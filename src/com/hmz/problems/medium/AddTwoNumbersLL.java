package com.hmz.problems.medium;

import com.hmz.test.Tester;


/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbersLL extends Tester {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public AddTwoNumbersLL(int testIndex) {
        super(testIndex);
    }

    void test1() {
        System.out.println(addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4))))
        );
        System.out.println(addTwoNumbers(
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))
        );
        System.out.println(addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(9))),
                new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9)))))
        );
    }

    void test2() {

    }

    // Methods

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode curr = ret;
        ListNode l1curr = l1;
        ListNode l2curr = l2;
        while (true) {
            int v1 = 0;
            int v2 = 0;
            if(l1curr != null) v1 = l1curr.val;
            if(l2curr != null) v2 = l2curr.val;
            int sum = curr.val + v1 + v2;
            int curry = 0;
            if(sum < 10) curr.val = sum;
            else {
                curr.val = sum % 10;
                curry = (sum / 10) % 10;
            }
            if(curry == 0 && (l1curr == null || l1curr.next == null) && (l2curr == null || l2curr.next == null)) break;
            curr.next = new ListNode(curry);
            curr = curr.next;
            if(l1curr != null) l1curr = l1curr.next;
            if(l2curr != null) l2curr = l2curr.next;
        }
        return ret;
    }

    // Endpoint

    public static void main(String[] args) {
        new AddTwoNumbersLL(1);
    }
}
