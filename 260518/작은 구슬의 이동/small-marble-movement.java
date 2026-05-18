import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char D = st.nextToken().charAt(0);

        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        int dir = -1;

        if (D == 'U') dir = 2;
        else if (D == 'D') dir = 1;
        else if (D == 'R') dir = 0;
        else if (D == 'L') dir = 3;

        for (int t = 0; t < T; t++) {
            int nx = R + dx[dir];
            int ny = C + dy[dir];

            if (!inRange(N, nx, ny)) {
                dir = 3 - dir;
                continue;
            }

            R += dx[dir];
            C += dy[dir];
        }

        System.out.println(R + " " + C);
    }

    static boolean inRange(int N, int nx, int ny) {
        if (nx > 0 && nx <= N && ny > 0 && ny <= N) return true;
        return false;
    }
}