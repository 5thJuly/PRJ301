import java.util.*;

public class SuperPrimeNumber {

  public static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
      
    }
    return true;
    
  }

  public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap n: ");
    int n = sc.nextInt();

    for (int i = 2; i <= n && i<10 ; i++) {
        if (isPrime(i)) {
          q.add(i);
      }
    }
    while(!q.isEmpty()) {
        for (int i = 0; i <= 9; i++) {
            int k = q.peek()*10 + i ;
            if(k <=n && isPrime(k)) {
                q.add(q.peek()*10 + i);
            }
        }
        System.out.print(q.peek() + " ");
        q.remove();
    }
    sc.close();
    
  }
}

/*
 Hàm `peek()` trong cấu trúc dữ liệu queue được sử dụng để truy cập phần tử đầu tiên của hàng đợi (queue) mà không xóa nó khỏi queue. 
 Nghĩa là hàm `peek()` sẽ trả về giá trị của phần tử đầu tiên trong queue, nhưng không xóa nó khỏi queue. 

Hàm `peek()` thường được sử dụng để kiểm tra xem hàng đợi có chứa phần tử hay không, hoặc để lấy giá trị của phần tử đầu tiên để thực hiện 
một số tính toán mà không làm thay đổi hàng đợi.
 */

 /*
  Hàm add() được sử dụng để thêm một phần tử vào cuối của một cấu trúc dữ liệu đặc biệt, được gọi là Queue.

Queue là một cấu trúc dữ liệu tuyến tính được sử dụng để lưu trữ một tập hợp các phần tử theo cơ chế First-In-First-Out (FIFO). 
Vì vậy, phần tử đầu tiên được thêm vào Queue sẽ được loại bỏ trước phần tử được thêm sau cùng.
  
*/
