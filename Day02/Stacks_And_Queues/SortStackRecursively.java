import java.util.Stack;

public class SortStackRecursively {
    
    // Function to sort a stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop(); // Remove the top element
            sortStack(stack); // Sort the remaining stack
            insertSorted(stack, top); // Insert the removed element in sorted order
        }
    }
    
    // Helper function to insert an element at the correct position
    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int top = stack.pop(); // Remove the top element
            insertSorted(stack, element); // Recursive call
            stack.push(top); // Push the top element back
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);
        
        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
