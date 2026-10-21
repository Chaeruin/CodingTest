import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scvQueue = new PriorityQueue<>();
        
        for (int s : scoville) {
            scvQueue.add(s);
        }
        
        int answer = 0;
        
        while (scvQueue.size() > 1 && scvQueue.peek() < K) {
            int first = scvQueue.poll();
            int second = scvQueue.poll();
            int mix = first + second * 2;
            scvQueue.add(mix);
            answer++;
        }
        
        if (scvQueue.peek() < K) return -1;
        
        return answer;
    }
}