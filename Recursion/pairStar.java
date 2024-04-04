/*
Given a string, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".

pairStar("hello") → "hel*lo"
pairStar("xxyy") → "x*xy*y"
pairStar("aaaa") → "a*a*a*a"
*/

public String pairStar(String str) {
  StringBuilder sb = new StringBuilder();
  helper(str, 0, sb);
  return sb.toString();
}
public void helper(String str, int idx, StringBuilder sb) {
  if(idx == str.length()) {
    return;
  }
  sb.append(str.charAt(idx));
  if(idx + 1 < str.length() && str.charAt(idx) == str.charAt(idx + 1)) {
    sb.append("*");
  }
  helper(str, idx + 1, sb);
}
