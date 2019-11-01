/*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.*/

class MinimumPathSum {
    
    public int cost(int[][] mem,int[][] grid,int row,int col){
        int rowS = grid.length;
        int colS = grid[0].length;
        
       
        if(row > rowS-1 ||col > colS-1 ){
           return Integer.MAX_VALUE;
        }
        
        if(rowS-1 == row && colS-1 == col ){
            return grid[row][col];
        }
        
        if(mem[row][col] != 0){
            return mem[row][col];
        }
         
        mem[row][col] = Math.min(cost(mem,grid,row+1,col) , cost(mem,grid,row,col+1)) + grid[row][col];
        
        return mem[row][col];
        
    }
    
    
    public int minPathSum(int[][] grid) {
         int[][] mem = new int[grid.length][grid[0].length];
         return cost(mem,grid,0,0);   
    }
}