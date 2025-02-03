import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        for (int i = 0; i < sizes.length; i++) {
            Arrays.sort(sizes[i]);
        }
        
        int width = -1;
        for (int i = 0; i < sizes.length; i++) {
            width = Math.max(width, sizes[i][1]);
        }
        
        
        int height = -1;
        
        for (int i = 0; i < sizes.length; i++) {
            height = Math.max(height, sizes[i][0]);
        }
        
        int answer = width * height;
        
        return answer;
    }
}