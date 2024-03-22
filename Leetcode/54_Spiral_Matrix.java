class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
	   List<Integer> ans = new ArrayList<>();
	   //(0,0) (0,2), (2,0), (2,2)
	   int sr = 0, sc = 0, ec = matrix[0].length - 1, er = matrix.length - 1, count = 0, n = matrix.length, m = matrix[0].length;
	   while(count < n * m) {
	   //(0,0) to (0,2) //1, 2, 3
	   for(int r = sr, c = sc; c <= ec && count < n * m; c++) {
	     ans.add(matrix[r][c]);
	     count++;
	   }
	   //mover from 3 to 6 (0,2) to (1,2)
	   sr++;
	   //(1, 2) to (2, 2) //6, 9
	   for(int r = sr, c = ec; r <= er && count < n * m; r++) {
	     ans.add(matrix[r][c]);
	     count++;
	   }
	   //move from 9 to 8
	   //(2,2) to (2,1)
	   ec--;
	   //(2,1) to (2,0) //8,7
	   for(int r = er, c = ec; c >= sc && count < n * m; c--) {
	     ans.add(matrix[r][c]);
	     count++;
	   }
	   //move from 7 to 4
	   //(2, 0) to (1,0);
	   er--;
	   //(1, 0) to (1, 1) //4, 5
	   for(int r = er, c = sc; r >= sr && count < n * m; r--) {
	     ans.add(matrix[r][c]);
	     count++;
	   }
	   sc++;
	   }
	   return ans;
	}
}