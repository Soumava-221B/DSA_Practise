public class bunnyEars02 {
    public static void main(String[] args) {
		int ans = bunnyEars2(3);
        System.out.println(ans);
	}

    public static int bunnyEars2(int bunnies) {
  if(bunnies == 0) {
    return 0;
  }
  int sp = bunnyEars2(bunnies - 1);
  if(bunnies%2 == 0){
    return sp + 3;
  }else {
    return sp + 2;
  }
  
}
}
