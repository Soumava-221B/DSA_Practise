/*
 Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

class Solution {//key, value   //ele -> freq of that ele on the rig
    public int[] topKFrequent(int[] nums, int k) {//leftside  values get rightSide
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->  map.get(b) - map.get(a));
        for(int cKey : map.keySet()) {//[1, 2, 3]////value add -> a   value on top -> B
            pq.add(cKey);//map.get(1) = 3     //map.get(2) = 2;
        }
        int[] ans = new int[k];
        int idx = 0;
        while(k-- > 0) {
            ans[idx++] = pq.remove();
        }
        return ans;
    }
}
//HashSet<Integer> arr = new HashSet<>();
//requirement -> I want to order the elements in Decreasing Order of their Frequency so that I get the biggest frequency on top
/*
Min Max
[//top of the priority queu min elem
10  node1 -> node2 -> node4 





]
*/