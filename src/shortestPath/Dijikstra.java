package shortestPath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node implements Comparator<Node> {
    int v;

    public Node() {

    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    int weight;

    Node(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }






    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    @Override
    public int compare(Node o1, Node o2) {
        return o1.weight - o2.weight;
    }
}

public class Dijikstra {
    static void dij(int n, int src ){
        int distance[] = new int[100000];
        ArrayList<Node> adj[] = new ArrayList[n+1];
        for(int i=0;i<=n;i++)distance[i] = Integer.MAX_VALUE;
        distance[src] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(n, new Node());
        pq.add(new Node(src,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int dist = node.weight;
            for(Node it:adj[node.getV()]){
                if(it.getV()+dist < distance[it.getV()]){
                    distance[it.getV()] = it.getV()+dist;
                    pq.add(new Node(it.getV(), it.getWeight()));
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(distance[i]);
        }
    }
    public static void main(String[] args) {



    }
}
