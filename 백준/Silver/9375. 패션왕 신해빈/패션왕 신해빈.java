import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 
 
		while (T -- > 0) {
			
			HashMap<String, Integer> hm = new HashMap<>();	// <종류, 개수>
			
			int N = Integer.parseInt(br.readLine());	// 입력받는 옷의 개수
			
			while (N-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				st.nextToken();	// 옷 이름은 필요 없음 
				
				String kind = st.nextToken();	// 옷 종류 
 
				
				if (hm.containsKey(kind)) {
					hm.put(kind, hm.get(kind) + 1);
				} 
				else {
					hm.put(kind, 1);
				}
			}
 
			int result = 1;
 
			for (int val : hm.values()) {
				result *= (val + 1);
			}
			sb.append(result - 1).append('\n');
 
		}
		System.out.println(sb);
	}
 
}