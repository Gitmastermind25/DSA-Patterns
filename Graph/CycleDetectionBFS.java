package Graph;

import java.util.*;

public class CycleDetectionBFS {

    static boolean bfs(int start,
                       ArrayList<ArrayList<Integer>> graph,
                       boolean[] visited) {

        Queue<int[]> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(new int[]{start, -1});

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];

            for (int next : graph.get(node)) {

                if (next == parent)
                    continue;

                if (visited[next])
                    return true;

                visited[next] = true;
                queue.add(new int[]{next, node});
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int n = 6;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        // 0 - 1 - 2
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        // 3 - 4
        //  \  /
        //    5
        graph.get(3).add(4);
        graph.get(4).add(3);

        graph.get(4).add(5);
        graph.get(5).add(4);

        graph.get(5).add(3);
        graph.get(3).add(5);

        boolean[] visited = new boolean[n];

        boolean cycle = false;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                if (bfs(i, graph, visited)) {
                    cycle = true;
                    break;
                }
            }
        }

        if (cycle)
            System.out.println("Cycle found");
        else
            System.out.println("Cycle not found");
    }
}
