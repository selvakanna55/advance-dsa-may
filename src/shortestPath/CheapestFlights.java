package shortestPath;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class CheapestFlights {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int[] f : flights) {
            if (!hm.containsKey(f[0])) hm.put(f[0], new HashMap<>());
            hm.get(f[0]).put(f[1], f[2]);

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[]{0, src, k + 1});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int price = curr[0];
            int city = curr[1];
            int stops = curr[2];

            if (city == dst) return price;

            if (stops > 0 && hm.containsKey(city)) {
                Map<Integer, Integer> x = hm.getOrDefault(city, new HashMap<>());
                for (int i : x.keySet()) {
                    pq.add(new int[]{price + x.get(i), i, stops - 1});
                }
            }

        }
        return -1;
    }
}