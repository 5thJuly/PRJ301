package Q3;

public class Main {
    public static void main(String[] args) {
        // Testing Stack
        Stack stack = new Stack(5);

        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");
        stack.push("Date");

        stack.traverse();

        System.out.println("Top element: " + stack.top());

        String poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);

        stack.traverse();

        stack.clear();

        System.out.println("Is stack empty? " + stack.isEmpty());

        // Testing Queue
        Queue queue = new Queue(5);

        System.out.println("Is queue empty? " + queue.isEmpty());

        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Cherry");
        queue.enqueue("Date");

        queue.traverse();

        System.out.println("First element: " + queue.first());

        String dequeuedElement = queue.dequeue();
        System.out.println("Dequeued element: " + dequeuedElement);

        queue.traverse();

        queue.clear();

        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}