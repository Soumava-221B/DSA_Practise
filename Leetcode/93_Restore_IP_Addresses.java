/*
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

    For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.

Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

 

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]

Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]

Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

 

Constraints:

    1 <= s.length <= 20
    s consists of digits only.


*/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(ans, s, "", 0, 0);
        return ans;
    }
    public void helper(List<String> ans , String s, String asf, int idx, int dots) {
        if(idx == s.length() || dots == 4) {
            if(isValid(asf)) {
                ans.add(asf);
            }
            return;
        }
        helper(ans, s, asf += s.charAt(idx), idx + 1, dots);
        helper(ans, s, asf += ".", idx + 1, dots + 1);
    }
    public boolean isValid(String str) {
        if(str.length() == 0) {
            return false;
        }
        if(str.charAt(str.length() - 1) == '.') {
            return false;
        }
        String temp = "";
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '.') {
                count++;
                if(temp.length() > 3 || temp.length() == 0) {
                    return false;
                }
                if(temp.length() != 1 && temp.charAt(0) == '0') {
                    return false;
                }
                if(Integer.valueOf(temp) < 0 || Integer.valueOf(temp) > 255) {
                    return false;
                }
                temp = "";
            }else {
                temp += str.charAt(i);
            }
        }
        if(temp.length() > 3 || temp.length() == 0) {
            return false;
        }
        if(temp.length() != 1 && temp.charAt(0) == '0') {
            return false;
        }
        if(Integer.valueOf(temp) < 0 || Integer.valueOf(temp) > 255) {
            return false;
        }
        if(count != 3) {
            return false;
        }
        return true;
    }
}
//              i
//255.255.11.135
//temp = "135"
//c = 3