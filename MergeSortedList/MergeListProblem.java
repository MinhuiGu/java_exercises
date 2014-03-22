package exercise.MergeSortedList;

/*
 * Merge 2 sorted linkedList
 * O(n)
 */
public class MergeListProblem {
	public static Node mergeLists(Node head1, Node head2) {
		Node newhead = new Node();
		Node p1 = head1;
		Node p2 = head2;
		Node p = newhead;
		while (p1!=null && p2!=null) {
			if(p1.value<p2.value) {
				p.next = p1;
				p1 = p1.next;
			}
			else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}
		if (p1!=null)
			p.next = p1;
		if (p2!=null)
			p.next = p2;
		
		return newhead.next;
	}
}
