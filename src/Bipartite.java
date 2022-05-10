import java.util.*;

public class Bipartite {
    static int color[] = new int[100001];
    static boolean visited[] = new boolean[100001];
    static int indeg[] = new int[10000];


    static boolean isBipartiteDFS(int node, int col, ArrayList<Integer> adj[]) {
        color[node] = col;
        for (Integer i : adj[node]) {
            if (color[i] == -1) {
                if (!isBipartiteDFS(i, 1 - col, adj)) return false;
            } else if (color[i] == col) return false;
            //i is already coloured by some one, if that is equal curr currl
        }
        return true;
    }

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
            indeg[v]++;

//            li[v].add(u);
        }
        for (int i = 0; i <= nodes; i++) color[i] = -1;
//        System.out.println(isBipartiteBFS(1, 0, li));
//        Stack<Integer> s = new Stack<>();
//        topoBFS(1, li, s);
        topoBFS(nodes, li);
//        while (!s.isEmpty()) System.out.print(s.pop() + " ");
    }

    private static void topoDFS(int node, ArrayList<Integer>[] adj, Stack<Integer> s) {
        visited[node] = true;
        for (Integer i : adj[node]) {
            if (!visited[i]) {
                topoDFS(i, adj, s);
            }
        }
        s.push(node);
    }

    private static void topoBFS(int n, ArrayList<Integer>[] adj) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for (Integer i : adj[curr]) {
                indeg[i]--;
                if (indeg[i] == 0) q.add(i);
            }
        }
    }

    private static boolean isBipartiteBFS(int node, int col, ArrayList<Integer>[] adj) {
        color[node] = col;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int curr = q.poll();
            col = color[curr];
            for (Integer i : adj[curr]) {
                if (color[i] == -1) {
                    color[i] = 1 - col;
                    q.add(i);
                } else if (color[i] == col) return false;
            }
        }
        return true;
    }
}
