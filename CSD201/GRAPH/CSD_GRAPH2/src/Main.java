public class Main {
    public static void main(String[] args) {
        // Create an instance of the WGraph class
        WGraph wGraph = new WGraph();

        // Define the weighted matrix
        int[][] weightMatrix = {
            {0, 1, 4, 3, 0, 0, 0, 0, 0},
            {1, 0, 2, 1, 0, 0, 0, 0, 0},
            {4, 2, 0, 1, 0, 0, 0, 0, 0},
            {3, 1, 1, 0, 0, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0},
            {0, 0, 0, 2, 3, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 2},
            {0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 2, 0, 0}
        };

        // Define the labels for vertices
        String[] labels = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

        // Set the weighted matrix and labels for the graph
        wGraph.setWeightMatrix(weightMatrix, 9);
        wGraph.setLabels(labels);

        // Perform Dijkstra's shortest path algorithm starting from vertex A
        System.out.println("Dijkstra's Shortest Path:");
        wGraph.minimumSpanningTree();
    }
}
