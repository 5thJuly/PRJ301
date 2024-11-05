import java.util.Arrays;

public class WGraph {
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
        this.labels = Arrays.copyOf(labels, numVertices);
    }

   public void dijkstraShortestPath(int startIndex) {
        int[] distance = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[startIndex] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            Integer minVertex = findMinVertex(distance, visited);
            if (minVertex == null) {
                break; // No unvisited vertex found
            }
            visited[minVertex] = true;

            for (int j = 0; j < numVertices; j++) {
                if (weightMatrix[minVertex][j] != 0 && !visited[j]) {
                    int newDistance = distance[minVertex] + weightMatrix[minVertex][j];
                    if (newDistance < distance[j]) {
                        distance[j] = newDistance;
                    }
                }
            }
        }

        System.out.println("Shortest distances from vertex " + labels[startIndex] + ":");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(labels[i] + ": " + distance[i]);
        }
    }



    private Integer findMinVertex(int[] distance, boolean[] visited) {
    int minVertex = -1;
    int minDistance = Integer.MAX_VALUE;
    for (int i = 0; i < numVertices; i++) {
        if (!visited[i] && distance[i] < minDistance) {
            minVertex = i;
            minDistance = distance[i];
        }
    }
    
    if (minVertex == -1) {
        return null;
    }
    
    return minVertex;
}

}
