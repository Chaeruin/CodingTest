import java.io.*;
import java.util.*;

public class Main {

    static char[][] arr = new char[10][10];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static int[][] dp = new int[10][10];
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int startX = 0, startY = 0;
        int endX = 0, endY = 0;

        for (int i = 0; i < 10; i++) {
            String str = br.readLine();
            for (int j = 0; j < 10; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'L') {
                    startX = i;
                    startY = j;
                }

                if (arr[i][j] == 'B') {
                    endX = i;
                    endY = j;
                }
            }
        }

        queue.add(new int[] {startX, startY});
        bfs();

        System.out.print(dp[endX][endY]-1);

    }

    public static void bfs (){
        while (!queue.isEmpty()){
            int[] p = queue.poll();

            for (int i = 0; i < 4; i++){
                int nextR = p[0] + dx[i];
                int nextC = p[1] + dy[i];


                if (inRange(nextR, nextC) && arr[nextR][nextC]!='R' && dp[nextR][nextC] == 0){
                    dp[nextR][nextC] = dp[p[0]][p[1]] + 1;
                    queue.add(new int[] {nextR, nextC});
                }
            }
        }
    }

    public static boolean inRange(int r , int c){
        return r >= 0 && r < 10 && c >=0 && c < 10;
    }

}
