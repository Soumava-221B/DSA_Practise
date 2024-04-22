/*
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
*/

class Solution {
    public String minWindow(String s, String t) {
        int req[] = new int[128], si = 0, ei = 0, h = -1, minLen = (int)(1e8), requirement = t.length(); 
        for(int i = 0; i < t.length(); i++) {
            req[t.charAt(i)]++;
        }
        while(ei < s.length()) {
            if(req[s.charAt(ei)] > 0) {
                requirement--;
            }
            req[s.charAt(ei)]--;
            ei++;
            while(requirement == 0) {
                if(ei - si < minLen) {
                    minLen = ei - si;
                    h = si;
                }
                if(req[s.charAt(si)] == 0) {
                    requirement++;
                }
                req[s.charAt(si)]++;
                si++;
            }
        }
        return minLen == (int)(1e8) ? "" : s.substring(h, h + minLen);
    }
}