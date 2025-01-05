
import java.io.*;
import java.util.*;

public class Main {

    static int R, C, N;
    static String[][] bomb;
    static int[][] bombTime;
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};
    static int time = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        bomb = new String[R][C];
        bombTime = new int[R][C];

        for (int i = 0; i < R; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                bomb[i][j] = input[j];
                if (bomb[i][j].equals("O")) {
                    bombTime[i][j] = 3;
                }
            }
        }

        bombProcess();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(bomb[i][j]);
            }
            System.out.println();
        }

    }

    static void bombProcess() {
        while (time++ < N) {
            if (time % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bomb[i][j].equals(".")) {
                            bomb[i][j] = "O";
                            bombTime[i][j] = time + 3;
                        }
                    }
                }
            }
            else if (time % 2 == 1) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bombTime[i][j] == time) {
                            bomb[i][j] = ".";
                            for (int d = 0; d < 4; d++) {
                                int ni = i + di[d];
                                int nj = j + dj[d];

                                if (ni < 0 || nj < 0 || ni >= R || nj >= C) continue;

                                if(bomb[ni][nj].equals("O") && bombTime[ni][nj] != time) {
                                    bomb[ni][nj] = ".";
                                    bombTime[ni][nj] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
