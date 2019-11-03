
/*
Given n ropes of different lengths, we need to connect these ropes into one rope. We can connect only 2 ropes at a time. The cost required to connect 2 ropes is equal to sum of their lengths. The length of this connected rope is also equal to the sum of their lengths. This process is repeated until n ropes are connected into a single rope. Find the min possible cost required to connect all ropes.

*/

package Amazon;
import java.util.*;
public class MinCostToConnectRopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {2,2,3,3};
		System.out.println("the ans is = "+minCost(arr));
	}
	public static int minCost(int arr[]) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int i : arr)
			minHeap.offer(i);
		int res = 0;
		while(minHeap.size() > 1) {
			int fm = minHeap.poll();
			int sm = minHeap.poll();
			int sum = fm + sm;
			res += sum;
			minHeap.offer(sum);
		}
		return res;
	}
}
