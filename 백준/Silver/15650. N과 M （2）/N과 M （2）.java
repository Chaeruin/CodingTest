
import java.io.*;
import java.util.*;

class Main {
    static int M, N;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }

        combination(0, M);
    }

    static void combination(int start, int r) {
        if (r == 0) {
            print();
            return;
        } else {
            for (int i = start; i < N; i++) {
                visited[i] = true;
                combination(i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            if (visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
