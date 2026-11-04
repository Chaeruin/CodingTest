import java.time.LocalDate;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String t : terms) {
            String[] str = t.split(" ");
            map.put(str[0], Integer.parseInt(str[1]));
        }
        
        LocalDate tday = getTodayDate(today);
        
        for (int i = 0; i < privacies.length; i++) {
            String[] dateType = privacies[i].split(" ");
            
            // 0 : date / 1 : type
            LocalDate afterDate = getAfterDate(dateType[0], map.get(dateType[1]));
            
            if (!afterDate.isAfter(tday)) answerList.add(i + 1);
        }
        
        int[] answer = new int[answerList.size()];
        int idx = 0;
        for (int i : answerList) {
            answer[idx++] = i;
        }
        
        return answer;
    }
    
    public LocalDate getTodayDate(String today) {
        String[] arr = today.split("\\.");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        return LocalDate.of(year, month, day);
    }
    
    public LocalDate getAfterDate(String today, int month) {
        String[] arr = today.split("\\.");
        int year = Integer.parseInt(arr[0]);
        int mon = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        if (mon + month > 12) {
            int totalMonth = (mon - 1) + month;

            year += totalMonth / 12;
            mon = totalMonth % 12 + 1;
        } else mon += month;
        return LocalDate.of(year, mon, day);
    }
}