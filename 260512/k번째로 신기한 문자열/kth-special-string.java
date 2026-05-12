import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String word = st.nextToken();

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (arr[i].startsWith(word)) list.add(arr[i]);
        }

        list.sort(Comparator.naturalOrder());

        System.out.println(list.get(K - 1));
    }
}