

import java.util.Scanner;

public class Interpolation_Search {
    public static int interpolationSearch(int[] a, int n, int x) {
        int left = 0;                       // Khởi tạo chỉ số bên trái là 0
        int right = n - 1;                  // Khởi tạo chỉ số bên phải là n - 1

        while (a[right] != a[left] && x >= a[left] && x <= a[right]) {
            // Duy trì vòng lặp cho đến khi phạm vi tìm kiếm hợp lệ và phần tử khác nhau ở hai đầu mảng
            int mid = left + (right - left) * (x - a[left]) / (a[right] - a[left]);
            // Tính chỉ số trung điểm bằng công thức tìm kiếm nội suy

            if (a[mid] < x) {
                left = mid + 1;             // Di chuyển chỉ số bên trái sang phải
            } else if (a[mid] > x) {
                right = mid - 1;            // Di chuyển chỉ số bên phải sang trái
            } else {
                if (mid > 0 && a[mid - 1] == x) {
                    right = mid - 1;        // Nếu tìm thấy phần tử trùng khác trái nhất, di chuyển chỉ số bên phải sang trái
                } else {
                    return mid;              // Trả về chỉ số nếu tìm thấy phần tử x
                }
            }
        }

        if (a[left] == x) {
            return left;                    // Trả về chỉ số nếu phần tử x nằm ở vị trí left
        }

        return -1;                          // Trả về -1 nếu không tìm thấy phần tử x trong mảng
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng phần tử của mảng
        int n = scanner.nextInt();
        int[] a = new int[n];

        // Nhập các phần tử của mảng
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // Nhập giá trị cần tìm
        int x = scanner.nextInt();

        // Gọi phương thức interpolationSearch để tìm kiếm giá trị x trong mảng
        int index = interpolationSearch(a, n, x);

        // In ra kết quả tìm kiếm
        System.out.println(index);

        scanner.close();
    }
}


/*
 Nhập vào một số nguyên dương n, tiếp theo là n số nguyên lần lượt là các phần tử trong dãy a, cuối cùng nhập số nguyên x.
Hãy đưa ra chỉ số đầu tiên của phần tử đầu tiên có giá trị bằng x, nếu không tồn tại số đó thì trả về -1
 */