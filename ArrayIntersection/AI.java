package exercise.ArrayIntersection;

import java.util.ArrayList;
import java.util.HashSet;


/*
 * Given two lists of integers, write a function that returns 
 * a list that contains only the intersection(elements that occur 
 * in both lists) of the two lists. The returned list should
 * only contain unique integers, no duplicates.
 * 
 * For example[4,2,73,11,-5] and [-5,73,-1,9,9,4,7] would return
 * a list containing [-5,4,73] in no paticular order.
 * 
 * For not large scale List:
 * Time: O(n)
 * 
 */

public class AI {

	public static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b)
	{
		ArrayList<Integer> c = new ArrayList<Integer>();
		HashSet<Integer> hset = new HashSet<Integer>();
		for(int i:a)
			hset.add(i);
		for(int i:b)
			if(hset.contains(i))
				c.add(i);
		return c;	
	}


}
