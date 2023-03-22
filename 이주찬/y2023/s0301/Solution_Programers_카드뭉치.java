package y2023.s0301;

public class Solution_Programers_카드뭉치 {
    public static void main(String[] args) {

    }

    static class Solution {
        static final String YES = "Yes";
        static final String NO = "No";
        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "";
            int len1 = cards1.length;
            int len2 = cards2.length;
            int idx1 = 0;
            int idx2 = 0;
            answer = YES;
            for (int i = 0; i < goal.length; i++) {
                if (idx1 < len1 && goal[i].equals(cards1[idx1])) {
                    idx1++;
                    continue;
                }
                if (idx2 < len2 && goal[i].equals(cards2[idx2])) {
                    idx2++;
                    continue;
                }
                answer = NO;
                break;
            }
            return answer;
        }
    }
}