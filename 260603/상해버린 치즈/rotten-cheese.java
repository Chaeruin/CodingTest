import java.io.*;
import java.util.*;

public class Main {

    static int N, M, D, S;
    static int[][] times;
    static int[][] record;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        times = new int[D][3];
        record = new int[S][2];

        for (int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
            times[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            record[i][0] = Integer.parseInt(st.nextToken());
            record[i][1] = Integer.parseInt(st.nextToken());
        }


        int ans = 0;
        
        // 하나의 치즈가 상했을 때 필요한 약의 수의 최댓값을 구합니다.
        for(int i = 1; i <= M; i++) {
            // i번째 치즈가 상했을 때 필요한 약의 수를 구합니다.

            // 우선 i번째 치즈가 상했다고 가정할 때 모순이 발생하지 않는지 확인합니다.
            // time배열을 만들어 각 사람이 언제 치즈를 먹었는지 저장합니다.
            int[] time = new int[N + 1];
            for(int j = 0; j < D; j++) {
                // i번째 치즈에 대한 정보가 아닌 경우 넘어갑니다.
                if(times[j][1] != i)
                    continue;

                // person이 i번째 치즈를 처음 먹었거나
                // 이전보다 더 빨리 먹게 된 경우 time배열을 갱신합니다.
                int person = times[j][0];
                if(time[person] == 0)
                    time[person] = times[j][2];
                else if(time[person] > times[j][2])
                    time[person] = times[j][2];
            }

            // possible : i번째 치즈가 상했을 수 있으면 true, 아니면 false
            boolean possible = true;

            for(int j = 0; j < S; j++) {
                // person이 i번째 치즈를 먹지 않았거나
                // i번째 치즈를 먹은 시간보다 먼저 아픈 경우 모순이 생깁니다.
                int person = record[j][0];
                if(time[person] == 0)
                    possible = false;
                if(time[person] >= record[j][1])
                    possible = false;
            }

            // 만약 i번째 치즈가 상했을 가능성이 있다면, 몇 개의 약이 필요한지 확인합니다.
            int pill = 0;

            if(possible) {
                // 한번이라도 i번째 치즈를 먹은 적이 있다면, 약이 필요합니다.
                for(int j = 1; j <= N; j++) {
                    if(time[j] != 0)
                        pill++;
                }
            }

            ans = Math.max(ans, pill);
        }

        System.out.print(ans);
        
    }
}



