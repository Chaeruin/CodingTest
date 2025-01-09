
import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int N;
    static boolean[] visited;
    static int count = 0;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visited = new boolean[N + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        System.out.println(result.size());
        result.sort(Comparator.naturalOrder());
        result.forEach(System.out::println);
    }

    static void dfs(int start, int target) {

        if(!visited[arr[start]]) {
            visited[arr[start]] = true;

            dfs(arr[start], target);

            visited[arr[start]] = false;
        }

        if(arr[start] == target) {
            result.add(target);
        }
    }
}
