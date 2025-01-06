import java.io.*;
import java.util.*;

public class Main {

    static int T, N;
    static int[] stock;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        List<Long> result = new LinkedList<>();

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            stock = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stock[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;

            int max = stock[N - 1];	//마지막 값을 가장 큰 시세로 설정
            //역방향 탐색
            for(int j=N-2;j>=0;j--) {
                if(stock[j] <= max) {    //가장 큰 시세보다 작은 시세일 때 판매!
                    sum += max - stock[j];
                }
                else {                   //가장 큰 시세보다 큰 시세 탐색시 바꾸기
                    max = stock[j];
                }
            }

            result.add(sum);
        }

        result.forEach(System.out::println);
    }
}
