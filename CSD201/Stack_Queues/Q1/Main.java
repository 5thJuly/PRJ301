package Q1;

public class Main {
    public static void main(String[] args) {
        Stack s = new Stack(5);

        System.out.println("Is stack empty? " + s.isEmpty());

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        s.visit();

        System.out.println("Top element: " + s.top());

        int poppedEle = s.pop();
        System.out.println("Poped element: " + poppedEle);

        s.visit();
        s.clean();

        System.out.println("Is stack empty? " + s.isEmpty());

        int decimalNumber = 42;
        decimalToBinary(decimalNumber,s) ;
        System.out.println("Binary representation of " + decimalNumber + ": ");
        s.visit();
          
    }

    private static void decimalToBinary(int decimalNumber, Stack s) {
        while(decimalNumber > 0) {
            int rem = decimalNumber % 2;
            s.push(rem);
            decimalNumber /= 2;
        }
    }
}
