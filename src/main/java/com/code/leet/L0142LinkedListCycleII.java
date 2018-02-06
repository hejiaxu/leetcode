package com.code.leet;

/*
Given a linked list, return the node where the cycle begins.
If there is no cycle, return null.

Note: Do not modify the linked list.
 */
public class L0142LinkedListCycleII {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && ((slow != fast  && fast != head)|| slow == head)) {
            slow = slow.next;
            fast = fast.next;
            if (fast == head || fast == null) {
                break;
            }
            fast = fast.next;
        }

        if (fast != null) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return fast;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
