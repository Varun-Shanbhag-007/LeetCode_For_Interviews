/*
Given a matrix with r rows and c columns, find the maximum score of a path starting at [0, 0] and ending at [r-1, c-1]. The score of a path is the minimum value in that path. For example, the score of the path 8 → 4 → 5 → 9 is 4.

Don't include the first or final entry. You can only move either down or right at any point in time.

Example 1:

Input:
[[5, 1],
 [4, 5]]

Output: 4
Explanation:
Possible paths:
5 → 1 → 5 => min value is 1
5 → 4 → 5 => min value is 4
Return the max value among minimum values => max(4, 1) = 4.
Example 2:

Input:
[[1, 2, 3]
 [4, 5, 1]]

Output: 4
Explanation:
Possible paths:
1-> 2 -> 3 -> 1
1-> 2 -> 5 -> 1
1-> 4 -> 5 -> 1
So min of all the paths = [2, 2, 4]. Note that we don't include the first and final entry.
Return the max of that, so 4.*/
public class PathWithMaximumScore {
    public static void main(String[] args) {
        int[][] grid1 = new int[][] { {5, 1}, 
                                     {4, 5} };                        // 4
        int[][] grid2 = new int[][] { {5, 1, 7}, 
                                     {4, 8, 5} };                  // 4
        int[][] grid3 = new int[][] { {1, 9, 9}, 
                                     {9, 9, 9}, 
                                     {9, 9, 9} };       // 1 is wrong, shapp be 9
        int[][] grid4 = new int[][] { {10, 7, 3}, 
                                     {12, 11, 9}, 
                                     {1, 2, 8} };    // 8 is wrong, shall be 9
        int[][] grid5 = new int[][] { {20, 20, 3}, 
                                     {20, 3, 20}, 
                                     {3, 20, 20} }; // 3
        
        int[][] grid6 = new int[][] { {1, 2, 3}, 
                                     {4, 5, 1}}; // 4

        System.out.println("grid1: Expected: 4, Actual: " + maxScore(grid1));
        System.out.println("grid2: Expected: 4, Actual: " + maxScore(grid2));
        System.out.println("grid3: Expected: 9, Actual: " + maxScore(grid3));
        System.out.println("grid4: Expected: 9, Actual: " + maxScore(grid4));
        System.out.println("grid5: Expected: 3, Actual: " + maxScore(grid5));
        System.out.println("grid6: Expected: 4, Actual: " + maxScore(grid6));
    }
  

    
    public static int maxScore(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        
        grid[m-1][n-1] = Integer.MAX_VALUE;
        
        //opt[i][j] = Min(Max(opt[i-1][j], opt[i][j-1]), grid[i][j]）
        int[][] opt = new int[m][n];
        opt[0][0] = Integer.MAX_VALUE;  //very important
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i==0 && j==0) continue;
                int upper = i==0 ? Integer.MIN_VALUE : opt[i-1][j];
                int left = j==0 ? Integer.MIN_VALUE : opt[i][j-1];
                opt[i][j] = Math.min(grid[i][j], Math.max(upper, left));
            }
        }
        return opt[m-1][n-1];
    }    
    
}


