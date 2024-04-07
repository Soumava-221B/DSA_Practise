/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]

 

Constraints:

    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.


*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> main = new ArrayList<>();
        permute(main, nums, new ArrayList<>(), new boolean[nums.length], 0);
        return main;
    }
    public void permute(List<List<Integer>> main, int[] nums, List<Integer> temp, boolean[] vis, int idx) {
        if(idx == nums.length) {
            if(temp.size() == nums.length) {
                main.add(new ArrayList<>(temp));
            }
            return;
        }
        if(!vis[idx]) {
            vis[idx] = true;
            temp.add(nums[idx]);
            permute(main, nums, temp, vis, 0);
            vis[idx] = false;
            temp.remove(temp.size() - 1);
        }
        permute(main, nums, temp, vis, idx + 1);
        
    }
}