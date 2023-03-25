package Source;

class Solution {

    int answer = 0; // 결과
    int[][] land;
    int[][] dp;

    int solution(int[][] _land) {
        land = _land;

        // 처음에는 dfs로 풀려고 했으나
        // 1 2 4 5
        // 4 3 9 20 와 같은 상황에서는 4 20을 뽑아야 가장 큰 수가 된다.
        // 그래서 backtracking을 사용하려고 하니 행의 개수가 100,000 너무 크다.
        // 결국 dp를 이용하라는 힌트를 보게 되었다.
        // * dp *
        // dp[i][j] = max(dp[i-1][j를 제외한 나머지 열]) + land[i][j]로 각각 업데이트 해주면 될 것 같다.

        dp = new int[land.length][land[0].length];

        for(int col = 0; col < 4; col++) dp[0][col] = land[0][col];

        for(int row = 1; row < land.length; row++){
            // 현재 열에서 확인한다.
            // 0은 0제외 나머지
            dp[row][0] = Math.max(dp[row-1][1], Math.max(dp[row-1][2], dp[row-1][3])) + land[row][0];
            dp[row][1] = Math.max(dp[row-1][0], Math.max(dp[row-1][2], dp[row-1][3])) + land[row][1];
            dp[row][2] = Math.max(dp[row-1][0], Math.max(dp[row-1][1], dp[row-1][3])) + land[row][2];
            dp[row][3] = Math.max(dp[row-1][0], Math.max(dp[row-1][1], dp[row-1][2])) + land[row][3];
        }

        for(int col = 0; col < 4; col++) answer = Math.max(answer, dp[land.length - 1][col]);



        return answer;
    }
}