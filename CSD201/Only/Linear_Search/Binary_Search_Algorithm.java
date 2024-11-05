import java.util.Scanner;

public class Binary_Search_Algorithm {
    // Phương thức tìm kiếm nhị phân
    public static int Binary_Search(int a[], int n, int x) {
        int low = 0;            // Chỉ mục đầu tiên
        int high = n - 1;       // Chỉ mục cuối cùng

        while (low < high) {    // Lặp cho đến khi chỉ mục đầu tiên và cuối cùng gặp nhau
            int mid = (low + high) / 2;     // Chỉ mục giữa

            if (a[mid] < x) {    // Nếu phần tử ở vị trí giữa nhỏ hơn x
                low = mid + 1;  // Cập nhật chỉ mục đầu tiên để bỏ qua nửa dưới
            } else {
                high = mid;     // Ngược lại, cập nhật chỉ mục cuối cùng để bỏ qua nửa trên
            }
        }

        if (a[low] == x) {       // Nếu phần tử tại chỉ mục đầu tiên là x
            return low;         // Trả về chỉ mục đầu tiên
        }
        return -1;              // Ngược lại, trả về -1 (không tìm thấy x trong mảng)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();       // Nhập số phần tử trong mảng
        int a[] = new int[n];       // Khởi tạo mảng a với số phần tử đã nhập
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();    // Nhập từng phần tử của mảng
        }

        int x = sc.nextInt();       // Nhập giá trị x cần tìm
        System.out.println(Binary_Search(a, n, x));    // Gọi phương thức tìm kiếm nhị phân và in ra kết quả

        sc.close();
    }
}

/*
 Cho số nguyên dương n, tiếp theo là n số nguyên cũng một dãy a, cuối cùng là một số x, biết dãy là dãy không giảm.
Hãy đưa ra chỉ số của phần tử đầu tiên có giá trị bằng x, nếu không tồn tại giá trị đó đưa ra -1
 */
