/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest 
palindrome
 that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
*/

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> cC= new HashMap<>();
        
        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            cC.put(c, cC.getOrDefault(c, 0) + 1);
        }
        
        int l = 0;
        boolean odd = false;
        
        // Calculate the length of the longest palindrome
        for (int count : cC.values()) {
            if (count % 2 == 0) {
                l += count;
            } else {
                l += count - 1;
                odd = true;
            }
        }
        
        // If there is at least one character with an odd count, add 1 to the length
        if (odd) {
            l += 1;
        }
        
        return l;
    }
}