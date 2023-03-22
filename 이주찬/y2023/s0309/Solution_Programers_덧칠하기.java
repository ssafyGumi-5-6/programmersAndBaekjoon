package y2023.s0309;

public class Solution_Programers_덧칠하기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(8, 4, new int[]{2,3,6}));
    }
    static class Solution {
        public int solution(int n, int m, int[] section) {
            int cnt = 0;
            int now = 0;
            for (int i = 0; i < section.length; i++) {
                int cur = section[i];
                if (cur > now) {
                    cnt++;
                    now = cur + m - 1;
                }
            }
            return cnt;
        }
    }
}
