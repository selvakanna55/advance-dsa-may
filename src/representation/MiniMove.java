package representation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MiniMove {
    static boolean visited[] = new boolean[100000];

    static int bfsMinMove(int start, int end, int arr[]) {
        visited[start] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});
        while (!q.isEmpty()) {
            int curr[] = q.poll();
            int num = curr[0];
            int steps = curr[1];
            if (num == end) {
                return steps;
            }
            for (int i = 0; i < arr.length; i++) {
                int mul = num * arr[i];
                if (num == end) {
                    return steps + 1;
                }
                if (mul < end && !visited[mul]) {
                    visited[mul] = true;
                    q.add(new int[]{mul, steps + 1});
                }
            }
        }

        return -1;
    }

    static void callMinMove() {
        int st = 2, end = 100;
        int nums[] = {2, 5, 10};
        System.out.println(bfsMinMove(st, end, nums));
    }


    public static void main(String[] args) {

    }
}
