import java.util.*;

public class DFSTraversal {
    public void iterativeTraversal(int startVertex, Graphs g){
        HashMap<Integer, List<Integer>> adjacentList= g.getAdjacentList();
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        stack.push(startVertex);
        while(!stack.isEmpty()){
            int currentVertex = stack.pop();
            if(!visited.contains(currentVertex)){
                visited.add(currentVertex);
                System.out.print(currentVertex+" ");
                for(Integer neighbor: adjacentList.getOrDefault(currentVertex,new LinkedList<>())){
                    if(!visited.contains(neighbor)){
                        stack.push(neighbor);
                    }
                }
            }

        }
    }
}
