import java.util.*;

public class BFSTraversal {
    public void iterativeTraversal(int startVertex, Graphs g){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        HashMap<Integer, List<Integer>> adjacentList = g.getAdjacentList();
        queue.add(startVertex);
        visited.add(startVertex);
        while(!queue.isEmpty()){
            int currentVertex = queue.poll();
                System.out.print(currentVertex + " ");
                for(Integer neighbor: adjacentList.getOrDefault(currentVertex,new LinkedList<>())) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
        }
    }
}
