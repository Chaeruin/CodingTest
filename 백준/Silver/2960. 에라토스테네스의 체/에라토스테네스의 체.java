import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> num = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            num.add(i);
        }

        int eraseNum = returnErase(num, 2, N, K);
        System.out.println(eraseNum);
    }

    public static int returnErase(List<Integer> num, int start, int N, int K) {
        int eraseNum;
        if (start > N || K <= 0) {  
            return -1;
        }
        if (num.contains(start)) {
            for (int i = start; i <= N; i+=start) {
                if (num.contains(i)) {
                    num.remove(Integer.valueOf(i));
                    --K;
                    eraseNum = i;
                    if (K == 0) return eraseNum;
                }
            }
        }
        return returnErase(num, start + 1, N, K);
    }
}
