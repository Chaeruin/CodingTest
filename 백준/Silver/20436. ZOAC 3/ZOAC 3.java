
import java.io.*;
import java.util.*;

public class Main {

    static char[][] leftQwerty = {
            {'q', 'w', 'e', 'r', 't'},
            {'a', 's', 'd', 'f', 'g'},
            {'z', 'x', 'c', 'v'}
    };
    static char[][] rightQwerty = {
            {' ', 'y', 'u', 'i', 'o', 'p'},
            {' ', 'h', 'j', 'k', 'l'},
            {'b', 'n', 'm'}
    };

    static Map<Character, int[]> keyBoardXY = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char sL = st.nextToken().charAt(0);
        char sR = st.nextToken().charAt(0);

        char[] str = br.readLine().toCharArray();

        storeKeyBoardXY();

        int time = 0; // 걸리는 시간

        int[] currentLeft = keyBoardXY.get(sL);
        int[] currentRight = keyBoardXY.get(sR);

        for (int i = 0; i < str.length; i++) {
            int[] currentS = keyBoardXY.get(str[i]);

            if (leftKey(str[i])) { // 왼손, 자음
                time += Math.abs(currentLeft[0] - currentS[0]) + Math.abs(currentLeft[1] - currentS[1]); // 왼손 x, y 좌표 차
                currentLeft = currentS; // 왼손 위치 변경
            } else { // 오른손, 모음
                time += Math.abs(currentRight[0] - currentS[0]) + Math.abs(currentRight[1] - currentS[1]); // 오른손 x, y 좌표 차
                currentRight = currentS; // 오른손 위치 변경
            }

            time += 1; // 키 누르는 시간
        }

        System.out.println(time);
    }

    // 키보드 좌표 저장
    static void storeKeyBoardXY() {
        // 왼손 자판 위치 저장
        for (int i = 0; i < leftQwerty.length; i++) {
            for (int j = 0; j < leftQwerty[i].length; j++) {
                keyBoardXY.put(leftQwerty[i][j], new int[]{i, j});
            }
        }

        // 오른손 자판 위치 저장
        for (int i = 0; i < rightQwerty.length; i++) {
            for (int j = 0; j < rightQwerty[i].length; j++) {
                keyBoardXY.put(rightQwerty[i][j], new int[]{i, j});
            }
        }
    }

    // 자음 확인
    static boolean leftKey(char c) {
        return "qwertasdfgzxcv".indexOf(c) != -1;
    }
}
