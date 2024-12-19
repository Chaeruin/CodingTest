
import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static String[][] wars;
    static int[] dx = new int[] {0, 0, -1, 1};
    static int[] dy = new int[] {1, -1, 0, 0};
    static boolean[][] visited;

    static int count = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wars = new String[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                wars[i][j] = inputs[j];
            }
        }
        // 예제
        // 81 + 49
        // 1 + 64

        int white_count = 0;
        int black_count = 0;

        for(int i = 0; i < M; i++) { // 세로
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    String color = wars[i][j];
                    count = 0;
                    dfs(j, i, color);

                    if(color.equals("W")) {
                        white_count += count * count;
                    }
                    else {
                        black_count += count * count;
                    }
                }
            }
        }

        System.out.println(white_count + " " + black_count);
    }

    public static void dfs(int x, int y, String color) {
        visited[y][x] = true;
        count += 1;

        for(int i=0; i<4; i++) {
            int now_y = y + dy[i];
            int now_x = x + dx[i];

            if(rangeCheck(now_x, now_y) && wars[now_y][now_x].equals(color) && !visited[now_y][now_x]) {
                dfs(now_x, now_y, wars[now_y][now_x]);
            }
        }
    }

    public static boolean rangeCheck(int now_x, int now_y) {
        return (0 <= now_y && now_y < M && 0 <= now_x && now_x < N);
    }
}
