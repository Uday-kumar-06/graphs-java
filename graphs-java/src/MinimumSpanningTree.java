import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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

}
