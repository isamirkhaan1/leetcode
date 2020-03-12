package leetcode;

import java.util.HashSet;

/**
 * 
 * 
 * @author isamirkhaan1
 *
 *	141. Linked List Cycle
 *
 *	Given a linked list, determine if it has a cycle in it.
 *
 *	To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 *
 *	Can you solve it using O(1) (i.e. constant) memory?
 */
public class P141 {

	
	/**
	 * 
	 * 
	 * Algorithm:
	 * 
	 * 		Idea:
	 * 			Store each node in a hashSet, if it repeats return true
	 * 			Otherwise if it reaches NULL i.e. it has an end. No cycle
	 * 
	 */
	public boolean findCycleViaHash(ListNode head) {
		
		HashSet<ListNode> hash = new HashSet<ListNode>();
		
		while(head != null) {
			
			if(hash.contains(head))
				return true;
			
			hash.add(head);
			head = head.next;
		}
		
		return false;
	}
	
	
	/**
	 * 
	 * 
	 * Algorithm:
	 * 			Idea:
	 * 				Floyd's Cycle Finding
	 * 				
	 * 				1. Take 2 pointers, one should move slowly another one fast.
	 * 				2. If it's cycle they must meet, else if anyone reached NULL, then it's not a cycle.
	 *
	 *	
	 *	After advancing each step i.e. small and large, check for NULL  
	 *
	 */
	public boolean findCycleViaFloydCycleFinding(ListNode head) {
		
		if(head == null || head.next == null)
			return false;
		
		ListNode smallStep = head;
		ListNode longStep = head.next;
		
		while(true) {
			
			if(smallStep == null || longStep == null || longStep.next == null )
				break;
			
			if(smallStep == longStep)
				return true;
			
			smallStep = smallStep.next;
			longStep = longStep.next.next;
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = l1.next.next;
		
		
		P141 p = new P141();
		
		if(p.findCycleViaFloydCycleFinding(l1))
			System.out.println("true");
		else
			System.out.println("false");

	}

}
