/*
Given a string, return the length of the largest "block" in the string. A block is a run of adjacent chars that are the same.

maxBlock("hoopla") → 2
maxBlock("abbCCCddBBBxx") → 3
maxBlock("") → 0
*/

public int maxBlock(String str) {
    int maxLen = 0;
    int i = 0;
    while(i < str.length()) {
      int j = i + 1;
      while(j < str.length() && str.charAt(j) == str.charAt(i)) {
        j++;
      }
      maxLen = Math.max(maxLen, j - i);
      i = j;
    }
    return maxLen;
  }