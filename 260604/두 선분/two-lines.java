import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int x3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());

        if ((x4 >= x1 && x2 >= x3) || (x4 <= x1 && x2 <= x3)) System.out.println("intersecting");
        else System.out.println("nonintersecting");
    }
}



