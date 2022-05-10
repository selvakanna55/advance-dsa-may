package shortestPath;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class CourseShedule {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int indeg[] = new int[n];
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0;i<n;i++) adj[i] =  new ArrayList<>();

        for(int i=0;i<prerequisites.length;i++){
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
        while (!q.isEmpty()) {
            int curr = q.poll();
            c++;
            // System.out.print(curr + " ");
            for (Integer i : adj[curr]) {
                indeg[i]--;
                if (indeg[i] == 0) q.add(i);
            }
        }
        return c==n;
    }
}
