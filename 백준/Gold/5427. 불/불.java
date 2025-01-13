
import java.io.*;
import java.util.*;

public class Main {

    static String EMPTY = ".";
    static String WALL = "#";
    static String START = "@";
    static String FIRE = "*";

    static int T, W, H;
    static String[][] building;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = 0;

    static Queue<int[]> queue;
    static Queue<int[]> fireQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            building = new String[H][W];
            queue = new LinkedList<>();
            fireQueue = new LinkedList<>();

            answer = 0;

            for (int h = 0; h < H; h++) {
                String[] input = br.readLine().split("");
                for (int w = 0; w < W; w++) {
                    building[h][w] = input[w];
                    if (building[h][w].equals(START)) {
                        queue.add(new int[] {h, w, 0});
                    } else if (building[h][w].equals(FIRE)) {
                        fireQueue.add(new int[] {h, w});
                    }
                }
            }

            bfs();
            System.out.println(answer == 0 ? "IMPOSSIBLE" : answer);

        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {

            spreadFire();

            int size = queue.size();

            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int cnt = current[2];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
                        answer = cnt + 1;
                        return;
                    }

                    if (building[nx][ny].equals(EMPTY)) {
                        building[nx][ny] = START;
                        queue.add(new int[]{nx, ny, cnt + 1});
                    }
                }
            }
        }
    }


    static void spreadFire() {
        int size = fireQueue.size();
        for (int s = 0; s < size; s++) {
            int[] current = fireQueue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < H && ny < W && building[nx][ny].equals(EMPTY)) {
                    building[nx][ny] = FIRE;
                    fireQueue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
