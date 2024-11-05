import java.util.*;

public class Queue1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        System.out.print("Nhap so pt cua mang: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap x: ");
            int x = sc.nextInt();
            q.add(x);
               
        }
        System.out.print("Nhap k: ");
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int x = q.remove();
            q.add(x);
            
        }
        while(!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        sc.close();
        
    }
}
