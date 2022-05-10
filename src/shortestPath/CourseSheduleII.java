package shortestPath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int indeg[] = new int[n];
        ArrayList<Integer> adj[] = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj[v].add(u);
            indeg[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) q.add(i);
        }
        int c = 0;
        int arr[] = new int[n];
        while (!q.isEmpty()) {
            int curr = q.poll();
            arr[c++] = curr;
            // System.out.print(curr + " ");
            for (Integer i : adj[curr]) {
                indeg[i]--;
                if (indeg[i] == 0) q.add(i);
            }
        }
        if (c == n) return arr;
        else return new int[]{};
    }
}
