import java.util.Arrays;

class WGraph {
    private int[][] weightMatrix;
    private String[] labels;
    private int numVertices;

    public void setWeightMatrix(int[][] matrix, int numVertices) {
        this.numVertices = numVertices;
        weightMatrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            System.arraycopy(matrix[i], 0, weightMatrix[i], 0, numVertices);
        }
    }

    public void setLabels(String[] labels) {
        this.labels = labels.clone();
    }

   public void minimumSpanningTree() {
    boolean[] visited = new boolean[numVertices];
    int[] parent = new int[numVertices];
    int[] key = new int[numVertices];
    Arrays.fill(key, Integer.MAX_VALUE);

    key[0] = 0; // Start with the first vertex
    parent[0] = 0; // First vertex is the root of MST

    for (int i = 0; i < numVertices - 1; i++) {
        int minVertex = findMinKeyVertex(key, visited);
        visited[minVertex] = true;

        for (int j = 0; j < numVertices; j++) {
            if (weightMatrix[minVertex][j] != 0 && !visited[j] && weightMatrix[minVertex][j] < key[j]) {
                parent[j] = minVertex;
                key[j] = weightMatrix[minVertex][j];
            }
        }
    }

    System.out.println("Minimum Spanning Tree:");
    for (int i = 1; i < numVertices; i++) {
        System.out.println(labels[parent[i]] + " - " + labels[i]);
    }
}

    private int findMinKeyVertex(int[] key, boolean[] visited) {
        int minVertex = -1;
        int minKey = Integer.MAX_VALUE;
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && key[i] < minKey) {
                minVertex = i;
                minKey = key[i];
            }
        }
        return minVertex;
    }
}
