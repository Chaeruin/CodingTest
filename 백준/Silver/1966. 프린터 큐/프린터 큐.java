
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); 
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                q.add(new int[]{j, num});
            }

            int cnt = 0;
            while (true) {
                int[] cur = q.poll();   // 현재 위치 poll
                boolean chk = true;     // 더 높은 중요도가 없는지 여부 check

                for (int[] curQ : q) {  // 큐 순회 - 이렇게도 됨
                    if (curQ[1] > cur[1]) {
                        chk = false;
                        break;
                    }
                }

                if (chk) {
                    cnt++;
                    if (cur[0] == M) break;
                } else {
                    q.add(cur);
                }
            }

            System.out.println(cnt);
        }
    }
}
