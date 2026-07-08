import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
    
        grid = bomb(r, c);

        for (int[] arr : grid) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public static int[][] bomb(int r, int c) {

        int num = grid[r][c];

        int startX = r - (num - 1) >= 0 ? r - (num - 1) : 0;
        int endX = r + (num - 1) < N ? r + (num - 1) : N - 1;

        int startY = c - (num - 1) >= 0 ? c - (num - 1) : 0;
        int endY = c + (num - 1) < N ? c + (num - 1) : N - 1;

        for (int i = startX; i <= endX; i++) {
            grid[i][c] = 0;
        }
        for (int i = startY; i <= endY; i++) {
            grid[r][i] = 0;
        }

        return rearrange();
    }

    public static int[][] rearrange() {
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = grid[i].clone();
        }

        for (int y = 0; y < N; y++) {
            int writeIdx = N - 1; 

            for (int x = N - 1; x >= 0; x--) {
                if (copy[x][y] != 0) { 
                    int temp = copy[x][y];
                    copy[x][y] = 0; 
                    copy[writeIdx][y] = temp;
                    writeIdx--;
                }
            }
        }
        
        return copy;
    }
}
 