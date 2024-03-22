class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int sr = 0, sc = 0, er = n - 1, ec = n - 1;

        while (sr <= er && sc <= ec) {
            for (int i = sc; i <= ec; i++) {
                matrix[sr][i] = count++;
            }
            sr++;

            for (int i = sr; i <= er; i++) {
                matrix[i][ec] = count++;
            }
            ec--;

            if (sr <= er) {
                for (int i = ec; i >= sc; i--) {
                    matrix[er][i] = count++;
                }
                er--;
            }

            if (sc <= ec) {
                for (int i = er; i >= sr; i--) {
                    matrix[i][sc] = count++;
                }
                sc++;
            }
        }

        return matrix;
    }
}