import java.util.*;

public class DominatingSet {

    private Map<Integer, List<Integer>> graph;

    public DominatingSet() {
        this.graph = new HashMap<>();
    }

    public void addEdge(int origin, int destination) {
        graph.putIfAbsent(origin, new ArrayList<>());
        graph.putIfAbsent(destination, new ArrayList<>());
        graph.get(origin).add(destination);
        graph.get(destination).add(origin);
    }

    public Set<Integer> findDominatingSet() {
        Set<Integer> dominatingSet = new HashSet<>();
        Set<Integer> dominatedVertices = new HashSet<>();
        Integer verticesNumber = graph.size();

        while (dominatedVertices.size() < verticesNumber) {
            Integer bestVertex = -1;
            Integer bestCoverage = -1;

            for (Integer vertex : graph.keySet()) {
                Integer currentCoverage = 0;

                if (!dominatedVertices.contains(vertex)) {
                    currentCoverage++;
                }

                for (Integer neighbor : graph.get(vertex)) {
                    if (!dominatedVertices.contains(neighbor)) {
                        currentCoverage++;
                    }
                }

                if (currentCoverage > bestCoverage) {
                    bestCoverage = currentCoverage;
                    bestVertex = vertex;
                }
            }

            dominatingSet.add(bestVertex);

            dominatedVertices.add(bestVertex);
            dominatedVertices.addAll(graph.get(bestVertex));
        }

        return dominatingSet;
    }

    private static DominatingSet buildGraphExample1() {
        // 0 - 1 - 2 - 3
        //     |
        //     4

        DominatingSet graph = new DominatingSet();

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);

        return graph;
    }
}
