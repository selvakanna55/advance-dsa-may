package representation;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int totalOranges = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i, j, 0}); // put all rotten oragens in queue
                if (grid[i][j] != 0) totalOranges++; // count total oranges
            }
        }

        int runCount = 0;
        int ans = 0;
        while (!q.isEmpty()) {
            runCount++;
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];
            int steps = curr[2];
            ans = Math.max(ans, steps);

            int dr[] = {-1, 0, 0, 1};
            int dc[] = {0, 1, -1, 0};

            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];
                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && grid[newR][newC] == 1) {
                    grid[newR][newC] = 2;
                    q.add(new int[]{newR, newC, steps + 1});
                }
            }
        }
        if (runCount == totalOranges) return ans;
        else return -1;
    }
}
