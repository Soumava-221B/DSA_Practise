/*
Given a string, return the longest substring that appears at both the beginning and end of the string without overlapping. For example, sameEnds("abXab") is "ab".

sameEnds("abXYab") → "ab"
sameEnds("xx") → "x"
sameEnds("xxx") → "x"
*/

public String sameEnds(String str) {
    int max = 0;
      String ans = "";
  
      for (int i = 0; i < str.length(); i++) {
          String start = str.substring(0, i);
          String end = str.substring(str.length() - i, str.length());
          int end1 = i;
          int start2 = str.length() - i;
          if (end1 <= start2 && start.equals(end)) {
              if (start.length() > max) {
                  max = start.length();
                  ans = start;
              }
          }
      }
  
      return ans;
  }