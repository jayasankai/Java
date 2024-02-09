package com.jayasanka.leetcode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);
		l2.next.next.next.next = new ListNode(9);
		
		
		ListNode l = addTwoNumbers(l1, l2);
		
		while (l != null ) {
			System.out.println(l.val);
			l = l.next;
		}

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l = null;
		int rem = 0;

		while (l1 != null || l2 != null) {
			int val = rem;
			ListNode node = new ListNode();

			if (l1 != null) {
				//System.out.println("l1 --> " + l1.val);
				val += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				//System.out.println("l2 --> " + l2.val);
				val += l2.val;
				l2 = l2.next;
			}

			node.val = val % 10;
			rem = val / 10;
			
			System.out.println("l --> " + node.val);

			if (l != null) {
				ListNode current = l;
				while(current.next != null) {
					current = current.next;
				}
				current.next = node;					
			} else {
				l = node;
			}
		}

		if (rem > 0) {
			ListNode current = l;
			while(current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(rem);;	
			
			System.out.println("l --> " + rem);
		}

		return l;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}