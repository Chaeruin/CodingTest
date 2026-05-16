import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] posA = new int[1_000_001];
        int[] posB = new int[1_000_001];

        int indexA = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            while (t-- > 0) {
                posA[indexA] = posA[indexA - 1] + v;
                indexA++;
            }
        }

        int indexB = 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            while (t-- > 0) {
                posB[indexB] = posB[indexB - 1] + v;
                indexB++;
            }
        }

        int leader = 0, answer = 0;
        for (int i = 1; i < indexA; i++) {
            if (posA[i] > posB[i] && leader != 1) {
                answer++;
                leader = 1;
            } else if (posA[i] < posB[i] && leader != 2) {
                answer++;
                leader = 2;
            } else if (posA[i - 1] != posB[i - 1] && posA[i] == posB[i]) {
                answer++;
                leader = 3;
            }
        }

        System.out.println(answer);
    }
}