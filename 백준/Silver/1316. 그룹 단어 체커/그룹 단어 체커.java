import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        int groupWords = num;

        for (int i = 0; i < num; i++) {
            String word = br.readLine();
            boolean[] isChecked = new boolean[26];

            for (int j = 0; j < word.length(); j++) {
                if (!isChecked[word.charAt(j) - 'a']) {
                    isChecked[word.charAt(j) - 'a'] = true;
                } else if (j > 0 && word.charAt(j) != word.charAt(j - 1)) {
                    groupWords--;
                    break;
                }
            }
        }
        
        System.out.println(groupWords);
    }
}
