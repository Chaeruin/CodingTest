import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int remain = (100 - progresses[i]) % speeds[i];
            int days = 0;
            if (remain != 0) days = (100 - progresses[i]) / speeds[i] + 1;
            else days = (100 - progresses[i]) / speeds[i];
            queue.add(days);
        }
        
        while (!queue.isEmpty()) {
            int first = queue.poll();
            int count = 1;

            while (!queue.isEmpty() && queue.peek() <= first) {
                count++;
                queue.poll();
            }

            result.add(count);
        }
        
        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}