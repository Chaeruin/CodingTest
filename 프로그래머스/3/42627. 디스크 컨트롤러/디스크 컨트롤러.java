
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;

        int[][] sorted = new int[n][3];

        for (int i = 0; i < n; i++) {
            sorted[i] = new int[]{jobs[i][0], jobs[i][1], i};
        }

        Arrays.sort(sorted,
            (a, b) -> Integer.compare(a[0], b[0])
        );

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[2], b[2]);
        });

        int time = 0;
        int index = 0;
        int completed = 0;
        int total = 0;

        while (completed < n) {

            while (index < n && sorted[index][0] <= time) {
                pq.offer(sorted[index]);
                index++;
            }

            if (pq.isEmpty()) {
                time = sorted[index][0];
                continue;
            }

            int[] job = pq.poll();

            time += job[1];
            total += time - job[0];

            completed++;
        }

        return total / n;
    }
}
