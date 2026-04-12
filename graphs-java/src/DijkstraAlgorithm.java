import java.util.*;

public class DijkstraAlgorithm {
    public int [] dijkstraAlgorithm(WeightedGraph g, int source){
        int vertices = g.getVertices();
        int [] distance = new int[vertices];
        Arrays.fill(distance,Integer.MAX_VALUE);
        PriorityQueue<GraphEdge> queue = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));
        distance[source] = 0;
        queue.add(new GraphEdge(source,source,0));

        while(!queue.isEmpty()){
            GraphEdge currentEdge = queue.poll();

            int destination = currentEdge.getDestination();
            if (currentEdge.getWeight() > distance[destination]) {
                continue;
            }
            for(GraphEdge edge: g.getAdjacentList().get(destination)){
                int newDistance = distance[destination]+ edge.getWeight();

                if(newDistance < distance[edge.getDestination()]){
                    distance[edge.getDestination()] = newDistance;
                    queue.add(new GraphEdge(edge.getSource(),edge.getDestination(),newDistance));
                }
            }
        }
        return distance;
    }
}
