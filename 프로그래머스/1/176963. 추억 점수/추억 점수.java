class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        int piv = 0;
        
        for (int i = 0; i < photo.length; i++) {
            int num = 0;
            
            for (int j = 0; j < photo[i].length; j++) {
                num += nameMatchesNumber(name, yearning, photo[i][j]);
            }
            answer[piv++] = num;
        }        
        
        return answer;
    }
    
    public int nameMatchesNumber(String[] name, int[] yearning, String photoes) {
        for (int i = 0; i < name.length; i++) {
            if (photoes.equals(name[i])) {
                System.out.println(name[i]);
                return yearning[i];
            }
        }
        return 0;
    }
}