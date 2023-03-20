package y2023.s0316;

public class Solution_Programers_연속펄스부분수열의합 {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int[][] input = {
                { 2, 3, -6, 1, 3, -1, 2, 4 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { -1, -4, -10, -5, -1 },
                { 10, -10, 10, -10 },
                { -10, 10, -10, 10 }
        };
        for (int i = 0; i < input.length; i++) {
            System.out.println(sol.solution(input[i]));
        }
    }

    static class Solution {
        public long solution(int[] sequence) {
            long answer = 0;
            int len = sequence.length;
            long[] sum = new long[len];
            sum[0] = sequence[0];
            long min = 0;
            long max = sequence[0];
            for (int i = 1; i < len; i++) {
                if (i % 2 != 0) {
                    sum[i] = sum[i - 1] - sequence[i];
                } else {
                    sum[i] = sum[i - 1] + sequence[i];
                }
                if (max < sum[i]) {
                    max = sum[i];
                }
                if (min > sum[i]) {
                    min = sum[i];
                }
            }
            long realMax = Math.max(max - min, min - max);
            max = Math.max(max, -min);
            answer = Math.max(realMax, max);
            return answer;
        }
    }
}
