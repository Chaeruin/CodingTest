import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int minX1 = Math.min(x1, a1);
        int minY1 = Math.min(y1, b1);
        int maxX1 = Math.max(x2, a2);
        int maxY1 = Math.max(y2, b2);


        int maxWH = Math.max((maxX1 - minX1), (maxY1 - minY1));

        System.out.println(maxWH * maxWH);
    }
}
