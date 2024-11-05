import java.util.Scanner;

public class Count_Element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of elements
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input the elements
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input the number to count occurrences
        System.out.print("Enter the number to count occurrences: ");
        int x = sc.nextInt();

        // Count the occurrences of x
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                count++;
            }
        }

        // Print the count
        System.out.println("Number of occurrences: " + count);

        sc.close();
    }
}
