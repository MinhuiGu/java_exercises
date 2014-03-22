package exercise.MostFrequentWord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map.Entry;

/* 
 * O(n)
 */

public class MFW {
	
	static public ArrayList<Integer> MostFrequentInt (ArrayList<Integer> input) {
		Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if (input.size() == 0)
			return result;
		
		for(Integer i:input) {
			if (table.containsKey(i))
				table.put(i, table.get(i)+1);		
			else
				table.put(i, 1);
		}
		int maximum = Collections.max(table.values ());
		
		for (Entry<Integer, Integer> entry : table.entrySet()) {
            if (entry.getValue().equals(maximum)) {
               	result.add(entry.getKey());
            }
        }
		return result;
	}

}
