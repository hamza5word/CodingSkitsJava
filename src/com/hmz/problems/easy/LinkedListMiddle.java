package com.hmz.problems.easy;

import com.hmz.test.Tester;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 */
public class LinkedListMiddle extends Tester {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public LinkedListMiddle(int testIndex) {
        super(testIndex);
    }

    void test1() {
        ListNode nodesA = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode nodesB = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(middleNode(nodesA).val);
        System.out.println(middleNode(nodesB).val);
    }

    // Methods

    /**
     * Floyd's Algorithm
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next !=  null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // Endpoint

    public static void main(String[] args) {
        new LinkedListMiddle(1);
    }

}
