
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        boolean[] prime = new boolean[n + 1]; // 아리스토테네스의 체

        prime[0] = true;
        prime[1] = true;

        // 아리스토테네스의 체 초기화
        for(int i = 2; i * i < prime.length; i++) {
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        for(int i = m; i <= n; i++) {
            if(!prime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
