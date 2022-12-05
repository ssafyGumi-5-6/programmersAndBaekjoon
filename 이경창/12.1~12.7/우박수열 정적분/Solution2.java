class Solution2 {

    double[] dp;

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        dp = new double[100100];

        dp[0] = 0;

        int check_k = k;
        double k_before = k;

        // k가 1이 아닐 때까지 반복문을 돌린다.
        for(int x = 1; ; x++){
            if(check_k % 2 == 0) check_k /= 2;
            else check_k = check_k * 3 + 1;

            // 각각의 사다리꼴 넓이를 dp에 저장한다.
            // 1 ~ 3 구간이면 : dp[3] - dp[1]
            dp[x] = dp[x-1] + (k_before + (double)check_k) / 2;
            k_before = check_k;

            if(check_k <= 1) break;
        }

        // 이제 확인하는 구간
        for(int i = 0; i < ranges.length; i++){
            // 둘 중 하나라도 0이 아니라면
            int x1 = ranges[i][0] + 0;
            int x2 = ranges[i][1] + k;
            // System.out.println("x1, x2 : " + x1 + "  " + x2 + " " + dp[x1] + " " + dp[x2]);

            if(x2 > x1){
                answer[i] = Double.parseDouble(String.format("%.1f", dp[x2] - dp[x1]));
            }else if(x2 < x1){
                answer[i] = -1.0;
            }else{
                answer[i] = 0.0;
            }
        }


        return answer;
    }
}
