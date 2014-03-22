package exercise.LinklistLastK;

/*
 * O(n) time
 * O(1) space
 */
public class LLK {
	public ListNode NthFromEnd(ListNode head, int k) {
		if (k<=0)
			return null;
		ListNode p1 = head;
		ListNode p2 = head;
		for (int i=0; i<k-1; i++) {
			if (p2 == null)
				return null;
			p2 = p2.next;
		}
		if (p2 == null)
			return null;
		
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
	
		return p1;
    }
}
