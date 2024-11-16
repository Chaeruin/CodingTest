import java.util.*;
import java.io.*;

public class Solution {

    static int[][] sudoku;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int i = 1; i < TC+1; i++) {
            sudoku = new int[9][9];

            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    sudoku[j][k] = sc.nextInt();
                }
            }

            int result;
            if (xDetect() && yDetect() && nemoDetect()) result = 1;
            else result = 0;

            System.out.printf("#%d %d\n", i, result);
        }
    }


    static boolean xDetect() {
        for (int i = 0; i < 9; i++) {
            int[] validate = new int[]{1,2,3,4,5,6,7,8,9};
            // i (x) 줄에 대해 모든 j(y) 가 겹치지 않아야 함
            for (int j = 0; j < 9; j++) {
                for (int x = 0; x < 9; x++) {
                    if (sudoku[i][j] == validate[x]) validate[x] = 0;
                }
            }
            for (int x = 0; x < 9; x++) {
                if (validate[x] != 0) return false;
            }
        }
        return true;
    }

    static boolean yDetect() {
        for (int i = 0; i < 9; i++) {
            int[] validate = new int[]{1,2,3,4,5,6,7,8,9};
            // i (y) 줄에 대해 모든 j(x) 가 겹치지 않아야 함
            for (int j = 0; j < 9; j++) {
                for (int x = 0; x < 9; x++) {
                    if (sudoku[j][i] == validate[x]) validate[x] = 0;
                }
            }
            for (int x = 0; x < 9; x++) {
                if (validate[x] != 0) return false;
            }
        }
        return true;
        
    }

    static boolean nemoDetect() {
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                int[] validate = new int[]{1,2,3,4,5,6,7,8,9};
                // 3 *3 덩어리에 대해 
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        for (int x = 0; x < 9; x++) {
                            if (sudoku[i+k][j+l] == validate[x]) validate[x] = 0;
                        }
                    }
                }
                for (int x = 0; x < 9; x++) {
                    if (validate[x] != 0) return false;
                }
            }
        }
        return true;
    }
}
