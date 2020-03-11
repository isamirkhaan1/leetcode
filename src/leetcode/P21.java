package leetcode;

import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

/**
 * 
 * 
 * @author isamirkhaan1
 * 
 *         21. Merge Two Sorted Lists
 * 
 *         Merge two sorted linked lists and return it as a new list. The new
 *         list should be made by splicing together the nodes of the first two
 *         lists.
 * 
 * 
 *         Example: Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 *
 */

public class P21 {

	/*
	 * 
	 * Algorithm:
	 * 
	 *		1. Make a dummy node and a header for the dummy node
	 *		2. start loop
	 *		3. Check if any list is empty put another one in the result list and break the loop
	 *		4. Find Max value from the two list heads, insert it into the result list.
	 *		   Increment result list header node and that smaller node header node.
	 *		5. Eventually one list will become empty and the loop will break
	 *		6. Since the dummy node contains random value, return dummyNode.next
	 * 
	 */

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode l = new ListNode(0);
		ListNode temp = l;

		while (true) {

			if (l1 == null) {
				temp.next = l2;
				break;
			}

			if (l2 == null) {
				temp.next = l1;
				break;
			}

			if (l1.val <= l2.val) {
				temp.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				temp.next = new ListNode(l2.val);
				l2 = l2.next;
			}

			temp = temp.next;
		}

		return l.next;

	}

	public void print(ListNode l) {

		System.out.println();
		while (l != null) {
			System.out.print(l.val + ",");

			l = l.next;
		}

	}

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(5);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		P21 p21 = new P21();
		ListNode l = p21.mergeTwoLists(l1, l2);

		p21.print(l);
	}

}
