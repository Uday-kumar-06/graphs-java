import java.util.*;

public class MinimumSpanningTree {

    public List<GraphEdge> primsAlgorithm(WeightedGraph g){
        PriorityQueue<GraphEdge> queue = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));
        int vertices = g.getVertices();

        List<GraphEdge> MSTEdge = new ArrayList<>();

        boolean [] visitedDestination = new boolean[vertices];
        int startIndex = 0;
        visitedDestination[startIndex] = true;
        for(GraphEdge edge: g.getAdjacentList().get(startIndex)){
            queue.add(edge);
        }

        while(!queue.isEmpty() && MSTEdge.size()< vertices-1){
            GraphEdge currentIndex = queue.poll();
            int destination = currentIndex.getDestination();
            if(visitedDestination[destination] == true){
                continue;
            }
            visitedDestination[destination]= true;
            MSTEdge.add(currentIndex);
            for(GraphEdge edge: g.getAdjacentList().get(destination)){
                if(visitedDestination[edge.getDestination()] != true){
                    queue.add(edge);
                }
            }

        }

        return MSTEdge;
    }

    public List<GraphEdge> kruskalAlgorithm(WeightedGraph g){
        PriorityQueue<GraphEdge> queue = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));
        int vertices = g.getVertices();
        List<GraphEdge> graphEdges = new ArrayList<>();
        List<GraphEdge> mstGraph = new ArrayList<>();
        for(int i =0;i<vertices;i++){
            for(GraphEdge edge: g.getAdjacentList().get(i)){
                if(edge.getSource()< edge.getDestination()){
                    graphEdges.add(edge);
                }
            }
        }

        for(GraphEdge edge: graphEdges){
            queue.add(edge);
        }

        int parent [] = new int[vertices];
        for(int i = 0;i<vertices;i++){
            parent[i] = i;
        }
        while(!queue.isEmpty() && mstGraph.size()< vertices-1){
            GraphEdge currentEdge = queue.poll();
            int source = currentEdge.getSource();
            int destination = currentEdge.getDestination();
            if(!cycleCheck(parent,source,destination)){
                continue;
            }
            mstGraph.add(currentEdge);
        }

        return mstGraph;
    }

    private boolean cycleCheck(int[] parent, int source, int destination) {
        int srcRoot  = find(parent, source);
        int destRoot = find(parent, destination);

        if (srcRoot != destRoot) {
            parent[destRoot] = srcRoot;  // attach entire group, not just one node
            return true;
        }
        return false;
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]); // climb to root
        }
        return parent[node];
    }

}
