/*
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Return the array in the form [x1,y1,x2,y2,...,xn,yn].
*/

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2*n];
        int idx = 0;
        for(int i = 0; i < n; i++){
            arr[idx] = nums[i];
            arr[idx+1] = nums[n+i];
            idx += 2;
        }
        return arr;
    }
}