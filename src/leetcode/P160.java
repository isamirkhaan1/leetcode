package leetcode;



/**
 * 
 * 
 * 
 * @author isamirkhaan1
 * 
 * 
 * 
 * 	160. Intersection of Two Linked Lists
 *
 *	Write a program to find the node at which the intersection of two singly linked lists begins.
 *	
 *	NOTE:
 *	
 *	1. If the two linked lists have no intersection at all, return null.
 *	2. The linked lists must retain their original structure after the function returns.
 *	3. You may assume there are no cycles anywhere in the entire linked structure.
 *	4. Your code should preferably run in O(n) time and use only O(1) memory.
 *
 *
 */
public class P160 {

	
	/**
	 * 
	 *	Algorithm:
	 *
	 *		Idea:
	 *			- Once the smaller linked-list is finished, it's re-directed to the larger one
	 *			- Meantime, the larger one has still to finish. When it finishes, it's re-directed to the smaller one
	 *			- Now here is the trick,
	 *			- At this point, both the linked-list has same remaining nodes to traverse.
	 *			- If there is no intersection, at some time both pointers will become NULL, at the same time.
	 *			- It will stop the loop and return null.
	 *
	 *
	 */
	public ListNode findIntersectionBy2Pointers(ListNode headA, ListNode headB) {
		
		
		//save original pointers, as mentioned in the desc
		
		ListNode tempA = headA;
		ListNode tempB = headB;
		
		
		while(tempA != tempB) {
			
			if(tempA == null)
				tempA = headB;
			else
				tempA = tempA.next;
			
			if(tempB == null)
				tempB = headA;
			else
				tempB = tempB.next;
			
			
		}
		
		return tempA;
	}
	
	
	
	/**
	 * 
	 * 
	 * Algorithm:
	 * 
	 * 		Idea:
	 * 			1. Find length of both lists
	 * 			2. Calculate difference (let say k)
	 * 			3. Move the larger list k nodes onward i.e. equal nodes are left to traverse, for both pointers/lists
	 * 			4. compare nodes until NULL, if node1==node2, it means intersection.
	 * 
	 */
	public ListNode findIntersectionByNodeCounts(ListNode headA, ListNode headB) {
		

        ListNode tempA = headA;
        ListNode tempB = headB;
        
        //find length of tempA
		 int headACount = 0;
	        while(tempA != null){
	            ++headACount;
	            tempA = tempA.next;
	        }
	        tempA = headA;
	        
	        
	        //find length of tempB
	        int headBCount = 0;
	        while(tempB !=null){
	            ++headBCount;
	            tempB = tempB.next;
	        }
	        tempB = headB;
	        
	        //calculate the difference between length
	        int diff = Math.abs(headBCount-headACount);
	        
	        //move the larger linked-list header diff nodes forward
	        //such that both linked-lists have nodes left to traverse
	        
	        if(headACount>=headBCount){
	            while(diff > 0){
	                tempA = tempA.next;
	                --diff;
	            }}else{
	            while(diff>0){
	                tempB = tempB.next;
	                --diff;
	            }
	        }
	            
	        
	        //now check if there is an intersection
	            while(tempA != null && tempB != null){
	                if(tempA == tempB)
	                    return tempA;
	                tempA = tempA.next;
	                tempB = tempB.next;
	            }
	        
	        
		return null;
	}
	
	public static void main(String[] args) {

		ListNode l = new ListNode(111);
		l.next = new ListNode(42);
		l.next.next = new ListNode(43);
		l.next.next.next = new ListNode(44);
		
		ListNode l1 = new ListNode(10);
		l1.next = new ListNode(12);
		l1.next.next = new ListNode(14);
		l1.next.next.next = l;
		
		ListNode l2 = new ListNode(21);
		l2.next = new ListNode(22);
		l2.next.next = new ListNode(24);
		l2.next.next.next = l;
		
		

		
		P160 p = new P160();
		
		System.out.println(p.findIntersectionBy2Pointers(l1, l2).val + "" );
		System.out.println(p.findIntersectionByNodeCounts(l1, l2).val + "" );

	}

}
