public class xyBalance_1 {
    public static void main(String[] args) {
	boolean ans = xyBalance("aaxbby");
	System.out.print(ans);
	}
    public static boolean xyBalance(String str) {
  int y = -1;
  for (int i = 0; i < str.length(); i++) {
    if (str.charAt(i)=='y') y = i;
  }
  
  for (int i = 0; i < str.length(); i++) {
    if (str.charAt(i)=='x' && i > y) return false;
  }
  return true;

 }
}
