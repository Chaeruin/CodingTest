
import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] meeting = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meeting, (o1, o2) -> {
            if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o1[1], o2[1]);
        });

        int count = 0;
        int lastEndTime = 0;
        
        for (int i = 0; i < N; i++) {
            if (lastEndTime <= meeting[i][0]) {
                lastEndTime = meeting[i][1];
                count++;
            }
        }

        System.out.println(count);

    }

}
