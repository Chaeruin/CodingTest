import java.io.*;
import java.util.*;

public class Main {

    static int[] power;
    static String[] name;
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        name = new String[N + 1];
        power = new int[N + 1];

        for(int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; ++i) {
            int characterPower = Integer.parseInt(br.readLine());

            bw.write(findName(characterPower) + "\n");
        }

        bw.flush();
    }

    static String findName(int characterPower) {
        int start = 0, end = N - 1;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(power[mid] < characterPower) {
                start = mid+1;
            }
            else {
                end = mid - 1;
            }
        }

        return name[start];
    }


}
