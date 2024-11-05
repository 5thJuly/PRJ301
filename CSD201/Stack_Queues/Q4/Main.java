package Q4;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.push('D');

        stack.traverse();

        System.out.println("Top element: " + stack.top());

        char poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);

        stack.traverse();

        stack.clear();

        System.out.println("Is stack empty? " + stack.isEmpty());

        // Testing Queue
        Queue queue = new Queue(5);

        System.out.println("Is queue empty? " + queue.isEmpty());

        queue.enqueue('A');
        queue.enqueue('B');
        queue.enqueue('C');
        queue.enqueue('D');

        queue.traverse();

        System.out.println("First element: " + queue.first());

        char dequeuedElement = queue.dequeue();
        System.out.println("Dequeued element: " + dequeuedElement);

        queue.traverse();

        queue.clear();

        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}

