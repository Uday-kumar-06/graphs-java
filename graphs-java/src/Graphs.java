import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Graphs {

//    private int vertex;

    private HashMap<Integer, List<Integer>> adjacentList;

    public Graphs(){
        this.adjacentList = new HashMap<>();
    }

    public void addVertex(int vertex){
        adjacentList.put(vertex, new LinkedList<>());
    }

    public void addEdge(int source, int destination){
        adjacentList.get(source).add(destination);
        adjacentList.get(destination).add(source);
    }

    public void removeEdge(int source, int destination){
        adjacentList.get(source).remove(destination);
        adjacentList.get(destination).remove(source);
    }

    public void removeVertex(int vertex){
        adjacentList.remove(vertex);

        for(List<Integer> list: adjacentList.values()){
            if(list.contains((Integer)vertex)){
                list.remove((Integer)vertex);
            }
        }
    }
    public void printGraph(){
        for(int vertex : adjacentList.keySet()){
            System.out.println(vertex + " -> " + adjacentList.get(vertex));
        }
    }

    public void start(){
        addVertex(1);
        addVertex(2);
        addVertex(3);
        addVertex(4);
        addVertex(5);

        addEdge(1, 4);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 3);
        addEdge(3, 5);
    }

    public HashMap<Integer, List<Integer>> getAdjacentList() {
        return adjacentList;
    }
    public static void main(String [] args){
        Graphs g = new Graphs();
        g.start();
        g.printGraph();

        DFSTraversal d = new DFSTraversal();
        d.iterativeTraversal(1,g);

        BFSTraversal b = new BFSTraversal();
        b.iterativeTraversal(1,g);
    }
}
