package com.jayasanka.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MergeTwoSortedLists {
	
	public static void main(String[] args) {
		ListNode list1 = null;
		ListNode list2 = null;
		
		for (int i = 0; i < 10; i++) {
			int val1 = (int)(Math.random() * 10);
			if (list1 == null) {
				list1 = new ListNode(val1);
			} else {
				list1.next = new ListNode(val1);
			}
			System.out.println("val1 : " + val1);
			
			int val2 = (int)(Math.random() * 10);
			if (list2 == null) {
				list2 = new ListNode(val2);
			} else {
				list2.next = new ListNode(val2);
			}
			System.out.println("val2 : " + val2);
		}
		
		ListNode result = mergeTwoLists(list1, list2);
		
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}
	
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
		if(list2 == null) return list1;
		if(list1.val < list2.val){
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else{
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}
    }
}
