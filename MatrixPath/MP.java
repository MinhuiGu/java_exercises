package exercise.MatrixPath;
/*
 * O(n^2)
 */
public class MP {
	 public static int maxPathSum(int[][] grid) {
		 int path[][] = new int[grid.length][grid[0].length];  
		 int col, row;
		 row = grid.length;
		 col = grid[0].length;
		 
		 path[0][0] = grid[0][0];
		 for (int i = 1; i < row; i++) {
		     path[i][0] = path[i-1][0] + grid[i][0];
		 }
		 for (int j = 1; j < col; j++) {
			 path[0][j] = path[0][j-1] + grid[0][j];
		 }
		 for (int i = 1; i < row; i++) {
			 for (int j = 1; j < col; j++) {
				 path[i][j] = path[i-1][j]>path[i][j-1]?path[i-1][j]+grid[i][j]:path[i][j-1]+grid[i][j];
			 }
		 }
		 return path[row-1][col-1];
		 
	    }	 
}
