import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> setOne = new HashSet<>();
        for (int i = 0; i < N; i++) {
            setOne.add(br.readLine());
        }

        List<String> setTwo = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            setTwo.add(br.readLine());
        }

        int count = 0;
        for (String str : setTwo) {
            if (setOne.contains(str)) {
                count++;
            }
        }

        System.out.println(count);
    }
}