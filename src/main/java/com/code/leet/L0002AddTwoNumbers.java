
package com.code.leet;

import com.code.leet.AddTwoNumbers.ListNode;

public class AddTwoNumbers {

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
	 static public class ListNode {
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
