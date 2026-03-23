import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        List<int[]> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new int[]{start, end});
        }

        meetings.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int endTimeO1 = o1[1];
                int endTimeO2 = o2[1];
                if (endTimeO1 == endTimeO2) return o1[0] - o2[1];
                return endTimeO1 - endTimeO2;
            }
        });

        int result = 0;
        int time = 0;

        for (int i = 0; i < N; i++) {
            if (time <= meetings.get(i)[0]) {
                result ++;
                time = meetings.get(i)[1];
            }
        }

        System.out.println(result);
    }

}