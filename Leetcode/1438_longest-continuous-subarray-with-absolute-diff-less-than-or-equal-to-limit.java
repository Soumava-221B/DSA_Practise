/*
Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.

 

Example 1:

Input: nums = [8,2,4,7], limit = 4
Output: 2 
Explanation: All subarrays are: 
[8] with maximum absolute diff |8-8| = 0 <= 4.
[8,2] with maximum absolute diff |8-2| = 6 > 4. 
[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
[2] with maximum absolute diff |2-2| = 0 <= 4.
[2,4] with maximum absolute diff |2-4| = 2 <= 4.
[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
[4] with maximum absolute diff |4-4| = 0 <= 4.
[4,7] with maximum absolute diff |4-7| = 3 <= 4.
[7] with maximum absolute diff |7-7| = 0 <= 4. 
Therefore, the size of the longest subarray is 2.
Example 2:

Input: nums = [10,1,2,4,7,2], limit = 5
Output: 4 
Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
Example 3:

Input: nums = [4,2,2,2,4,4,2,2], limit = 0
Output: 3
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
0 <= limit <= 109
*/

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxq = new ArrayDeque<>();
        Deque<Integer> minq = new ArrayDeque<>();
        int n = nums.length;
        int j = 0;
        int ans = 0;
        for(int i = 0; i < n; i ++){
            while(!maxq.isEmpty() && nums[i] > maxq.peekLast())
                maxq.pollLast();
            maxq.addLast(nums[i]);
            while(!minq.isEmpty() && nums[i] < minq.peekLast()){
                minq.pollLast();
            }
            minq.addLast(nums[i]);
            if(maxq.peekFirst() - minq.peekFirst() > limit){
                if(nums[j] == maxq.peekFirst()) maxq.pollFirst();
                if(nums[j] == minq.peekFirst()) minq.pollFirst();
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
