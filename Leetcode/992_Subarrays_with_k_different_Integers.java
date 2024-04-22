/*
 Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length
*/

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k - 1);
    }
    public int atmost(int[] nums, int k) {
        int freq[] = new int[nums.length - 0 + 1], count = 0, si = 0, ei = 0;
        while(ei < nums.length) {
            if(freq[nums[ei]] == 0) {
                k--;
            }
            freq[nums[ei]]++;
            ei++;
            while(k < 0) {
                if(freq[nums[si]] == 1) {
                    k++;
                }
                freq[nums[si]]--;
                si++;
            }
            //i have ensured that here all subarray have atmost k distinct
            count += (ei - si);
        }
        return count;
    }
}