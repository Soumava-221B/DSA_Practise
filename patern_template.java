// "static void main" must be defined in a public class.
public class patern_template {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }
    public static void printPattern(int n) {//n = 5
        int st = 1, sp = n / 2;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sp; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= st; j++) {
                System.out.print("*");
            }
            System.out.println();
            if(i <= n / 2) {
                st += 2;
                sp--;
            }else {
                st -= 2;
                sp++;
            }
        }
    }
}
/*
5 -> 2 -> 5 / 2 = 2
  * -> sp = 2  st = 1 i = 1
 *** -> sp = 1  st = 3 i = 2
***** -> sp = 0  st = 5 i = 3
 *** -> sp = 1  st = 3 i = 4
  * -> sp = 2  st = 1 i = 5
  
  st = 1, sp = 2
  i = 3
--*
-**
***  
-**  
--*  