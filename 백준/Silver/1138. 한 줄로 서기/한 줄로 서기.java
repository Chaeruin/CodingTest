
import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            result.add(arr[i], i + 1);
        }

        for (int r: result) {
            System.out.print(r + " ");
        }

    }
}