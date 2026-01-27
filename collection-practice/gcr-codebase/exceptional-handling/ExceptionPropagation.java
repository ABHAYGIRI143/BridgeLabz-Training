public class ExceptionPropagation {

    static void method1() {
        int result = 10 / 0;   // ArithmeticException
    }

    static void method2() {
        method1();            // exception propagates to caller
    }

    public static void main(String[] args) {

        try {
            method2();        // exception propagates here
        }
        catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}
