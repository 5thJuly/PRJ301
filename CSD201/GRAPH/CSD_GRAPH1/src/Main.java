public class Main {
    public static void main(String[] args) {
        // Create an instance of the Graph class
        Graph graph = new Graph();

        // Define the adjacency matrix
        int[][] adjacencyMatrix = {
                {0, 1, 1, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0}
        };

        // Define the labels for vertices
        String[] labels = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

        // Set the adjacency matrix and labels for the graph
        graph.setAMatrix(adjacencyMatrix, 9);
        graph.setLabel(labels);

        // Perform breadth-first traversal starting from vertex A
        System.out.println("Breadth-First Traversal:");
        graph.breadthFirstTraverse(0);
        System.out.println();

        // Perform depth-first traversal starting from vertex A
        System.out.println("Depth-First Traversal:");
        graph.depthFirstTraverse(0);
        System.out.println();
    }
}
