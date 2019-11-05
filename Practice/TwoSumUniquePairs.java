/*
 * Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target. Return the number of pairs.
 * */
package Amazon;
import java.util.*;
public class twoSumUniquePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getUniquePairsOpti(new int[] {1,1}, 2));

	}
	public static int getUniquePairsOpti(int[] nums, int target){
	    Set<Integer> seen =  new HashSet<>();
	    Map<Integer, Integer> map = new HashMap<>();
	    int ans = 0;
	    for (int num : nums){
	        if (map.containsKey(num)){

	            //int key = map.get(num)*10 + num;
	        	//if the set contains the num already that means i have increamented ans already,
	        	// only go inside you u see the Key for first time
	            if (! seen.contains(num)){
	                ans++;
	                seen.add(num);
	            }
	        } else {
	            map.put(target-num, num);
	        }
	    }
	    return ans;

	}

}

