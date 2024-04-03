public class Main
{
	public static void main(String[] args) {
	    TOH(3, "S", "D", "H");
	}
	
	public static void TOH(int n, String src, String dst, String helper) {
	    if(n == 0) {
	        return;
	    }
	    
	    TOH(n-1, src, helper, dst);
	    System.out.println("Move " + n + " disk from " + src + " to " + dst);
	    TOH(n-1, helper, dst, src);
	}
}