class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        
        int index = 0;
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) index++;
        }
        String[] answer = new String[index];
        
        int checkIndex = 0;
        for (int i = 0; i < todo_list.length; i++) {
            if (!finished[i]) answer[checkIndex++] = todo_list[i];
        }
        
        return answer;
    }
}