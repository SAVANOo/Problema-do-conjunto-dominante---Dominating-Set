public class Main {

    public static void main(String[] args) {
        System.out.println("Dominating Set encontrados:");
        System.out.println("Grafo 1: " + DominatingSet.hasDominatingSetWithSizeLessThen(buildGraphExample1(), 2));
        System.out.println("Grafo 2: " + DominatingSet.hasDominatingSetWithSizeLessThen(buildGraphExample2(), 2));
        System.out.println("Grafo 3: " + DominatingSet.hasDominatingSetWithSizeLessThen(buildGraphExample3(), 2));
        System.out.println("Grafo 4: " + DominatingSet.hasDominatingSetWithSizeLessThen(buildGraphExample4(), 2));
        System.out.println("Grafo 5: " + DominatingSet.hasDominatingSetWithSizeLessThen(buildGraphExample5(), 2));
        System.out.println("Grafo 6: " + DominatingSet.hasDominatingSetWithSizeLessThen(buildGraphExample6(), 2));
        System.out.println("Grafo 7: " + DominatingSet.hasDominatingSetWithSizeLessThen(buildGraphExample7(), 2));
        System.out.println("Grafo 7: " + DominatingSet.hasDominatingSetWithSizeLessThen(buildGraphExample8(), 2));
    }

    private static Graph buildGraphExample1() {
        // 0 - 1 - 2 - 3
        //     |
        //     4

        Graph graph = new Graph();

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);

        return graph;
    }

    private static Graph buildGraphExample2() {
        //    1
        //  /   \
        // 0     2
        //  \   /
        //    3

        Graph graph = new Graph();

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);

        return graph;
    }

    private static Graph buildGraphExample3() {
        //    0
        //  / | \
        // 1  2  3
        //        \
        //         4

        Graph graph = new Graph();

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        return graph;
    }

    private static Graph buildGraphExample4() {
        // 0 — 1
        // |   |
        // 3 — 2

        Graph graph = new Graph();

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        return graph;
    }

    private static Graph buildGraphExample5() {
        // 0 — 1
        // | X |
        // 3 — 2

        Graph graph = new Graph();

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                graph.addEdge(i, j);
            }
        }

        return graph;
    }

    private static Graph buildGraphExample6() {
        //     0
        //   /   \
        //  1     2
        // / \   / \
        // 3  4  5  6

        Graph graph = new Graph();

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);

        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        return graph;
    }

    private static Graph buildGraphExample7() {
        // 0 - 1 - 2 - 3 - 4 - 5

        Graph graph = new Graph();

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        return graph;
    }

    private static Graph buildGraphExample8() {
        // 0 - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - 10

        Graph graph = new Graph();

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(9, 10);

        return graph;
    }
}
