package com.hmz.problems.easy;

import com.hmz.test.Tester;

import java.util.List;
import java.util.Vector;

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: false
 */
public class PalindromeLinkedList extends Tester {

    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public PalindromeLinkedList(int testIndex) {
        super(testIndex);
    }

    void test1() {
        ListNode nodesA = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        ListNode nodesB = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode nodesC = new ListNode(1, new ListNode(2));
        System.out.println("Nodes A : " + isPalindrome(nodesA));
        System.out.println("Nodes A : " + isPalindrome(nodesB));
        System.out.println("Nodes A : " + isPalindrome(nodesC));
    }

    void test2() {
        ListNode nodesA = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        ListNode nodesB = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode nodesC = new ListNode(1, new ListNode(2));
        System.out.println("Nodes A : " + isPalindromeV2(nodesA));
        System.out.println("Nodes A : " + isPalindromeV2(nodesB));
        System.out.println("Nodes A : " + isPalindromeV2(nodesC));
    }

    // Methods

    public boolean isPalindrome(ListNode head) {
        List<Integer> saver = new Vector<>();
        while (head != null) {
            saver.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = saver.size() - 1;
        while (i <= j) {
            if(!saver.get(i).equals(saver.get(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * Floyd's algorithm using fast and slow pointer in order to find the middle of the list
     * Reverse algorithm using tmp and prev pointers
     * Compare the head and tale halves of the list
     * @param head
     * @return
     */
    public boolean isPalindromeV2(ListNode head) {
        ListNode fast = head, slow = head;
        // Finding the middle (slow)
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // Reversing
        ListNode prev = null;
        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }
        // Comparing
        ListNode left = head, right = prev;
        while (right != null) {
            if(left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // Endpoints

    public static void main(String[] args) {
        new PalindromeLinkedList(2);
    }
}
