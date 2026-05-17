import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if (isInRange(N, nx, ny) && arr[nx][ny] == 1) count++;
                }

                if (count >= 3) answer++;
            }
        }

        System.out.println(answer);
        
    }

    static boolean isInRange(int N, int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < N)
            return true;
        return false;
    }
}