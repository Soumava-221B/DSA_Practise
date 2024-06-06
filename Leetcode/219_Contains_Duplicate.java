/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // declare hashset wthat will hold window
        Set<Integer> window = new HashSet<Integer>();
        // iterate over nums array
        for(int i = 0; i < nums.length; i++) {
            // check if current index is greater than k, if true then on each iteration remove leftmost element from set
            if(i > k) window.remove(nums[i - k - 1]);
            // try to add element to our window add method will return false if element already in the set, if it's in the set return true
            if(!window.add(nums[i])) return true;
        }
        // return false at the end
        return false;
    }
}