/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.
*/

class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1, idx = 0;
        while (idx <= p2) {
            if (nums[idx] == 0) {
                swap(nums, idx, p0);
                p0++;
                idx++;
            } else if (nums[idx] == 2) {
                swap(nums, idx, p2);
                p2--;
            } else {
                idx++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}