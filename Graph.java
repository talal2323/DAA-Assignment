import java.util.*;

public class Graph {
    private int V;  // Number of vertices
    private LinkedList<Integer>[] adjList;  // Adjacency List
    private List<int[]> edgeList;  // Edge List

    public Graph(int vertices) {
        this.V = vertices;
        adjList = new LinkedList[V];
        edgeList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);  // For undirected graph

        edgeList.add(new int[]{src, dest});
    }

    public void printAdjList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " is connected to:");
            for (int j : adjList[i]) {
                System.out.print(" " + j);
            }
            System.out.println();
        }
    }

    public void printEdgeList() {
        System.out.println("Edge List:");
        for (int[] edge : edgeList) {
            System.out.println("Edge: (" + edge[0] + ", " + edge[1] + ")");
        }
    }

    public static void main(String[] args) {
        //graph with 4 vertices
        Graph graph = new Graph(4);

        // Adding edges to connect
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        // Printing the adjacency list representation of the graph
        graph.printAdjList();

        // Printing the edge list representation of the graph
        graph.printEdgeList();
}
}
