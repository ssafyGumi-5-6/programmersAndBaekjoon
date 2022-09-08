public class Solution_Programers_네트워크 {
    public static void main(String[] args) {
        Solution_네트워크 sol = new Solution_네트워크();
        int[] inputN = { 3, 3 };
        int[][][] inputC = {
            {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
            },
            {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
            }
        };
        for (int i = 0; i < inputN.length; i++) {
            System.out.println(sol.solution(inputN[i], inputC[i]));
        }
    }
}

class Solution_네트워크 {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                answer++;
                dfs(i,computers, visit, n);
            }
        }
        return answer;
    }

    static void dfs(int curY, int[][] computers, boolean[] visit, int n) {
        visit[curY] = true;
        for (int i = 0; i < n; i++) {
            if (i == curY)
                continue;
            if (computers[curY][i] == 1 && !visit[i]) {
                dfs(i, computers, visit, n);
            }
        }
    }
}