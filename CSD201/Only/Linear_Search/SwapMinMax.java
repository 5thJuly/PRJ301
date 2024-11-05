import java.util.Scanner;

public class SwapMinMax {
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

        // Find the index of the minimum and maximum elements
        int minIndex = 0;
        int maxIndex = n - 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
            if (arr[i] >= arr[maxIndex]) {
                maxIndex = i;
            }
        }

        // Swap the minimum and maximum elements
        int temp = arr[minIndex];
        arr[minIndex] = arr[maxIndex];
        arr[maxIndex] = temp;

        // Print the updated array
        System.out.print("Array after swapping: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
