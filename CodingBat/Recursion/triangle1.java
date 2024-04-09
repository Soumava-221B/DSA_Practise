import java.util.Scanner;
public class triangle1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of rows");
        int n = sc.nextInt();
		int ans = triangle(n);
        System.out.println(ans);
        sc.close();
	}

    public static int triangle(int rows) { // rows = 3
  if(rows == 0) {
    return 0;
  }
  int sp = triangle(rows - 1);
  return sp + rows;
}
}
