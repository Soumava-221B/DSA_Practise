/*
Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int si = 0, ei = 0, n = s.length(), freq[] = new int[128], len = 0, flag = 0;
        while(ei < n) {
            if(freq[s.charAt(ei)] == 1) { //about to become duplicate
                flag = 1; //condition change
            } // 1 -> 2 duplicate
            freq[s.charAt(ei)]++; //included in window
            ei++; // moved ei to show that it is included
            while(flag == 1) { // until duplicate is there
                if(freq[s.charAt(si)] == 2) { // about to be removed
                    flag = 0; // immediate removal happened just after this line so no duplicate 
                }
                freq[s.charAt(si)]--; // removed from map
                si++; // physically showing updating the window to show it.
            }
            len = Math.max(len, ei - si); // perfect window, culculate answer
        }
        return len;
    }
}