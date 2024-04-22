/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int req[] = new int[128], si = 0, ei = 0, requirement = p.length(), n = s.length();
        for(int i = 0; i < p.length(); i++) 
            req[p.charAt(i)]++;
        while(ei < n) {
            if(req[s.charAt(ei)] > 0)
                requirement--;
            req[s.charAt(ei)]--;
            ei++;
            while(requirement == 0) {
                if(ei - si == p.length()) {
                    ans.add(si);
                }
                if(req[s.charAt(si)] == 0)
                    requirement++;
                req[s.charAt(si)]++;
                si++;
            }
        }
        return ans;
    }
}