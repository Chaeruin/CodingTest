import java.util.*;
import java.io.*;

class Main {
    static int N, E;
    static List<List<Integer>> arr;
    static Set<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        result = new HashSet<>();
        
        StringTokenizer st;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            List<Integer> camp = new ArrayList<>();
            for (int s = 0; s < size; s++) {
                camp.add(Integer.parseInt(st.nextToken()));
            }
            
            arr.add(camp);
        }
        // 입력
        
        for (List<Integer> campArr: arr) {
            if (campArr.contains(1)) {
                if (result.contains(1)) {
                    Set<Integer> newResult = new HashSet<>();
                    for (int c: campArr) {
                        for (int r: result) {
                            if (c == r) {
                                newResult.add(c);
                            }
                        }
                    }
                    result = newResult;
                } else {
                    result = new HashSet<>(campArr);
                }
            } else {
                for (int c: campArr) {
                    result.add(c);
                }
            }
        }
        
        List<Integer> resultList = new ArrayList<>(result);
        Collections.sort(resultList);
        for (int r: resultList) {
            System.out.println(r);
        }
        
    }
}