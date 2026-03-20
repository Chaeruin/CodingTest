import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> selected = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    house.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[chicken.size()];

        backtracking(0, 0);

        System.out.println(result);
    }

    static void backtracking(int depth, int start) {
        if (depth == M) { // 치킨집 M 개를 뽑아서 selected 리스트에 M개 저장 완료 시
            int sum = 0;
            for (int[] h : house) {
                int min = Integer.MAX_VALUE;
                for (int[] s : selected) {
                    int d = Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]);
                    min = Math.min(d, min);
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected.add(chicken.get(i));
                backtracking(depth + 1, i + 1);
                selected.remove(selected.size() - 1);
                visited[i] = false;
            }
        }
    }
}