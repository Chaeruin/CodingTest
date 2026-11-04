class Solution {
    public int solution(String s) {
        int cnt = 0;

        char x = s.charAt(0);
        int xCnt = 0;
        int notXCnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (xCnt == notXCnt) {
                if (xCnt != 0) cnt++;
                x = c; 
                xCnt = notXCnt = 0;
            }

            if (x == c) xCnt++;
            else notXCnt++;
        }

        return cnt + 1;
    }
}

// 첫글자 x
// 왼 -> 오 로 가며
// x and x가 아닌 다른 글자들이 나온 횟수를 각각 세기
// ex ) banana
// x = 'b'
// 다음 a => b 1회, a 1회이므로 분리
// x = 'n'
// 다음 a => n 1회, a 1회이므로 분리

// ...
// 분해한 문자열의 개수를 return