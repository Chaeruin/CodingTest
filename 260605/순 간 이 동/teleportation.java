import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        // A -> B
        // A -> x -> y -> B
        // A -> y -> x -> B

        int first = Math.abs(A - B);
        int second = Math.abs(A - x) + Math.abs(y - B);
        int third = Math.abs(A - y) + Math.abs(x - B);

        int min = Math.min(Math.min(first, second), third);

        System.out.println(min);
    }
}



