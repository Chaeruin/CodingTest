import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int caseNum = Integer.parseInt(st.nextToken());
            int[] numberList = new int[caseNum];
            for (int k = 0; k < caseNum; k++) {
                numberList[k] = Integer.parseInt(st.nextToken());
            }

            long gcdSum = 0;
            
            for (int k = 0; k < caseNum-1 ; k++) {
                for (int j = k+1; j < caseNum; j++) {
                    gcdSum += getGCD(numberList[k], numberList[j]);
                }
            }

            System.out.println(gcdSum);
        }
    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }
}
