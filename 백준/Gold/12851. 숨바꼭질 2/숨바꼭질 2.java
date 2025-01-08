import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int min = Integer.MAX_VALUE;
    static int count = 0;
    static int[] time = new int[100_001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //수빈이가 앞에 있을 때 처리
        if (N >= K) {
            System.out.println((N-K) + "\n1");
            return;
        }

        bfs();

        System.out.println(min);
        System.out.println(count);
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 1;

        while(!queue.isEmpty()){
            int now = queue.poll();

            //min이 생성되었다면 bfs이므로 동생에게 가는 시간의 최솟값이 정해졌으므로
            //min의 시간보다 now의 좌표에서 시간이 더 오래걸리면 비교할 필요가 없음
            if(min < time[now]) {
                continue;
            }

            for(int i = 0; i < 3; i++){
                int next;
                if(i == 0)
                    next = now * 2;
                else if(i == 1)
                    next = now + 1;
                else
                    next = now - 1;

                //범위를 넘어가면 continue
                if(next < 0 || next > 100_000)
                    continue;

                if(next == K){
                    min = time[now];
                    count++;
                }

                if(time[next] == 0 || time[next] == time[now] + 1){
                    queue.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }
}