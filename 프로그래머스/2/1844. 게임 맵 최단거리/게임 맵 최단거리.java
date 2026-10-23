import java.util.*;

class Solution {
    
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        
        int answer = -1;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            
            if (x == n - 1 && y == m - 1) {
                answer = count;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (!inRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (maps[nx][ny] == 0) continue;
                
                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny, count + 1});
            }
        }
        
        return answer;
    }
    
    public boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}