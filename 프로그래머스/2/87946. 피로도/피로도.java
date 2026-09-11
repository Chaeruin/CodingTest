import java.util.*;

class Solution {
    
    public int answer;
    public boolean visited[];
    public int health;
    public int[][] dunge;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        dunge = dungeons;
        health = k;
        
        Arrays.sort(dungeons, (a, b) -> 
            Integer.compare(b[0] - b[1], a[0] - a[1])
        );
        
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

// k : 현재 피로도
// [0] 최소 필요 피로도
// [1] 소모 필요도
// 소팅이 관건 -> 최대로 많이 던전의 수를 탐험
// [0] - [1] = 탐험 후 남게 되는 피로도
// 위 순으로 sorting