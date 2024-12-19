import java.util.*;

public class GraphTraversal {
    private int V; // Number of vertices
    private boolean[][] adjMatrix; // Adjacency matrix representation of the graph

    // Constructor
    public GraphTraversal(int v) {
        V = v;
        adjMatrix = new boolean[v][v];
    }

    // Function to add an edge between two vertices
    public void addEdge(int v, int w) {
        adjMatrix[v][w] = true;
        adjMatrix[w][v] = true;
    }

    // Depth-First Search (DFS) algorithm
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[V];
        DFSUtil(startVertex, visited);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < V; i++) {
            if (adjMatrix[v][i] && !visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    // Breadth-First Search (BFS) algorithm
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            for (int i = 0; i < V; i++) {
                if (adjMatrix[v][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphTraversal graph = new GraphTraversal(4);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Depth-First Search (DFS) traversal:");
        graph.DFS(2); // Starting from vertex 2

        System.out.println("\n\nBreadth-First Search (BFS) traversal:");
        graph.BFS(2); // Starting from vertex 2
    }
}
