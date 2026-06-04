import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] line = new int[101];

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = a; i < b; i++) line[i]++;
        for (int i = c; i < d; i++) line[i]++;

        int count = 0;

        for (int i = 0; i < 101; i++)
            if (line[i] > 0) count++;

        System.out.print(count);
    }
}



