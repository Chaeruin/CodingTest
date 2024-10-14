import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[] bulb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 전구 갯수, 명령어 갯수
        String[] num = br.readLine().split(" ");
        int number = Integer.parseInt(num[0]);
        int P = Integer.parseInt(num[1]);

        // 2. 전구 상태 저장 (배열 사용)
        bulb = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int j = 0;
        while (j < P) {
            String[] command = br.readLine().split(" ");
            change(Integer.parseInt(command[0]), Integer.parseInt(command[1]), Integer.parseInt(command[2]));
            j++;
        }

        // 4. 출력
        for (int i = 0; i < bulb.length; i++) {
            System.out.print(bulb[i]);
            if (i < bulb.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static void change(int n, int l, int r) {
        l--; // 1-based index를 0-based index로 변환
        r--; // 마찬가지로 1-based index를 0-based로 변환
        
        switch (n) {
            case 1:
                bulb[l] = r + 1; // l번째 전구를 r로 바꿈
                break;
            case 2:
                for (int i = l; i <= r; i++) {
                    bulb[i] = bulb[i] == 0 ? 1 : 0;
                }
                break;
            case 3:
                Arrays.fill(bulb, l, r + 1, 0);
                break;
            case 4:
                Arrays.fill(bulb, l, r + 1, 1);
                break;
            default:
                break;
        }
    }
}