/*
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.
*/

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        helper(m, 0, 0, n-1, n-1, "", new boolean[n][n], ans);
        return ans;
    }
    public static void helper(int[][] m, int sr, int sc, int er, int ec, String asf, boolean[][] vis, ArrayList<String> ans) {
        if(sr < 0 || sc < 0 || sr > er || sc > ec || m[sr][sc] == 0 || vis[sr][sc]) {
            return;
        }
        if(sr == er && sc == ec) {
            ans.add(asf);
            return;
        }
        vis[sr][sc] = true;
        
        helper(m ,sr - 1, sc, er, ec, asf + "U", vis,ans);
        helper(m ,sr + 1, sc, er, ec, asf + "D", vis,ans);
        helper(m ,sr, sc - 1, er, ec, asf + "L", vis,ans);
        helper(m ,sr, sc + 1, er, ec, asf + "R", vis,ans);
        
        vis[sr][sc] = false;
    }
}