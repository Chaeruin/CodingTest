import java.io.*;
import java.util.*;

public class Main {

    public static int N, answer = Integer.MAX_VALUE;
    public static int[] arr;
    public static int[] selected, unselected;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[2 * N];
        selected = new int[N];
        unselected = new int[N];
        visited = new boolean[2 * N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    // N개 / N개 분할 선택 과정 필요 -> 조합 2N C N
    // 부분합 [N] / [N] 최솟값 산출 과정

    public static void dfs(int idx, int depth) {
        if (depth == N) {
            getUnselected();
            answer = Math.min(answer, Math.abs(prefixSum(selected) - prefixSum(unselected)));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            visited[i] = true;
            selected[depth] = arr[i];
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    public static void getUnselected() {
        int idx = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (visited[i]) continue;
            unselected[idx++] = arr[i];
        }
    }

    public static int prefixSum(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += i;

        return sum;
    }

}
