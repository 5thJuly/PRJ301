import java.util.Arrays;

class Graph {
    private int[][] adjacencyMatrix;
    private String[] labels;
    private int numVertices;

    public void setAMatrix(int[][] matrix, int n) {
        numVertices = n;
        adjacencyMatrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            System.arraycopy(matrix[i], 0, adjacencyMatrix[i], 0, numVertices);
        }
    }

    public void setLabel(String[] vertexLabels) {
        labels = vertexLabels.clone();
    }

    public void assignColors() {
        int[] colors = new int[numVertices];
        Arrays.fill(colors, -1);

        for (int vertex = 0; vertex < numVertices; vertex++) {
            boolean[] availableColors = new boolean[numVertices];
            Arrays.fill(availableColors, true);

            for (int adjacentVertex = 0; adjacentVertex < numVertices; adjacentVertex++) {
                if (adjacencyMatrix[vertex][adjacentVertex] == 1 && colors[adjacentVertex] != -1) {
                    availableColors[colors[adjacentVertex]] = false;
                }
            }

            int selectedColor = 0;
            while (!availableColors[selectedColor]) {
                selectedColor++;
            }

            colors[vertex] = selectedColor;
        }

        System.out.println("Vertex Colors:");
        for (int vertex = 0; vertex < numVertices; vertex++) {
            System.out.println(labels[vertex] + ": " + colors[vertex]);
        }
    }
}
