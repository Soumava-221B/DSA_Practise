/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, ans, "", 0, 0);
        return ans;
    }
    public void helper(int n, List<String> ans, String asf, int open, int close) {
        if(open == n && close == n) {
            ans.add(asf);
            return;
        }
        if(open <= n && close <= n && open >= close) {
            helper(n, ans, asf + "(", open + 1, close);
            helper(n, ans, asf + ")", open, close + 1);
        }
    } 
}