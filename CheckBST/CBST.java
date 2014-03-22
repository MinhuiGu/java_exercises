package exercise.CheckBST;



/*
 * Given a binary tree, write a function that returns true if and only if it is a binary search tree. 
 * Your solution will be evaluated on correctness, runtime complexity (big-O), and adherence to coding best practices
 * 
 * Time Complexity: O(n)
 * Auxiliary Space : O(1) if Function Call Stack size is not considered, otherwise O(n)
 */

public class CBST {
	
	public static boolean isValidBST(Node root) {
		return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	 
	public static boolean validate(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
	 
		if (root.value <= min || root.value >= max) {
			return false;
		}
			return validate(root.left, min, root.value) && validate(root.right, root.value, max);
	}
}
