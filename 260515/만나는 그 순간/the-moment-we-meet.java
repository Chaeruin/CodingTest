import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arrA = new int[1_000_001];
        arrA[0] = 0;
        int[] arrB = new int[1_000_001];
        arrB[0] = 0;

        int positionA = 0, positionB = 0;
        int indexA = 1, indexB = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char dir = st.nextToken().charAt(0);
            int t = Integer.parseInt(st.nextToken());

            for (int j = 0; j < t; j++) {
                if (dir == 'R') arrA[indexA++] = ++positionA;
                else arrA[indexA++] = --positionA;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            char dir = st.nextToken().charAt(0);
            int t = Integer.parseInt(st.nextToken());

            for (int j = 0; j < t; j++) {
                if (dir == 'R') arrB[indexB++] = ++positionB;
                else arrB[indexB++] = --positionB;
            }
        }

        int totalTime = Math.max(indexA, indexB);
        for (int i = indexA; i < totalTime; i++) arrA[i] = arrA[i - 1];
        for (int i = indexB; i < totalTime; i++) arrB[i] = arrB[i - 1];

        int answer = -1;
        for (int i = 1; i < totalTime; i++) {
            if (arrA[i-1] != arrB[i-1] && arrA[i] == arrB[i]) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
        
    }
}