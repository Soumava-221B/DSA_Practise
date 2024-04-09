// Find the index of start and end of subarray
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        String str = "cccatcowcatxx";
        String sub = "cat";
        int[] indexes = strDist(str, sub, 0, str.length() - 1);
        System.out.println(indexes[0] + " " + indexes[1]);
    }                          //012345678
    public static int[] strDist(String str, String sub, int si, int ei) {
  if(str.length() < sub.length()) {
    return new int[]{-1, -1};
  }//catcowcat   -> str.substring(6, 9)
  if(str.substring(0, sub.length()).equals(sub) && str.substring(str.length() - sub.length(), str.length()).equals(sub)) {
    return new int[]{si, ei};
  }
  //that means either starting not equal or ending not equal to sub or both
  if(!str.substring(0, sub.length()).equals(sub)) {
    return strDist(str.substring(1), sub, si + 1, ei);//moved from start char
  }
  return strDist(str.substring(0, str.length() - 1), sub, si, ei - 1);// str.substring(0, 8)
}

//ccatcowcattt

}