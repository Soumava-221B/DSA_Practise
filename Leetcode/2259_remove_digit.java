/*
You are given a string number representing a positive integer and a character digit.

Return the resulting string after removing exactly one occurrence of digit from number such that the value of the resulting string in decimal form is maximized. The test cases are generated such that digit occurs at least once in number.
*/

class Solution {
    public String removeDigit(String number, char digit) {
       int index = 0;
        int n = number.length();
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                // store index of removed digit
                index = i;
                // check for leftmost digit 
                if (i < n - 1 && digit < number.charAt(i + 1)) {
                    break;
                }
            }
        }
        return number.substring(0, index) + number.substring(index + 1);
    }
}