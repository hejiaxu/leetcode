/**
 * 
 */
package com.code.leet;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.code.leet.MergekSortedLists.ListNode;

/**
 * Jiaxu
 * Jun 30, 2017
 * 
 */
public class MergekSortedLists {

	public static void main(String[] args) {
		// TODO 
		
		ListNode[] lists = new ListNode[3];
		for (int i = 0; i < lists.length; i++) {
			lists[i]=new MergekSortedLists().new ListNode(i);
		}
		ListNode mergeKLists = new MergekSortedLists().mergeKLists3(lists);
		while(mergeKLists!=null){
			System.out.println(mergeKLists.val);
			mergeKLists=mergeKLists.next;
		}
		
		
	}
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 
	 
	 //26ms
    public ListNode mergeKLists(ListNode[] lists) {
    	Queue<ListNode> set = new PriorityQueue<>(lists.length,new NodeComparator());
        ListNode r = null,tail=r;
        for(ListNode list:lists){
        	if (list!=null) {
        		set.offer(list);
			}
        }
        while(!set.isEmpty()){
        	ListNode tmp = set.poll();
        	if (tmp.next!=null) {
        		set.add(tmp.next);
			}
        	if (r==null) {
				r = tmp;
				tail=tmp;
			}else {
				tail.next=tmp;
				tail=tail.next;
			}
        	
        }
        return r;
    }
    
    class NodeComparator implements Comparator<ListNode>{

		@Override
		public int compare(ListNode o1, ListNode o2) {
			// TODO 
			if (o1.val>o2.val) {
				return 1;
			}else if(o1.val<o2.val) {
				return -1;
			}
			return 0;
		}
    	
    }
    //15ms
    public ListNode mergeKLists2(ListNode[] lists) {
    	if (lists==null||lists.length==0) {
    		return null;
		}
    	ListNode r = null;
    	for (int i = 0; i < lists.length; i++) {
			r=merge2(r,lists[i]);
		}
    	return r;
    }
	private ListNode merge2(ListNode listNode, ListNode listNode2) {
		// TODO 
		if (listNode2==null) {
			return listNode;
		}
		if (listNode==null) {
			return listNode2;
		}
		ListNode head = null,tmp=null;
		while(listNode!=null||listNode2!=null){
			if (listNode.val<=listNode2.val) {
				if (tmp==null) {
					tmp=listNode;
					head=listNode;
				}else tmp.next=listNode;
				listNode=listNode.next;
			}else {
				if (tmp==null) {
					tmp=listNode2;
					head=listNode2;
				}tmp.next=listNode2;
				listNode2=listNode2.next;
			}
		}
		return head;
	}
    
	public static ListNode merge(ListNode l1,ListNode l2){
	    if(l1==null) return l2;
	    if(l2==null) return l1;
	    if(l1.val<l2.val){
	        l1.next=merge(l1.next,l2);
            return l1;
	    }else{
	        l2.next=merge(l1,l2.next);
	        return l2;
	    }
	}
	    
	//26ms
    public ListNode mergeKLists3(ListNode[] lists) {
    	if (lists==null||lists.length==0) {
    		return null;
		}
    	return mergeListPart(lists,0,lists.length-1);
    }
	private ListNode mergeListPart(ListNode[] lists, int i, int j) {
		// TODO 
		if(i==j){
			return lists[i];
		}
		int mid = (i+j)/2;
		ListNode nodeL = mergeListPart(lists, i, mid);
		ListNode nodeR = mergeListPart(lists, mid+1, j);
		ListNode merge = merge(nodeL, nodeR);
		return merge;
	}
	
}
