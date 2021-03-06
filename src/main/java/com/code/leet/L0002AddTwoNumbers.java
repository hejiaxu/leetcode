package com.code.leet;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class L0002AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next= new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next= new ListNode(4);
		ListNode addTwoNumbers = addTwoNumbers(l1, l2);
		while(addTwoNumbers != null){
			System.out.println(addTwoNumbers.val);
			addTwoNumbers = addTwoNumbers.next;
		}
	}
	public static class ListNode {
		int val;
		ListNode next;
	    ListNode(int x) { val = x; }
	}
	  // 69 ms
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null, pre = null, next = null;
		int carry = 0;
		while(l1 != null || l2 != null){
			int val;
			if (l1 == null) {
				val = (l2.val + carry) % 10;
				carry = (l2.val + carry) / 10;
				l2 = l2.next;
			} else if (l2 == null) {
				val = (l1.val  + carry) % 10;
				carry = (l1.val + carry) / 10;
				l1 = l1.next;
			} else {
				val = (l1.val + l2.val + carry) % 10;
				carry = (l1.val + l2.val + carry) / 10;
				l1 = l1.next;
				l2 = l2.next;
			}
			next = new ListNode(val);
			if (l3 == null) {
				l3 = next;
				pre = next;
			} else {
				pre.next = next;
				pre = next;
			}
		}
		if (carry > 0) {
			next = new ListNode(1);
			pre.next = next;
		}
		return l3;
    }
}
