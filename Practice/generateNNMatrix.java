/*
 *Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * */
package Amazon;

public class generateNNMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] =  generateMatrix(3);
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	public static int[][] generateMatrix(int n) {
        int end = n * n;
        int[][] matrix = new int[n][n];
        //dirs
        int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        int currentDir = 0;
        int r = 0, c = -1;
        int i = 1;
        while(i <= end){
            // while el != out of bound && el != 0
            int newR = r + dirs[currentDir][0];
            int newC = c + dirs[currentDir][1];
            //once filled outer layer it will move right from 1st row as the matrix[0][0] != 0
            if(newR >= 0 && newC >= 0 && newR < n && newC < n && matrix[newR][newC] == 0){
                r = newR;
                c = newC;
                matrix[r][c] = i;
                i++;
            }else{
                currentDir = (currentDir + 1)%4;
            }
        }
        return matrix;
    }

}

