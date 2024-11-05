import java.util.Scanner;

public class Sub_Array_Sum {
    public static int binarySearch(int[] a, int n, int x) {
        // Hàm tìm kiếm nhị phân trong mảng đã được sắp xếp
        // Trả về chỉ số đầu tiên của phần tử x trong mảng a, hoặc -1 nếu không tìm thấy

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (a[left] == x) {
            return left;
        }
        return -1;
    }

    public static void printArray(int[] a, int l, int r) {
        // In ra các phần tử từ chỉ số l đến r trong mảng a

        for (int i = l; i <= r; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static boolean solve(int[] a, int[] b, int n, int s) {
        b[0] = a[0];

        // Tính tổng tích lũy của dãy a và lưu vào mảng b
        for (int i = 1; i < n; i++) {
            b[i] = b[i - 1] + a[i];
        }

        // Duyệt qua mảng b để tìm dãy con có tổng bằng s hoặc tổng bằng s trừ đi một phần tử của dãy
        for (int i = 0; i < n; i++) {
            if (b[i] == s) {
                // In ra dãy con có tổng bằng s
                printArray(a, 0, i);
                return true;
            }
            if (b[i] > s) {
                // Tìm chỉ số l của phần tử trong b có giá trị bằng tổng b trừ s
                int l = binarySearch(b, n, b[i] - s);
                if (l != -1) {
                    // In ra dãy con từ chỉ số l+1 đến i
                    printArray(a, l + 1, i);
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng phần tử của dãy
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        // Nhập các phần tử của dãy a
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // Nhập tổng mục tiêu
        int s = scanner.nextInt();

        // Gọi hàm solve để tìm dãy con có tổng bằng s
        boolean found = solve(a, b, n, s);

        // In ra dãy con hoặc -1 nếu không tìm thấy dãy con thỏa mãn
        if (!found) {
            System.out.println("-1");
        }

        scanner.close();
    }
}


/*
Cho số nguyên dương n, tiếp theo là n số nguyên dương của một dãy a, cuối cùng là một số s.

Hãy đưa ra dãy con liên tiếp đầu tiên của dãy a sao cho tổng của dãy đó bằng s. In dãy đó ra màn hình, 
sau mỗi phần tử có một khoảng trắng. Nếu không tồn tại dãy đó thì in ra "-1".
 */