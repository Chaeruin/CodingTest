
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> chat = new HashSet<>();

        int gomgom = 0;

        for (int i = 0; i < N; i++) {
            String enterWho = br.readLine();
            if (enterWho.equals("ENTER")) {
                chat.clear();
            } else if (!chat.contains(enterWho)) {
                chat.add(enterWho);
                gomgom++;
            }
        }
        System.out.println(gomgom);
    }
}
