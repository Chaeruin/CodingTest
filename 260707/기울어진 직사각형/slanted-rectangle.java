import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {-1, -1, 1, 1};
    public static int[] dy = {1, -1, -1, 1};
    public static int N;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                for(int k = 1; k < N; k++)
                    for(int l = 1; l < N; l++)
                        ans = Math.max(ans, getScore(i, j, k, l));

        System.out.print(ans);

    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public static int getScore(int x, int y, int k, int l) {
        int[] moveNum = new int[]{k, l, k, l};
        
        int sumOfNums = 0;
    
        for(int d = 0; d < 4; d++)
            for(int q = 0; q < moveNum[d]; q++) {
                x += dx[d]; y += dy[d];
                
                if(!inRange(x, y))
                    return 0;
                
                sumOfNums += arr[x][y];
            }
        
        return sumOfNums;
    }
}
 