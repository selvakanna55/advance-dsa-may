package cycle;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UndirectedCycle {
    static boolean visited[] = new boolean[100000];
    static boolean dirVisited[] = new boolean[100000];

    //TODO: disconncted tree, componenet
    static boolean hasCycle(int curr, int parent, ArrayList<Integer>[] li) {
        visited[curr] = true;
        for (Integer i : li[curr]) {
            if (!visited[i]) {
                if (hasCycle(i, curr, li) == true)
                    return true;
            } else if (visited[i] && i != parent) return true;
        }
        return false;
    }
    static  boolean hasCycleBFS(int curr, int parent, ArrayList<Integer>[] li){
        Queue<int[]> q = new LinkedList<>();
        visited[curr] = true;
        q.add(new int[]{curr, parent});
        while(!q.isEmpty()){
            int temp[] = q.poll();
            curr = temp[0];
            parent = temp[1];
            for(Integer i: li[curr]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(new int[]{i, curr});
                }else if(i!=parent) return true;
            }
        }
        return false;
    }


    static boolean hasCycleDirectedDFS(int curr, int parent, ArrayList<Integer>[] li) {
        visited[curr] = true;
        dirVisited[curr]=true;
        for (Integer i : li[curr]) {
            if (!visited[i]) {
                if (hasCycleDirectedDFS(i, curr, li) == true)
                    return true;
            } else if (visited[i] && dirVisited[i]) return true;
        }
        dirVisited[curr] = false;
        return false;
    }

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
        boolean ans = false;
        for (int i = 1; i <= nodes; i++) {
            if (visited[i] == false) {
                if (hasCycleDirectedDFS(i, 0, li)) {
                    ans = true;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
