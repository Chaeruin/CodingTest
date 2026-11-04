import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        Map<String, Integer> rank = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }
        
        for (String calling : callings) {
            int idx = rank.get(calling);

            String prev = players[idx - 1];

            players[idx - 1] = calling;
            players[idx] = prev;

            rank.put(calling, idx - 1);
            rank.put(prev, idx);
        }
        
        for (Map.Entry<String, Integer> entry : rank.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            
            answer[value] = key;
        }
        
        
        return answer;
    }
}