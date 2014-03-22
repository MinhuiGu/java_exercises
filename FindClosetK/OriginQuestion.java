package exercise.FindClosetK;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/* Find the K closest points to the origin in 2D plane, given an array containing N points. 
 * You can assume K is much smaller than N and N is very large. 
 * You need only use standard math operators (addition, subtraction, multiplication, and division).
 * 
 * O(nlogK) ==> O(n)
 */
public class OriginQuestion {
	
	 public static class Point {
		    public double x;
		    public double y;
		    
		 public Point(double x, double y) {
			 this.x = x;
			 this.y = y;
		 }
	 }
	 
	 public static int cmp(Point p1, Point p2) {
		 double x = Math.sqrt(p1.x*p1.x +p1.y*p1.y) - Math.sqrt(p2.x*p2.x +p2.y*p2.y);
			if (x>0)
				return 1;
			else if (x<0)
				return -1;
			else
				return 0;
	 }

	 public static Point[] closestk( Point  myList[], int k ) {
		
		Comparator<Point> cmptor = new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				double x = Math.sqrt(p1.x*p1.x +p1.y*p1.y) - Math.sqrt(p2.x*p2.x +p2.y*p2.y);
				if (x>0)
					return -1;
				else if (x<0)
					return 1;
				else
					return 0;
			}
		};
		
		Queue<Point> priorityQueue = new PriorityQueue<Point>(k, cmptor);
	
		for (int i = 0; i < myList.length; i++) {
			if (priorityQueue.size() < k)
				priorityQueue.add(myList[i]);
			
			else {
				Point peek = priorityQueue.peek();
				if ( cmp(myList[i],peek) < 0 ) {
					priorityQueue.poll();
					priorityQueue.add(myList[i]);
				}
			}
		}
	
		Point[] result = new Point[k];
		while (!priorityQueue.isEmpty())
			for (int i = 0; i < k; i++)
				result[i] = priorityQueue.poll();
	
		return result;
	};

}
