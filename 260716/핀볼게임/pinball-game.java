import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[][] grid;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    // 방문 배열
    public static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N][4];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxTime = 0;

        int timeOne = getHorizontalTime(0, 0);
        int timeTwo = getHorizontalTime(N - 1, 1);
        int timeThree = getVerticalTime(0, 2);
        int timeFour = getVerticalTime(N - 1, 3);

        maxTime = Math.max(
                    Math.max(timeOne, Math.max(timeTwo, 
                    Math.max(timeThree, timeFour))), maxTime);

        System.out.println(maxTime);
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static int getHorizontalTime(int j, int initDir) {
        int maxTime = 0;

        int idx = -1;

        for (int i = 0; i < N; i++) {
            int startX = j;
            int startY = i;
            
            visited = new boolean[N][N][4]; 

            int currDir = initDir;
            currDir = getNextDir(currDir, grid[startX][startY]);
            visited[startX][startY][currDir] = true;

            int time = 1;

            while (true) {
                int nx = startX + dx[currDir];
                int ny = startY + dy[currDir];

                time++;
                
                if (!inRange(nx, ny)) break; 
                if (visited[nx][ny][currDir]) break; 
                
                visited[nx][ny][currDir] = true;
                
                currDir = getNextDir(currDir, grid[nx][ny]); 
                
                startX = nx;
                startY = ny;
            }

            maxTime = Math.max(time, maxTime);
        }

        return maxTime;
    }

    public static int getVerticalTime(int i, int initDir) {
        int maxTime = 0;

        for (int j = 0; j < N; j++) {
            int startX = j;
            int startY = i;
            
            visited = new boolean[N][N][4]; 

            int currDir = initDir;
            currDir = getNextDir(currDir, grid[startX][startY]);
            visited[startX][startY][currDir] = true;

            int time = 1;

            while (true) {
                int nx = startX + dx[currDir];
                int ny = startY + dy[currDir];

                time++;
                
                if (!inRange(nx, ny)) break; 
                if (visited[nx][ny][currDir]) break; 
                
                visited[nx][ny][currDir] = true;
                
                currDir = getNextDir(currDir, grid[nx][ny]); 
                
                startX = nx;
                startY = ny;
            }
            maxTime = Math.max(time, maxTime);
        }
        return maxTime;
    }

    public static int getNextDir(int currDir, int mirror) {
    if (mirror == 0) return currDir; 
    
    if (mirror == 1) {
        if (currDir == 0) return 3; // 위 -> 왼
        if (currDir == 1) return 2; // 아래 -> 오
        if (currDir == 2) return 1; // 왼 -> 위
        if (currDir == 3) return 0; // 오 -> 아래
    }
    if (mirror == 2) {
        if (currDir == 0) return 2; // 위 -> 오
        if (currDir == 1) return 3; // 아래 -> 왼
        if (currDir == 2) return 0; // 왼 -> 아래
        if (currDir == 3) return 1; // 오 -> 위
    }
    return currDir;
}
}
 