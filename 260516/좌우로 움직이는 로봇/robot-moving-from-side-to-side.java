import java.io.*;
import java.util.*;

public class Main {
    static int[] posA = new int[2_000_001];
    static int[] posB = new int[2_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        posA[0] = 0;
        posB[0] = 0;

        int indexA = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            for (int j = 0; j < t; j++) {
                if (dir == 'R') posA[indexA] = posA[indexA - 1] + 1;
                else posA[indexA] = posA[indexA - 1] - 1;

                indexA++;
            }
        }

        int indexB = 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            for (int j = 0; j < t; j++) {
                if (dir == 'R') posB[indexB] = posB[indexB - 1] + 1;
                else posB[indexB] = posB[indexB - 1] - 1;

                indexB++;
            }
        }

        int totalTime = Math.max(indexA, indexB);
        for (int i = indexA; i < totalTime; i++) posA[i] = posA[i - 1];
        for (int i = indexB; i < totalTime; i++) posB[i] = posB[i - 1];

        int answer = 0;
        for (int i = 1; i < totalTime; i++) {
            if (posA[i - 1] != posB[i - 1] && posA[i] == posB[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}