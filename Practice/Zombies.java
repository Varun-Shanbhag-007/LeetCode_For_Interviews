
/*Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour. Find out how many hours does it take to infect all humans?
*/
package Amazon;

import java.util.*;

public class Zombies {
	private static final int ZOMBIE = 1;
	private static final int[][] DIRS= {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		int rows = in.nextInt();
		int col = in.nextInt();

		for(int i = 0; i < rows; i++) {
			List<Integer> inner = new ArrayList<>();
			for(int j = 0; j < col; j++) {

				inner.add(in.nextInt());
			}
			res.add(inner);
			inner = new ArrayList<>();

		}
		System.out.println(res);
		int result = hours(res);
		System.out.println(result);
	}

	public static int hours(List<List<Integer>> grid) {
		int people = 0;
		Queue<Point> qu = new ArrayDeque<>();
		//Adding Points where there is a zombie in a qu
		for(int r = 0; r < grid.size(); r++) {
			for(int c = 0; c < grid.get(0).size(); c++) {
				if(grid.get(r).get(c) == ZOMBIE) {
					qu.add(new Point(r,c));
				}
				else
					people++;
			}
		}

		if(people == 0)
			return 0;

		for(int hour = 1; !qu.isEmpty(); hour++) {
			for(int si = qu.size(); si > 0; si--) {
				Point p = qu.poll();
				for (int[] dir : DIRS) {
	                int r = p.r + dir[0];
	                int c = p.c + dir[1];

	                if (isHuman(grid, r, c)) {
	                    people--;
	                    if (people == 0) return hour;
	                    grid.get(r).set(c, ZOMBIE);
	                    qu.add(new Point(r, c));
	                }
	            }
			}
		}
		return -1;
	}
	public static boolean isHuman(List<List<Integer>> grid, int r, int c) {
		if(r >= 0 && c >=0 && r < grid.size() && c < grid.get(0).size() && grid.get(r).get(c) != ZOMBIE)
			return true;
		return false;
	}

	private static class Point{
		int r,c;
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

}

