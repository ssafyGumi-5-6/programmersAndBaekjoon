package s1201;

public class Soluciton_Programers_혼자놀기의달인 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] input = {
                { 8, 6, 3, 7, 2, 5, 1, 4 },
                { 1, 2 }
        };
        for (int i = 0; i < input.length; i++) {
            System.out.println(sol.solution(input[i]));
        }
    }

    static class Solution {
        static int[] maxs = new int[2];

        public int solution(int[] cards) {
            int len = cards.length;
            boolean[] visited = new boolean[len];
            for (int i = 0; i < len; i++) {
                if (visited[i])
                    continue;
                pickCard(i, cards, visited, 0);
            }
            int answer = maxs[0] * maxs[1];
            return answer;
        }

        public static void setMax(int num) {
            if (maxs[0] < num) {
                maxs[1] = maxs[0];
                maxs[0] = num;
            } else if (maxs[1] < num) {
                maxs[1] = num;
            }
        }

        public static void pickCard(int num, int[] cards, boolean[] visited, int cnt) {
            if (visited[num]) {
                setMax(cnt);
                return;
            }
            visited[num] = true;
            pickCard(cards[num] - 1, cards, visited, cnt + 1);
        }
    }
}