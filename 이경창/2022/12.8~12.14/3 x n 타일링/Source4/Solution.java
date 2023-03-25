package Source4;

class Solution {

    long[] dp;
    long[] dpSum;
    long mod = 1000000007;

    public long solution(int n) {
        long answer = 0;

        // n이 홀수이면 0 (만들 수가 없다.)
        if(n % 2 != 0) return 0;

        // n이 짝수이면
        dp = new long[n+1];
        dpSum = new long[n+1];

        dp[0] = 0;
        dp[2] = 3;
        dpSum[2] = dp[2] * 2 % mod;

        for(int i = 4; i <= n; i += 2){

            // dp[i] = ((dp[i - 2] * 3 + dpSum[i-4])  + 2) % mod;
            dp[i] = ((dp[i -2] * 3 % mod + dpSum[i-4] % mod) % mod + 2) % mod;

            // 중간에 2개씩 채워지는거 더해줘야함 (가로길이 기준 n - 4번째부터 확인)
            // 문제 예시 그림 보면 마지막 2개가 dpSum[n] = dp[n] * 2 + dp[n-4]*2 + dp[n-6]*2 + ~ + dp[2]*2를 빼줌

            dpSum[i] = (dpSum[i - 2] + (dp[i] * 2) % mod) % mod;

        }

        answer = dp[n];

        return answer;
    }
}