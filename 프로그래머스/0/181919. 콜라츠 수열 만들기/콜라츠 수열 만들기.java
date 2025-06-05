import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> arr = new ArrayList<>();
        
        while (n != 1) {
            if (n % 2 == 0) {
                arr.add(n);
                n /= 2;
            }
            else {
                arr.add(n);
                n = 3 * n + 1;
            }
            
            if (n == 1) arr.add(n);
            
        }
        
        int[] answer = arr
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();;
        return answer;
    }
}