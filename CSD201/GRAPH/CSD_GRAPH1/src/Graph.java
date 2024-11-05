import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
    private int[][] a;
    private String[] label;
    private int n;

    public void setAMatrix(int[][] b, int m) {
        n = m;
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(b[i], 0, a[i], 0, n);
        }
    }

    public void setLabel(String[] c) {
        label = c.clone();
    }

    public void breadthFirstTraverse(int startIndex) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        visited[startIndex] = true;
        System.out.println(label[startIndex]);

        queue.add(startIndex);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int i = 0; i < n; i++) {
                if (a[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    System.out.println(label[i]);
                    queue.add(i);
                }
            }
        }
    }

    public void depthFirstTraverse(int startIndex) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        visited[startIndex] = true;
        System.out.println(label[startIndex]);

        stack.push(startIndex);
        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            for (int i = 0; i < n; i++) {
                if (a[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    System.out.println(label[i]);
                    stack.push(i);
                }
            }
        }
    }
}
