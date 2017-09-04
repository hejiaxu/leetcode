/**
 * 
 */
package com.code.leet;

import com.code.leet.ReverseNodesinkGroup.ListNode;

/**
 * Jiaxu
 * Jul 5, 2017
 * 
 */
public class ReverseNodesinkGroup {

	public static void main(String[] args) {
		// TODO 
		ReverseNodesinkGroup reverseNodesinkGroup= new ReverseNodesinkGroup();
		ListNode head = reverseNodesinkGroup.new ListNode(1);
		head.next = reverseNodesinkGroup.new ListNode(2);
		head.next.next = reverseNodesinkGroup.new ListNode(3);
		ListNode reverseKGroup = reverseNodesinkGroup.reverseKGroup(head, 3);
		while(reverseKGroup!=null){
			System.out.println(reverseKGroup.val);
			reverseKGroup=reverseKGroup.next;
		}
	}
	
	
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 
	 
	 //8ms
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead=head,nextHead =head,tail=head;
        int len=0;
        while(nextHead!=null){
        	nextHead=nextHead.next;
        	len++;
        	if (len==k) {
				break;
			}
        }
        if (len<k) {
			return head;
		}
        while(tail!=nextHead){
        	ListNode next = tail.next;
        	tail.next=newHead;
        	head.next=next;
        	newHead=tail;
        	tail=next;
        }
        if (nextHead!=null) {
        	head.next=reverseKGroup(nextHead, k);
		}
    	return newHead;
    }
    //8ms
    public ListNode reverseKGroup2(ListNode head, int k) {
    	ListNode newHead=head,nextHead =head,tail=head;
    	int len=0;
    	
    	while(nextHead!=null){
    		nextHead=nextHead.next;
    		len++;
    		if (len==k) {
    			break;
    		}
    	}
    	if (len<k) {
    		return head;
    	}
    	while(tail!=nextHead){
    		ListNode next = tail.next;
    		tail.next=newHead;
    		head.next=next;
    		newHead=tail;
    		tail=next;
    	}
    	head.next=reverseKGroup(nextHead, k);
    	return newHead;
    }
}
