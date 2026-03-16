import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int result = 0;
        int left = 0;
        int right = arr[N - 1] - arr[0]; // 최대 간격

        while (left <= right) {
            int cnt = 1;
            int cur = arr[0];

            int mid = (right + left) / 2;  //공유기 설치의 최소 간격 임의 설정(mid)

            for (int i = 1; i < N; i++) {
                if (arr[i] - cur >= mid) {
                    cnt++;
                    cur = arr[i];
                }
            }

            if (cnt >= C) { // 공유기간의 거리를 설정해서 최소 C개만큼 설치했을 경우
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}