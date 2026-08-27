import java.util.Scanner;

public class Main {

    public static final int MAX_NUM = 100000;
    public static final int MAX_N = 10000;

    public static int n, m;
    public static int[] arr = new int[MAX_N];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int left = 1;
        int right = MAX_NUM;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid)) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
            else right = mid - 1;
        }

         System.out.print(ans);
    }

    public static boolean isPossible(int mid) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += arr[i] / mid;
        }
        return cnt >= m;
    }
}