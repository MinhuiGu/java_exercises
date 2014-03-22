package exercise.CheckLinkedListCircle;

/*
 * Find loop in the given linked list
 * O(n)
 */

public class ListLoopQuestion {
	  public static class ListNode {
	    public int value;
	    public ListNode next;
	  }
	 
	  public static boolean hasLoops( ListNode myList ) {
			if (myList == null || myList.next == null)
				return false;
			
			ListNode slow = myList;
			ListNode fast = myList;
			
			while (fast.next != null && fast.next.next!=null) {
				slow = slow.next;
				fast = fast.next.next;
				if (slow  == fast)
					return true;
			}
			return false;
	  }
	}