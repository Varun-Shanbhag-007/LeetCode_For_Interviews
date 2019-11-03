/*
Number Of clusters
*/
class Solution {
    public int numIslands(char[][] grid) {
        int noOfIslands = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == '1'){
                    setZeroes(grid, r, c);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }
    public void setZeroes(char[][] grid, int i, int j){
        if(i  < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        setZeroes(grid, i + 1, j);
        setZeroes(grid, i, j + 1);
        setZeroes(grid, i - 1, j);
        setZeroes(grid, i, j - 1);

    }
}
