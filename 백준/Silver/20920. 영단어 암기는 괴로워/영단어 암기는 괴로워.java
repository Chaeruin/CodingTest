
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> note = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M)
                note.put(word, note.getOrDefault(word, 0) + 1);
        }

        List<String> words = new ArrayList<>(note.keySet());
        
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 1. 자주 등장 단어 순 정렬
                if (Integer.compare(note.get(o1), note.get(o2)) != 0) {
                    return Integer.compare(note.get(o2), note.get(o1));
                }
                // 2. 길이가 긴 단어가 먼저 오도록 정렬
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                // 3. 사전 순으로 정렬
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String str : words) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}
