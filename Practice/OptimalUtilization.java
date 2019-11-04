/*
 Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value. Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible. Return a list of ids of selected elements. If no pair is possible, return an empty list.
*/
package Amazon;
import java.util.*;
public class OptimalUtilization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<int[]> output(List<int[]> a, List<int[]> b, int target){
		Collections.sort(a, (i, j) -> i[1] - j[1]);
		Collections.sort(b, (i, j) -> i[1] - j[1]);
		int a_size = a.size();
		int b_size = b.size();
		int i = 0;
		int j = b_size-1;
		int max = Integer.MIN_VALUE;
		List<int[]> res = new ArrayList<>();
		while(i < a_size && j >= 0) {
			int sum = a.get(i)[1] + b.get(j)[1];
			if(sum > target)
				j--;
			else {
				if(max <= sum) {
					if(max < sum) {
					max = sum;
					//we have found sum closer to target so clear the previous pairs stores in res
					res.clear();
					}
					res.add(new int[] {a.get(i)[0], b.get(j)[0]});
					int ind = j-1;
					while(ind >= 0 && b.get(j)[1] == b.get(j+1)[1]) {
						res.add(new int[] {a.get(i)[0], b.get(ind--)[0]});
					}
				}
				// want to get closer to target if possible
				++i;
			}
		}
		return res;
	}
}

