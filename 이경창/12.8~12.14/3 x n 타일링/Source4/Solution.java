package Source4;

class Solution {

    int[] dp;
    int[] dpSum;
    int mod = 1000000007;

    public int solution(int n) {
        int answer = 0;

        // n이 홀수이면 0 (만들 수가 없다.)
        if(n % 2 != 0) return 0;

        // n이 짝수이면
        dp = new int[n+1];
        dpSum = new int[n+1];

        dp[0] = 0;
        dp[2] = 3;
        dpSum[2] = dp[2] * 2 % mod;

        for(int i = 4; i <= n; i += 2){
            dp[i] = ((dp[i - 2] * 3 + dpSum[i-4])  + 2) % mod;

            // 중간에 2개씩 채워지는거 더해줘야함 (가로길이 기준 n - 4번째부터 확인)
            // 문제 예시 그림 보면 마지막 2개가 dpSum[n] = dp[n] * 2 + dp[n-4]*2 + dp[n-6]*2 + ~ + dp[2]*2를 빼줌
            dpSum[i] = dpSum[i - 2] + dp[i] * 2;

        }

        answer = dp[n] % mod;

        return answer;
    }
}

// 계속 0점...
//입력값 〉	5000
//기댓값 〉	658712818
//실행 결과 〉	실행한 결괏값 58563386이 기댓값 658712818과 다릅니다.
// 라고 계속 떠서 mod를 어디 넣어야할지 모르겠음