
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 시간 초과
//        List<Integer> integers = new ArrayList<>();
//
//        for (int i = 0; i < N+M; i++) {
//            integers.add(sc.nextInt());
//        }
//
//        integers.sort(Comparator.naturalOrder());
//
//        for (int i: integers) {
//            System.out.print(i + " ");
//        }

        int[] a = new int[N];
        int[] b = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0, p2 = 0;

        while(p1 < N && p2 < M) {
            if(a[p1]<= b[p2]) {
                sb.append(a[p1++]+" ");
            }
            else {
                sb.append(b[p2++]+" ");
            }
        }
        if(p1 == N) {
            for (int i = p2; i < M; i++) {
                sb.append(b[i]+" ");
            }
        }
        if(p2 == M) {
            for (int i = p1; i < N; i++) {
                sb.append(a[i]+" ");
            }
        }
        System.out.println(sb);

    }
}
