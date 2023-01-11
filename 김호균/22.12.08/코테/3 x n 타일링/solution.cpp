int solution(int n) {
    if(n % 2 != 0) return 0;
    
    long long d[n + 1];
    long long sum[n + 1];
    d[0] = 0;
    d[2] = 3;
    sum[2] = 2;
    for(int i = 4; i <= n; i += 2)
    {
        // 바닥 가로 길이n이 4를 넘어서면 해당 바닥을 다 채우는 특별한 모양 2개가 나온다.
        // n이 2 증가할 때마다 특별한 모양으로 채울 수 있는 경우의 수를 추가로 구해야 한다.
        sum[i] = 2 * d[i - 4] + sum[i - 2];
        d[i] = (3 * d[i - 2] + sum[i]) % 1000000007;
    }
    return (int)d[n];
}