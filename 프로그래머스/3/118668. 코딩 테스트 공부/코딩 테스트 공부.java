import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        
        int targetAlp = 0;
        int targetCop = 0;

        for (int[] p : problems) {
            targetAlp = Math.max(targetAlp, p[0]);
            targetCop = Math.max(targetCop, p[1]);
        }
        
        alp = Math.min(alp, targetAlp);
        cop = Math.min(cop, targetCop);

        
        int[][] dp = new int[targetAlp + 1][targetCop + 1];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[alp][cop] = 0;

        for (int a = alp; a <= targetAlp; a++) {
            for (int c = cop; c <= targetCop; c++) {

                if (dp[a][c] == Integer.MAX_VALUE) {
                    continue;
                }

                if (a < targetAlp) {
                    dp[a + 1][c] = Math.min(dp[a + 1][c], dp[a][c] + 1);
                }

                if (c < targetCop) {
                    dp[a][c + 1] = Math.min(dp[a][c + 1], dp[a][c] + 1);
                }

                for (int[] p : problems) {
                    int alpReq = p[0];
                    int copReq = p[1];
                    int alpRwd = p[2];
                    int copRwd = p[3];
                    int cost = p[4];

                    if (a < alpReq || c < copReq) {
                        continue;
                    }

                    int nextA = Math.min(targetAlp, a + alpRwd);
                    int nextC = Math.min(targetCop, c + copRwd);

                    dp[nextA][nextC] = Math.min(
                        dp[nextA][nextC],
                        dp[a][c] + cost
                    );
                }
            }
        }

        return dp[targetAlp][targetCop];
    }
}

// 알고력 코딩력
// 각각 1 높이려면 1의 시간 필요
// 풀이 가능한 문제를 하나를 풀어 올릴 수 있음 -> 값이 정해짐
// 문제 풀이 시 문제가 요구하는 시간이 필요
// 같은 문제 여러번 푸는 것 가능
// 최 단 시 간
// dp

// 입력
// alp, cop
// problems[i] = [alp_req, cop_req, alp_rwd, cop_rwd, cost];
// [필요 알고력, 필요 코딩력, 증가 알고력, 증가 코딩력, 풀이 시간]
// 