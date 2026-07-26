import java.util.*;
import java.io.*;

class Solution {
    public int answer;
    public boolean visited[];
    public int health;
    public int[][] dunge;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        dunge = dungeons;
        health = k;
        
        Arrays.sort(dunge, (o1, o2) -> {
            return (o2[0] - o2[1]) - (o1[0] - o1[1]);
        });
        
        findDun(0);
        
        return answer;
    }
    
    public void findDun(int depth) {
        answer = Math.max(answer, depth);
        
        for (int i = 0; i < dunge.length; i++) {
            if (health >= dunge[i][0] && !visited[i]) {
                visited[i] = true;
                health -= dunge[i][1];
                findDun(depth + 1);
                visited[i] = false;
                health += dunge[i][1];
            }
        }
    }
}
