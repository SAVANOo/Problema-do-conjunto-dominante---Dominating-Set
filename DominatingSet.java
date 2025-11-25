import java.util.*;

public class DominatingSet {

    public static Boolean hasDominatingSetWithSizeLessThen(Graph graph, Integer size) {
        return findDominatingSet(graph).size() <= size;
    }

    public static Set<Integer> findDominatingSet(Graph graph) {
        Set<Integer> dominatingSet = new HashSet<>();
        Set<Integer> dominatedVertices = new HashSet<>();

        Set<Integer> vertices = graph.getVertices();
        Integer verticesNumber = vertices.size();

        while (dominatedVertices.size() < verticesNumber) {
            Integer bestVertex = null;
            Integer bestCoverage = -1;

            for (Integer vertex : vertices) {
                Integer currentCoverage = 0;

                if (!dominatedVertices.contains(vertex)) {
                    currentCoverage++;
                }

                for (Integer neighbor : graph.getNeighbors(vertex)) {
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
            dominatedVertices.addAll(graph.getNeighbors(bestVertex));
        }

        return dominatingSet;
    }
}
