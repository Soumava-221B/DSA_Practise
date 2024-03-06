// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int n = 3;
        printPattern(n);
    }
    public static void printPattern(int n) {//n = 3
        int st = 1, sp = 2 * n - 2;
        for(int i = 1; i <= 2 * n - 1; i++) {
            for(int j = 1; j <= st; j++) {
                System.out.print("*");
            }
            for(int j = 1; j <= sp; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= st; j++) {
                System.out.print("*");
            }
            System.out.println();
            if(i < n) {//3 < 3
                st += 1;
                sp-=2;
            }else {
                st -= 1;
                sp+=2;
            }
        }
    }
}
/*
n = 5 -> sp = 8   n * 2 - 2
*    * -> sp = 4   st = 1
**  ** -> sp = 2
****** -> sp = 0
**  ** -> sp = 2
*    * -> sp = 4

  * i = 1
 ** i = 2
*** i = 3
 ** i = 4
  * i = 5