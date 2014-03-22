package exercise.High5ScoreAverage;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;


/*
 *  O(nlogk) , k =5 ==> O(n)
 *  
 */
public class H5A {

	
	public static HashMap<Integer, Double> getFinalScores(List<TestResult> results){
		HashMap<Integer, PriorityQueue<Integer> > id_scores = new HashMap<Integer, PriorityQueue<Integer> >();

		for(TestResult res : results) {
			PriorityQueue<Integer> queue = null;
			if(id_scores.containsKey( res.studentId ) ) {
				queue = id_scores.get(res.studentId);
			} else {
				queue = new PriorityQueue<Integer>(5);
			}
			
	   		if (queue.size() < res.score)
				queue.add(res.score);
			
			else {
				if (res.score > queue.peek()) {
					queue.poll();
					queue.add(res.score);
				}
			}
	   		
	   		id_scores.put(res.studentId, queue);
	   		}	
		
		HashMap<Integer, Double> averages = new HashMap<Integer,Double>();
		
		for(int key : id_scores.keySet()) {
			PriorityQueue<Integer> queue = id_scores.get(key);

			double avg = 0;
			if (queue.size() >= 5) {
				for(int i=0; i<5 ; i++)
					avg += queue.poll();
				avg /= 5;
				averages.put(key, avg);	
			}
			else {
				int j = queue.size();
				for(int i=0; i<j ; i++)
					avg += queue.poll();
				avg /= j;
				averages.put(key, avg);	
			}
		}
		return averages;
	}
	
}
