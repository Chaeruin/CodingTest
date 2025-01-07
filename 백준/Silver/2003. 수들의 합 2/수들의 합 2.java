
import java.io.*;
import java.util.*;

public class Main {

    static int[] A;
    static int N, M;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int start = 0, end = 0;

        while(true){
            if(sum >= M) {
                sum -= A[start++];
            }
            else if(end == N) {
                break;
            }
            else {
                sum += A[end++];
            }

            if(sum == M){
                count++;
            }
        }

        System.out.println(count);
    }
}
