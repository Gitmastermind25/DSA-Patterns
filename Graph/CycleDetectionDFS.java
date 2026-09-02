package Graph;

import java.util.ArrayList;

public class CycleDetectionDFS {
    static boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> graph,  boolean[] visited){
        visited[node] = true;
        for(int next: graph.get(node)){
            if(next==parent){
                continue ;
            }
            if(visited[next]){
                return true;
            }
            if(dfs(next, node, graph, visited)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n =4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(3).add(0);
        graph.get(0).add(3);

        boolean[] visited = new boolean[n];
        if(dfs(0,-1,graph,visited)){
            System.out.println("Cycle found");
        }
        else{
            System.out.println("Cycle not found");
        }

    }
}
