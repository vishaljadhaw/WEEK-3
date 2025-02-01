
import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int val) {
        stack1.push(val);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // Indicating queue is empty
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // Indicating queue is empty
        }
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 10
        System.out.println("Front Element: " + queue.peek()); // Output: 20
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 20
        queue.enqueue(40);
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 30
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 40
        System.out.println("Dequeued: " + queue.dequeue()); // Output: Queue is empty, -1
    }
}
