import java.util.*;

public class Graph {

    private final Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public void addEdge(int origin, int destination) {
        adjacencyList.putIfAbsent(origin, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());
        adjacencyList.get(origin).add(destination);
        adjacencyList.get(destination).add(origin);
    }

    public Set<Integer> getVertices() {
        return adjacencyList.keySet();
    }

    public List<Integer> getNeighbors(int vertex) {
        return adjacencyList.getOrDefault(vertex, Collections.emptyList());
    }
}
