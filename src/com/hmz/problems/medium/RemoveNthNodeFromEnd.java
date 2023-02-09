package com.hmz.problems.medium;

import com.hmz.datasets.ListNode;
import com.hmz.problems.easy.LinkedListMiddle;
import com.hmz.test.Tester;

import java.util.List;
import java.util.Vector;


/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 */
public class RemoveNthNodeFromEnd extends Tester {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public RemoveNthNodeFromEnd(int testIndex) {
        super(testIndex);
    }

    void test1() {
        System.out.println(printList(removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2)));
        System.out.println(printList(removeNthFromEnd(new ListNode(1), 1)));
        System.out.println(printList(removeNthFromEnd(new ListNode(1, new ListNode(2)), 1)));
    }

    void test2() {

    }

    // Methods

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start, fast = start;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    public List<Integer> printList(ListNode head) {
        List<Integer> ret = new Vector<>();
        ret.add(head.val);
        ListNode node = head.next;
        while (node != null) {
            ret.add(node.val);
            node = node.next;
        }
        return ret;
    }

    // Endpoint

    public static void main(String[] args) {
        new RemoveNthNodeFromEnd(1);
    }
}
