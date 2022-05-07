package representation;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFSRun {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        ArrayList li[] = new ArrayList[nodes + 1];
        for (int i = 1; i <= nodes; i++) li[i] = new ArrayList<Integer>();

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            li[u].add(v);
            li[v].add(u);
        }

        boolean visited[] = new boolean[nodes + 1];
        for (int i = 1; i <= nodes; i++) {
            if (visited[i] == false) {
                bfs(i, visited, li);
            }
        }
    }

    private static void bfs(int curr, boolean[] visited, ArrayList<Integer>[] li) {
        visited[curr] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        while(!q.isEmpty()){
            int node = q.poll(); // remove element from queue
            System.out.print(node+" ");
            for(int i:li[node]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    private static void dfs(int curr, boolean[] visited, ArrayList<Integer>[] li) {
        visited[curr] = true;
        System.out.print(curr + " ");
//        for (Integer i : li[curr]) {
        for (int j = li[curr].size() - 1; j >= 0; j--) {
            int i = li[curr].get(j);
            if (visited[i] == false) {
                dfs(i, visited, li);
            }
        }
    }
}
