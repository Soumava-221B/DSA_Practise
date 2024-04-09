// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }
    public static void printPattern(int n) {
        int st = n, sp = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= st; j++) {
                System.out.print("*");
            }
            System.out.println();
            st--;
        }
    }
}

/*
*****
****
***
**
*
*/