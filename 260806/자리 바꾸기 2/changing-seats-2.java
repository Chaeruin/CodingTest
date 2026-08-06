import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[K][2];
        int[] seat = new int[N + 1];
        HashSet<Integer>[] visit = new HashSet[N + 1]; 

        for (int i = 1; i <= N; i++) {
            seat[i] = i;
            visit[i] = new HashSet<>();
            visit[i].add(i);
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3 * K; i++) {
            int j = i % K;
            int a = arr[j][0];
            int b = arr[j][1];

            int person1 = seat[a];
            int person2 = seat[b];

            visit[person1].add(b);
            visit[person2].add(a);

            seat[a] = seat[b];
            seat[b] = person1;
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(visit[i].size());
        }
    }
}
 