package com.hmz.datasets;

import java.util.List;
import java.util.Vector;

public class ListNode {

    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public List<Integer> printList() {
        List<Integer> ret = new Vector<>();
        ret.add(val);
        ListNode node = next;
        while (node != null) {
            ret.add(node.val);
            node = node.next;
        }
        return ret;
    }


    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return printList().toString();
    }
}
