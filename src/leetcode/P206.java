package leetcode;



/**
 * 
 * @author isamirkhaan1
 * 
 * 
 *         206. Reverse Linked List
 *
 *         Reverse a singly linked list
 *         Example: Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
 *
 *         NOTE: A linked list can be reversed either iteratively or recursively.
 *         Could you implement both?
 *
 */
public class P206 {

	
	/**
	 * 
	 * Algorithm:
	 * 		
	 * 		idea:
	 * 			i -> (i+1) ==> i <- (i+1)
	 * 
	 * 		1. Take 3 nodes; prev, curr and next
	 * 		2. Set current node as head
	 * 		3. Start Loop:
	 * 			4. next node = next of head
	 *			5. Reverse reference; (current node -> next node) to (current node -> previous node)
	 *			6. Move to next node, i.e. update previous and current nodes
	 *			7. Repeat till current node is null
	 */
	public ListNode reverseLinkedListByIteration(ListNode head) {
		
		ListNode prev, curr, next;
		
		prev = null;
		curr = head;
		
		while(curr != null) {
			
			//save reference to next
			next = curr.next;
			
			//update current node reference
			curr.next = prev;
			
			
			//update prev, curr to next corresponding nodes
			prev = curr;
			curr = next;
			
		}
		
		return prev;
	}
	
	
	
	/**
	 * 
	 * Algorithm:
	 * 
	 * 		Idea:
	 * 			Via recursion, go to the last node and return it.
	 *			reverse reference between (i) and (i+1)
	 * 
	 */
	public ListNode reverseLinkedListByRecursion(ListNode head) {
		
		if( head == null || head.next == null)
			return head;
		
		ListNode newHead = reverseLinkedListByRecursion(head.next);
		
		head.next.next = head;
		head.next = null;
		
		return newHead;
		
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
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		
		P206 p = new P206();
		
		p.print(p.reverseLinkedListByIteration(l1));
		p.print(p.reverseLinkedListByRecursion(l1));

	}

}
