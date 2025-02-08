import java.util.*;

class Solution {
    
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    boolean[][] visited;
    int answer = -1;
    
    public int solution(int[][] maps) {
        
        visited = new boolean[maps.length][maps[0].length];
        
        dfs(maps);
        
        return answer;
    }
    
    void dfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            
            if (x == maps.length - 1 && y == maps[0].length - 1) {
                answer = count;
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (isTrue(nx, ny, maps) && !visited[nx][ny] && maps[nx][ny] != 0) {
                    queue.add(new int[] {nx, ny, count + 1});
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    boolean isTrue(int nx, int ny, int[][] maps) {
        return nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length;
    }
}
