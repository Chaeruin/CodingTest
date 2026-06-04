import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());


        int movingPeople = 0;
        int dist = 0;

        for (int i = 0; i < N - 1; i++) {
            int totalPeople = A[i] + movingPeople;

            movingPeople = totalPeople - B[i];

            dist += movingPeople;
        }

        System.out.println(dist);
    }
}
