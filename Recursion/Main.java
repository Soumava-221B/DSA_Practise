public class Main {
    public static void main(String[] args) {
		recursiveFunction(3);
	}
	public static void recursiveFunction(int n) {
	    if (n <= 0) {
            System.out.println("Base: " + n);
            return;
        }
        System.out.println("Enter: " + n);
        recursiveFunction(n - 1);
        System.out.println("1 Exit: " + (n - 1));
        recursiveFunction(n - 2);
        System.out.println("2 Exit: " + (n - 2));
        System.out.println("3 Exit: " + n);
	}
}
