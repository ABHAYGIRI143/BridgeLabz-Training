import java.util.Stack;

public class SortStackUsingRecursion {

    // Main sorting function
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);          // Sort remaining stack
            insertInSortedOrder(stack, top);
        }
    }

    // Insert element in correct sorted position
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {

        // Base condition
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        int top = stack.pop();
        insertInSortedOrder(stack, element);
        stack.push(top);   // Put back removed element
    }

   
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);

        System.out.println("Before Sorting: " + stack);

        sortStack(stack);

        System.out.println("After Sorting: " + stack);
    }
}
