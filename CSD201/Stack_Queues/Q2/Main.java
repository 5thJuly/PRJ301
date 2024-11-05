package Q2;

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.traverse();

        //System.out.println("First element: " + q.first());
        
        int dequeuedElement = q.dequeue();
        System.out.println("Dequeued element: " + dequeuedElement);
        
        q.traverse();
        
        q.clean();
        
        System.out.println("Is queue empty? " + q.isEmpty());
        
        double decimalNumber = 0.625;
        String binaryNumber = decimalToBinary(decimalNumber);
        System.out.println(decimalNumber + " in binary: " + binaryNumber);
    }
    public static String decimalToBinary(double number) {
        Queue queue = new Queue(32); // Assuming a maximum of 32-bit binary representation
        StringBuilder binary = new StringBuilder();
        
        while (number > 0) {
            number *= 2;
            int bit = (int) number;
            queue.enqueue(bit);
            number -= bit;
        }
        
        while (!queue.isEmpty()) {
            binary.append(queue.dequeue());
        }
        
        return binary.toString();
    }
}
