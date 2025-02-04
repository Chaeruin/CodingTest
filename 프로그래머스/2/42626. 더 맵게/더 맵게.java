import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> scvQueue = new PriorityQueue<>();
        
        for (int scv : scoville) {
            scvQueue.offer(scv);
        }
        
        while (scvQueue.peek() < K) {
            if (scvQueue.size() < 2) {
                return -1;
            }
            
            int leastSpicy = scvQueue.poll();
            int secondLeastSpicy = scvQueue.poll();
            
            int newScoville = leastSpicy + (secondLeastSpicy * 2);
            scvQueue.offer(newScoville);
            
            answer++;
        }
        
        return answer;
    }
}
