package representation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Pair{
    int v;
    int cost;
    Pair(int v, int cost){
        this.v  = v;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "v=" + v +
                ", cost=" + cost +
                '}';
    }
}

public class GraphRep {
    static void adjMatrix(){
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int arr[][] = new int[nodes+1][nodes+1];
        int edges = sc.nextInt();
        for(int i=0;i<edges;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();
            arr[u][v] = cost;
            arr[v][u] = cost;
        }
        for (int i=1;i<=nodes;i++) System.out.println(Arrays.toString(arr[i]));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        ArrayList[] li = new ArrayList[nodes+1];
        for(int i=1;i<=nodes;i++){
            li[i] = new ArrayList<Pair>();
        }
        for(int i=0;i<edges;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();
//            System.out.println(u+" "+v+" "+cost);
            li[u].add(new Pair(v, cost));
            li[v].add(new Pair(u, cost));
        }
        for(int i=1;i<=nodes;i++) System.out.println(i+" "+li[i]);
    }
}
