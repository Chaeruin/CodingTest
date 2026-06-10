import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[3];

        for (int i = 0; i < 3; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        if (a[0] + 1 == a[1] && a[1] + 1 == a[2]) {
            System.out.print(0);
            System.exit(0);
        }
        
        int maxMove = 0;
        int move = a[2] - a[1] - 1;
        maxMove = Math.max(maxMove, move);

        move = a[1] - a[0] - 1;
        maxMove = Math.max(maxMove, move);

        System.out.print(maxMove);
    }
}



