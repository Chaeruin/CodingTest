import java.io.*;
import java.util.*;

public class Main {

    static int[] a = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        if (a[0] + 1 == a[1] && a[1] + 1 == a[2]) System.out.println(0);
        else if (a[0] + 2 == a[1] || a[1] + 2 == a[2])
            System.out.print(1);
        else System.out.print(2);
    }
}


