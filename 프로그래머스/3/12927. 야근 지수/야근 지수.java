import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        
        for (int w : works) {
            queue.add(w);
        }
        
        while (n-- > 0) {
            int max = queue.poll();
            max--;
            if (max <= 0) max = 0;
            queue.add(max);
        }
        
        long answer = 0;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            answer += now * now;
        }
        
        return answer;
    }
}

// 왜 야근해?...하지 마...
// 피로도 = 합===남은 작업량^2 의,.
// 1시간 동안 1만큼 처리 가능
// N시간 동안 일하여 야근 피로도를 최소화
// 남은 작업량 배열 works
// return 야근 피로도 최소화한 값