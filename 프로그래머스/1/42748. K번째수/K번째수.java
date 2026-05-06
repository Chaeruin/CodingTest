import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        
        for (int[] cmd : commands) {
            int[] arr = Arrays.copyOfRange(array, cmd[0] - 1, cmd[1]);
            Arrays.sort(arr);
            answer[idx++] = arr[cmd[2] - 1];
        }
        
        return answer;
    }
}