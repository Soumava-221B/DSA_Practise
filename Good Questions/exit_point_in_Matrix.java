/*
Given a matrix of size n x m with 0’s and 1’s , you enter the matrix at cell (0,0) in left to right direction. Whenever you encounter a 0 you retain in same direction , else if you encounter a 1’s you have to change direction to right of current direction and change that 1 value to 0, you have to find out from which index you will leave the matrix at the end.
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().split(" ");
                for(int j = 0; j < m; j++){
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(matrix);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] FindExitPoint(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] direction = {0, 1}; // Initial direction: right
        int[] currentCell = {0, 0}; // Initial position
        int[] nextCell = {0, 0}; // Next position

        while (true) {
            int x = currentCell[0];
            int y = currentCell[1];

            if (matrix[x][y] == 1) {
                matrix[x][y] = 0; // Change 1 to 0
                direction = newDirection(direction); // Change direction to right of current direction
            }

            nextCell[0] = x + direction[0];
            nextCell[1] = y + direction[1];

            if (nextCell[0] < 0 || nextCell[0] >= n || nextCell[1] < 0 || nextCell[1] >= m) {
                // If next cell is out of bounds, return current cell
                return currentCell;
            }

            currentCell[0] = nextCell[0];
            currentCell[1] = nextCell[1];
        }
    }

    private int[] newDirection(int[] direction) {
        // Change direction to right of current direction
        if (direction[0] == 0 && direction[1] == 1) {
            return new int[]{1, 0}; // Down
        } else if (direction[0] == 1 && direction[1] == 0) {
            return new int[]{0, -1}; // Left
        } else if (direction[0] == 0 && direction[1] == -1) {
            return new int[]{-1, 0}; // Up
        } else {
            return new int[]{0, 1}; // Right
        }
    }
}