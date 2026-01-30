

public class Calculator {
	public static void main(String args[]) {
		System.out.println(add(2,3));
	}
	
	public static int add(int a,int b) {
		return a+b;
	}
	
	public static int subtract(int a,int b) {
		return a-b;
	}
	
	public static int multiply(int a,int b) {
		return a*b;
	}
	
	public static int divide(int a, int b) {
	    if (b == 0) {
	        throw new IllegalArgumentException("Cannot divide by zero");
	    }
	    return a / b;
	}

}
