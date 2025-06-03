class Solution {
    public int solution(int hp) {
        int answer = 0;
        while (hp > 0) {
            if (hp / 5 > 0) {
                answer += (hp / 5);
                hp -= (hp / 5) * 5;
            }
            else if (hp / 3 > 0) {
                answer += (hp / 3);
                hp -= (hp / 3) * 3;
            }
            else if (hp > 0 && hp < 3) {
                answer += hp;
                break;
            }
        }
        return answer;
    }
}