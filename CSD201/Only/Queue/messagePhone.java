import java.util.*;

public class messagePhone{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<Integer>();
        System.out.print("Nhap so phan tu cua mang n: ");
        int n = sc.nextInt();
        Boolean[] b = new Boolean[1001];
        int[] a = new int[1001];
        for (int i = 0; i < 1001; i++) {
            b[i] = false;// khởi tạo tất cả các phần tử trong mảng boolean b là false
        }
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.print("Nhap k: ");
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if(!b[a[i]]) {
                if(q.size() < k) {
                    b[a[i]] = true;
                    q.add(a[i]);
                }
                else{
                    b[q.peek()] = false;
                    b[a[i]] = true;
                    q.add(a[i]);
                    q.remove();
                }
            }
            
        }
        while(!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
        sc.close();
    }
}