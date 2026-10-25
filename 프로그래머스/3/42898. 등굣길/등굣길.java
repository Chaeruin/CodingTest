class Solution {
    
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] grid = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        
        for (int[] p : puddles) {
            int y = p[0];
            int x = p[1];
            
            grid[x][y] = 1;
        }
        
        dp[1][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;
                
                if (grid[i][j] == 1) continue;
                
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_007;
            }
        }
        
        return dp[n][m];
    }
}

// 1, 1 -> m, n
// 최단경로의 갯수 % 1_000_000_007
// 우, 하 로만 움직이기
// 물이 잠긴 지역_의 배열 -> 물에 잠긴 지역이 여러개일 수 있음

// grid 를 만들기 - 움직임 가능한 곳이면 0, 불가능한 곳이면 1
// dp[i][j] = i, j 로 갈 수 있는 최단 경로의 갯수 % 1_000_000_007
// 