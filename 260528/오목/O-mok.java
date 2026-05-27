import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr = new int[20][20];
    static int[] dx = {1, 0, 1, -1};
    static int[] dy = {0, 1, 1, 1};  // 하, 우, 우하 대각선, 우상 대각선
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int win = 0;
        int startX = 0;
        int startY = 0;
        int dirNum = 0;

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if (arr[i][j] == 0) continue;

                int currentStone = arr[i][j];

                for (int dir = 0; dir < 4; dir++) {
                    int count = 1;

                    for (int step = 1; step <= 4; step++) {
                        int nx = i + dx[dir] * step;
                        int ny = j + dy[dir] * step;

                        if (inRange(nx, ny) && arr[nx][ny] == currentStone) count++;
                        else break; 
                    }   

                    if (count == 5) {
                        win = currentStone;
                        startX = i;
                        startY = j;
                        dirNum = dir;
                        
                        System.out.println(win);
                        int[] middle = calcMiddle(startX, startY, dirNum);
                        System.out.print(middle[0] + " " + middle[1]);
                        return; 
                    }
                }
            }
        }

        System.out.println(0);

        // System.out.println(win);
        // int[] middle = calcMiddle(startX, startY, dirNum);
        // System.out.print(middle[0] + " " + middle[1]);

    }

    static boolean inRange(int x, int y) {
        return (x >= 1 && x < 20 && y >= 1 && y < 20);
    }

    static int[] calcMiddle(int x, int y, int dir) {
        return new int[] {x + dx[dir] * 2, y + dy[dir] * 2};
    } 
}