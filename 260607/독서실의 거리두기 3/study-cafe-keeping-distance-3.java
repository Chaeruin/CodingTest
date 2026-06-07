import java.io.*;
import java.util.*;

public class Main {

    static int MAX_N = 1001;
    static int[] idx = new int[MAX_N];
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        String[] str = br.readLine().split("");

        int index = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
            if (arr[i] == 1) idx[index++] = i;
        }

        int max = Integer.MIN_VALUE;
        int maxPosition = 0;

        for (int i = 0; i < index - 1; i++) {
            int distance = idx[i + 1] - idx[i];
            if (max < distance) maxPosition = idx[i] + distance / 2;
            max = Math.max(max, distance);
        }

        arr[maxPosition] = 1;
        idx[index++] = maxPosition;

        Arrays.sort(idx, 0, index);

        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < index - 1; i++) {
            int distance = idx[i + 1] - idx[i];
            minDistance = Math.min(minDistance, distance);
        }

        System.out.println(minDistance);
    }
}



