import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] count = {0, 0, 0};
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i = 0; i < answers.length; i++) {
            if (a[i % 5] == answers[i]) {
                count[0]++;
            }
            if (b[i % 8] == answers[i]) {
                count[1]++;
            }
            if (c[i % 10] == answers[i]) {
                count[2]++;
            }
        }
        
        int max = Math.max(count[0], count[1]);
        max = Math.max(max, count[2]);
        
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (max == count[i]) {
                cnt++;
            }
        }
        
        int[] answer = new int[cnt];
        
        cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (max == count[i]) {
                answer[cnt++] = i + 1;
            }
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}