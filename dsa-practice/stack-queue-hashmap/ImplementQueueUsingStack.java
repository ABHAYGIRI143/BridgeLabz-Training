import java.util.Stack;

class QueueUsingStacks {

    Stack<Integer> s1 = new Stack<>();   // For enqueue
    Stack<Integer> s2 = new Stack<>();   // For dequeue

    // Enqueue operation
    public void enqueue(int x) {
        s1.push(x);
        System.out.println("Enqueued: " + x);
    }

    // Dequeue operation
    public int dequeue() {

        // If both stacks empty → queue empty
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        // If s2 empty, transfer all from s1 to s2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    // Peek front element
    public int peek() {
        if (s1.isEmpty() && s2.isEmpty())
            throw new RuntimeException("Queue is empty!");

        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }

        return s2.peek();
    }

    // Check empty
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

// ================= Main =================
public class ImplementQueueUsingStack {
    public static void main(String[] args) {

        QueueUsingStacks q = new QueueUsingStacks();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Front: " + q.peek());      // 20
        System.out.println("Dequeued: " + q.dequeue()); // 20
    }
}
