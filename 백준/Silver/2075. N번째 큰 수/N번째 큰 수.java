import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());


        int[] intCount = new int[N*N];
        int pos = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                intCount[pos] = Integer.parseInt(st.nextToken());
                pos++;
            }
        }

        Arrays.sort(intCount);

        System.out.println(intCount[N*N - N]);
    }
}   