
import java.io.*;
import java.util.*;

public class Main {

    static String WALL = "#";
    static String EMPTY = ".";
    static String START = "J";
    static String FIRE = "F";

    static String[][] maze;
    static int R, C;

    static Queue<int[]> queue;
    static Queue<int[]> fireQueue;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        maze = new String[R][C];
        queue = new LinkedList<>();
        fireQueue = new LinkedList<>();

        for (int r = 0; r < R; r++) {
            input = br.readLine().split("");
            for (int c = 0; c < C; c++) {
                maze[r][c] = input[c];
                if (maze[r][c].equals(FIRE)) {
                    fireQueue.add(new int[] {r, c});
                }
                if (maze[r][c].equals(START)) {
                    queue.add(new int[] {r, c, 0});
                }
            }
        }

        bfs();

        System.out.println(answer == 0 ? "IMPOSSIBLE" : answer);

    }

    static void bfs() {
        while (!queue.isEmpty()) {

            spreadFire();

            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int count = current[2];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C)  {
                        answer = count + 1;
                        return;
                    }
                    if (maze[nx][ny].equals(EMPTY)) {
                        maze[nx][ny] = START;
                        queue.add(new int[] {nx, ny, count + 1});
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

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (maze[nx][ny].equals(EMPTY)) { // START 도 고려
                    maze[nx][ny] = FIRE;
                    fireQueue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
