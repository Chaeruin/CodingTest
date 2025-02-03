import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        boolean[] hasExtra = new boolean[n + 1];
        boolean[] isLost = new boolean[n + 1];
        
        for (int r: reserve) {
            hasExtra[r] = true;
        }
        for (int l: lost) {
            if (hasExtra[l]) { 
                hasExtra[l] = false; 
                answer++;
            } else {
                isLost[l] = true; 
            }
        }
        
        for (int r : reserve) {
            if (hasExtra[r]) { 
                if (r > 1 && isLost[r - 1]) { 
                    isLost[r - 1] = false; 
                    hasExtra[r] = false;
                    answer++;
                } else if (r < n && isLost[r + 1]) { 
                    isLost[r + 1] = false; 
                    hasExtra[r] = false;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}