import java.util.*;
import java.io.*;

public class Solution {
    static int[] sual;
    static int countK, N, K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int i = 1; i < TC +1; i++) {
            N = sc.nextInt();
            K = sc.nextInt();

            sual = new int[N];
            for (int j = 0; j < N; j++) {
                sual[j] = sc.nextInt();
            }

            countK = 0;
            powerset(0, 0);
            
            System.out.println("#" + i + " " + countK);
        }
    }

    static void powerset(int idx, int sum) {
        if(idx == N) {					// 수열을 전부 체크했을 때
        	if(sum == K) countK++;		// 부분집합의 합이 K와 같으면
            return;
        } else {
            // 부분집합에 포함시키지 않음 -> 더하지 않음
            powerset(idx + 1, sum);
            // 부분집합에 포함시킴 -> 더함
            sum += sual[idx];
            powerset(idx + 1, sum);
        }
    }
}
