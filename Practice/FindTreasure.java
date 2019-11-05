/*You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.

Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from the top-left corner of the map and can move one block up, down, left or right at a time. The treasure island is marked as X in a block of the matrix. X will not be at the top-left corner. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in. The top-left corner is always safe. Output the minimum number of steps to get to the treasure.


 *
 */
package Amazon;
import java.util.*;
public class FindTreasure {
	public static int[][] DIRS = {{0,1},{1,0},{-1,0},{0,-1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {{'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}};
		System.out.println(minSteps(grid));
	}
	public static int minSteps(char[][] grid) {
		Queue<Point> q = new ArrayDeque<Point>();
		
		q.add(new Point(0,0));
		for(int i = 1; !q.isEmpty(); i++) {
			
			for(int siz = q.size(); siz > 0; siz--) {
				Point p = q.poll();
				for(int[] dir : DIRS) {
					int r = p.r +dir[0];
					int c = p.c + dir[1];
					if(isSafe(r,c,grid)) {
						if(grid[r][c] == 'X')return i;
						grid[r][c] = 'D';
						q.add(new Point(r,c));
					}
				}
			}
		}
		return 0;
	}
	public static boolean isSafe(int r, int c, char[][] grid) {
		return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != 'D';
	}
	public static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}

