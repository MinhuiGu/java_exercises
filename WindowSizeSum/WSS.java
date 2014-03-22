package exercise.WindowSizeSum;

import java.util.ArrayList;
import java.util.List;

/*
 * O(n)
 */
public class WSS {
	
	public static List<Integer> windowSize(List<Integer> in, int win_size) {
		List<Integer> result = new ArrayList<Integer>();
		if (in.size() < win_size) {
			return result;
		}
		if (win_size == 0) {
			for (int i=0; i< in.size(); i++)
				result.add(in.get(i)*win_size);
			return result;
		}
		
		Integer current = 0;
		for (int i=0; i<in.size(); i++) {
			 {
				current += in.get(i);
				if (i>=win_size-1) {
					result.add(current);
					current -= in.get(i-win_size+1);
				}		
			}			
		}	
		return result;		
	}
}
