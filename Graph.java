import java.util.*;

class Edge {
    int source, destination;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }
}

public class Graph {
    private int V;
    private LinkedList<Integer>[] adjList;
    private List<Edge> edgeList;

    public Graph(int vertices) {
        this.V = vertices;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
        edgeList = new ArrayList<>();
    }

    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source); // For undirected graph

        edgeList.add(new Edge(source, destination));
        edgeList.add(new Edge(destination, source)); // For undirected graph
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
        for (Edge edge : edgeList) {
            System.out.println("Source: " + edge.source + ", Destination: " + edge.destination);
        }
    }

    public static void main(String[] args) {
        // 4 vertices of graph
        Graph graph = new Graph(4);

        // Adding edges
        graph.addEdge(2, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 3);

        // Printing adjacency list representation
        graph.printAdjList();

        // Printing edge list representation
        graph.printEdgeList();
    }
}
