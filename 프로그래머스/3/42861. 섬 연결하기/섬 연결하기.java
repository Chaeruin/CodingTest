import java.util.*;

class Solution {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
    
    public int solution(int n, int[][] costs) {
            
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        int count = 0;

        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int weight = cost[2];

            if (find(a) != find(b)) {
                union(a, b);

                answer += weight;
                count++;

                if (count == n - 1) break;
            }
        }

        return answer;
    }
}

// 모든 섬이 통행(연결) 가능 (true)
// 필요한 최소 비용
// MST + 다익스트라
// [1번섬, 연결된섬, 비용]
// 무방향 그래프
// return 최소 비용