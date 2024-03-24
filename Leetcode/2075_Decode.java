/*
A string originalText is encoded using a slanted transposition cipher to a string encodedText with the help of a matrix having a fixed number of rows rows.

originalText is placed first in a top-left to bottom-right manner.
*/

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();
        if(len == 0) {
            return "";
        }
        int c = len / rows;//total number of cols  //12 / 3 = 4
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while(j < c) {
            int temp = j;
            while(temp < len) {
                sb.append(encodedText.charAt(temp));
                temp += (c + 1);
            }
            j++;
        }//idx == -1;
        String s = sb.toString();
        int n = s.length();
        while(n >= 0 && s.charAt(n - 1) == ' ') {
            n--;
        }
        
        
        return s.substring(0, n);
    }
}
//temp = 0
/*
encodedText.charAt(0) = c
encodedText.charAt(5) = i;

0 -> 5
0 + 5 = 5
0 + (4 + 1) = 5
o + (c + 1)

*/
//c (0, 0)  -> (1, 1)
//rows = 3
//ch
//cipher -> original text