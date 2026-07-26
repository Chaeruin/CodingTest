import java.util.*;
import java.io.*;

class Solution {
    
    public Set<Integer> set = new HashSet<>();
    public String[] numb;
    public boolean[] visited;
    
    public int solution(String numbers) {
        numb = numbers.split("");
        visited = new boolean[numb.length];
        
        dfs("");
        
        return set.size();
    }
    
    public void dfs(String str) {
        if (str.length() > numb.length) {
            return;
        }
        
        for (int i = 0; i < numb.length; i++) {
            if (visited[i]) continue;
            
            String temp = str + numb[i];
            int changeNum = Integer.parseInt(temp);
            
            if (isPrime(changeNum)) {
                set.add(changeNum);
                System.out.println("판별후 : " + temp);
            } 
            visited[i] = true;
            dfs(temp);
            visited[i] = false;
        }
        
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {		
            if (n % i == 0) return false;
        }
        return true;
    }
}