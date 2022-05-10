package shortestPath;

import java.util.*;


public class UnitUndirected {

    static  boolean visited[]  = new boolean[1000000];
    static  int distance[]  = new int[10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        ArrayList[] li = new ArrayList[nodes + 1];
        for (int i = 1; i <= nodes; i++) {
            li[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            li[u].add(v);
//            li[v].add(u);
        }
        for(int i=0;i<=nodes;i++) distance[i] = Integer.MAX_VALUE;
        for (int i = 1; i <= nodes; i++) {
            if(!visited[i]) weightedBfs(i, li);
        }
        System.out.println(Arrays.toString(distance));
    }

    private static void weightedBfs(int node, ArrayList<Integer>[] adj) {
        System.out.println(node);
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        distance[node]  = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            int dist = distance[curr];
            for(Integer i:adj[curr]){
                if(dist+1 < distance[i]){
                    distance[i] = dist+1;
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
