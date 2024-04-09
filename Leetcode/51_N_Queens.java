class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        helper(n, ans, new boolean[n][n], 0, 0);
        return ans;
    }
    public void helper(int tnq, List<List<String>> ans, boolean[][] vis, int r, int c) {
        if(tnq == 0) {
            createBoard(ans, vis);
            return;
        }
        if(c == vis[0].length) {
            return;
        }
        if(isSafe(vis, r, c)) {
            vis[r][c] = true;
            helper(tnq - 1, ans, vis, r + 1, 0);
            vis[r][c] = false;
        }
        helper(tnq, ans, vis, r, c + 1);
    }
    public boolean isSafe(boolean[][] vis, int r, int c) {
        for(int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if(vis[i][j] == true) {
                return false;
            }
        }
        for(int i = r, j = c; i >= 0 && j < vis.length; i--, j++) {
            if(vis[i][j] == true) {
                return false;
            }
        }
        for(int i = r, j = c; j >= 0; j--) {
            if(vis[i][j] == true) {
                return false;
            }
        }
        for(int i = r, j = c; i >= 0; i--) {
            if(vis[i][j] == true) {
                return false;
            }
        }
        return true;
    }
    public void createBoard(List<List<String>> ans, boolean[][] vis) {
        List<String> currAns = new ArrayList<>();
        for(boolean[] arr : vis) {
            StringBuilder sb = new StringBuilder();
            for(boolean ele : arr) {
                if(ele) {
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            currAns.add(sb.toString());
        }
        ans.add(currAns);
    }
}