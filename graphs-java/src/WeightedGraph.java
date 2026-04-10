import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
    private int vertices;
    private List<List<GraphEdge>> adjacentList;
    public WeightedGraph(int vertices){
        this.vertices = vertices;
        adjacentList = new ArrayList<>();
        for(int i = 0;i<vertices;i++){
            adjacentList.add(new ArrayList<>());
        }
    }
    public int getVertices() {
        return vertices;
    }

    public void addUnDirectedEdge(int source, int destination, int weight){
        GraphEdge edge1 = new GraphEdge(source, destination, weight);
        adjacentList.get(source).add(edge1);
        GraphEdge edge2 = new GraphEdge(destination, source, weight);
        adjacentList.get(destination).add(edge2);
    }

    public void addDirectedEdge(int source, int destination, int weight){
        GraphEdge edge = new GraphEdge(source, destination, weight);
        adjacentList.get(source).add(edge);
    }

    public List<List<GraphEdge>> getAdjacentList(){
        return adjacentList;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= vertices) {
            throw new IllegalArgumentException("Invalid vertex: " + v);
        }
    }

    public static void main(String[] args) {

        // Create graph with 8 vertices (0 to 7)
        WeightedGraph graph = new WeightedGraph(8);

        // Add undirected edges
        graph.addUnDirectedEdge(0, 1, 4);
        graph.addUnDirectedEdge(0, 2, 3);
        graph.addUnDirectedEdge(1, 3, 2);
        graph.addUnDirectedEdge(1, 4, 7);
        graph.addUnDirectedEdge(2, 5, 4);
        graph.addUnDirectedEdge(3, 6, 1);
        graph.addUnDirectedEdge(4, 6, 3);
        graph.addUnDirectedEdge(5, 7, 6);
        graph.addUnDirectedEdge(6, 7, 2);

        // Add some directed edges
//        graph.addDirectedEdge(2, 4, 8);
//        graph.addDirectedEdge(5, 3, 5);

        // Get adjacency list
        List<List<GraphEdge>> adj = graph.getAdjacentList();

        // Print graph
        for (int i = 0; i < adj.size(); i++) {
            System.out.print("Vertex " + i + " -> ");

            for (GraphEdge edge : adj.get(i)) {
                System.out.print(
                        "(" + edge.getDestination() + ", w=" + edge.getWeight() + ") "
                );
            }
            System.out.println();
        }

        MinimumSpanningTree MST = new MinimumSpanningTree();

        List<GraphEdge> mstGraph = MST.primsAlgorithm(graph);

        int totalWeight = 0;

        System.out.println("MST Edges:");

        for (GraphEdge edge : mstGraph) {
            System.out.println(
                    edge.getSource() + " -> " +
                            edge.getDestination() +
                            " (w=" + edge.getWeight() + ")"
            );
            totalWeight += edge.getWeight();
        }

        System.out.println("Total MST Weight: " + totalWeight);
    }
}
