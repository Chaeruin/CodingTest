import java.util.Scanner;
public class Main {

    public static int N;
    public static int[] selected;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        selected = new int[N];
        visited = new boolean[N];

        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            printAnswer();
            return;
        }

        for (int i = N - 1; i >= 0; i--) {
            if (visited[i]) continue;
            visited[i] = true;
            selected[depth] = i + 1;
            dfs(depth + 1);
            visited[i] = false;
        }
    }

    public static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        for (int i : selected) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}