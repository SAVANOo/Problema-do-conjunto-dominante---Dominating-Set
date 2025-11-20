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

    public static void main(String[] args) {
        System.out.println("Dominating Set encontrados:");
        System.out.println("Grafo 1: " + buildGraphExample1().findDominatingSet());
        System.out.println("Grafo 2: " + buildGraphExample2().findDominatingSet());
        System.out.println("Grafo 3: " + buildGraphExample3().findDominatingSet());
        System.out.println("Grafo 4: " + buildGraphExample4().findDominatingSet());
        System.out.println("Grafo 5: " + buildGraphExample5().findDominatingSet());
        System.out.println("Grafo 6: " + buildGraphExample6().findDominatingSet());
        System.out.println("Grafo 7: " + buildGraphExample7().findDominatingSet());
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

    private static DominatingSet buildGraphExample2() {
        //    1
        //  /   \
        // 0     2
        //  \   /
        //    3

        DominatingSet graph = new DominatingSet();

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);

        return graph;
    }

    private static DominatingSet buildGraphExample3() {
        //    0
        //  / | \
        // 1  2  3
        //        \
        //         4

        DominatingSet graph = new DominatingSet();

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        return graph;
    }

    private static DominatingSet buildGraphExample4() {
        // 0 — 1
        // |   |
        // 3 — 2

        DominatingSet graph = new DominatingSet();

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        return graph;
    }

    private static DominatingSet buildGraphExample5() {
        // 0 — 1
        // | X |
        // 3 — 2

        DominatingSet graph = new DominatingSet();

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                graph.addEdge(i, j);
            }
        }

        return graph;
    }

    private static DominatingSet buildGraphExample6() {
        //     0
        //   /   \
        //  1     2
        // / \   / \
        // 3  4  5  6

        DominatingSet graph = new DominatingSet();

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);

        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        return graph;
    }


    private static DominatingSet buildGraphExample7() {
        // 0 - 1 - 2 - 3 - 4 - 5

        DominatingSet graph = new DominatingSet();

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        return graph;
    }
}
