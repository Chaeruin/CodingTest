import java.util.*;
import java.io.*;

class Solution {
    public int answer = 0;
    public String[] vowels = {"A","E","I","O","U"};
    public List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        
        dfs("");
        
        return list.indexOf(word);
    }
    
    public void dfs(String word) {
        if (word.length() > 5) {
            return;
        }
        
        list.add(word);
        
        for (int i = 0; i < vowels.length; i++) {
            dfs(word + vowels[i]);
        }
    }
}