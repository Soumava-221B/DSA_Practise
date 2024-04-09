public class fibonacci2 {
    public static void main(String[] args) {
		int ans = fibonacci(3);
        System.out.println(ans);
	}
	public static int fibonacci(int n) { //n = 2
  if(n == 0) {
    return 0;
  }
  if(n == 1) {
    return 1;
  }
  int pV = fibonacci(n - 1);  // 
  int spV = fibonacci(n - 2);
  int ans = pV + spV;
  return ans;
}
	}

