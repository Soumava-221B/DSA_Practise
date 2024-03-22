class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int ans[] = new int[n * m];
        int i = 0, j = 0, idx = 0;
        String dir = "du";
        while(idx < n * m) {
            if(i == 3) {
                System.out.println(i + " " + "0");
            }else if(j == 3) {
                System.out.println(j + " " + "1");
            }
            ans[idx] = mat[i][j];
            idx++;
            if(dir.equals("du")) {
                if(j == m - 1) {//(0, 2) -> (1, 2)
                    i++;
                    dir = "dd";
                }
                else if(i == 0) {//(0, 0) -> (0, 1)  dir change du dd
                    dir = "dd";
                    j++;
                }
                else {//remaining
                    i--;
                    j++;
                }
            }else {
                if(i == n - 1) {
                    j++;
                    dir = "du";
                }
                else if(j == 0) {
                    dir = "du";
                    i++;
                }else {
                    i++;
                    j--;
                }
            }
        }
        return ans;
    }
}
/*
(i, j)
du
(0, 0) => 1 

dir change 

dd
(0, 1) => 2
(1, 0) => 4

dir change 
du
(2, 0) => 7
(1, 1) => 5
(0, 2) => 3

dir change
dd
(1, 2)
}
*/