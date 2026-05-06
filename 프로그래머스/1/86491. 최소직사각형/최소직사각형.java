import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        for (int[] size : sizes) {
            Arrays.sort(size);
        }
        
        int max_w = Integer.MIN_VALUE;
        int max_h = Integer.MIN_VALUE;
        
        for (int[] size : sizes) {
            max_w = Math.max(max_w, size[0]);
            max_h = Math.max(max_h, size[1]);
        }
        
        return max_w * max_h;
    }
}