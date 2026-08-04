import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int target = K - arr[i] - arr[j]; 

                answer += map.getOrDefault(target, 0);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(answer);

    }
}
 