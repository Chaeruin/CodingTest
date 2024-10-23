import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<String, Integer> integerSort = new LinkedHashMap<>();

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            if (integerSort.get(input[i]) != null) {
                integerSort.replace(input[i], integerSort.get(input[i])+1);
            } else {
                integerSort.put(input[i], 1);
            }
        }
        

        List<String> keys = new ArrayList<>(integerSort.keySet());

		Collections.sort(keys, (v1, v2) -> (integerSort.get(v2).compareTo(integerSort.get(v1)))); 
		
        for (String key : keys) {
            System.out.print((key + " ").repeat(integerSort.get(key)));
        }
    }

    
}