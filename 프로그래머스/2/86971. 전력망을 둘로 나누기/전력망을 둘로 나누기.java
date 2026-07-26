import java.util.*;
import java.io.*;

class Solution {
    public int cnt;
    public List<Integer>[] graph;
    public boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int remove = 0; remove < wires.length; remove++) {
            graph = new ArrayList[n + 1];
            
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < wires.length; i++) {
                if (i == remove) continue;
                
                int a = wires[i][0];
                int b = wires[i][1];

                graph[a].add(b);
                graph[b].add(a);
            }
            
            visited = new boolean[n + 1];
            visited[1] = true;

            cnt = 1;
            dfs(1);

            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
        }
        return answer;
    }
    
    public void dfs(int node) {
        
        for (int next : graph[node]) {
            if (!visited[next]) {
                visited[next] = true;
                cnt++;
                dfs(next);
            }
        }
    }
}