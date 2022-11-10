class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0 || numbers[i] % 4 == 1) answer[i] = numbers[i] + 1;
            else {
                // 뒤에서 부터 0을 찾는다.
                long n = 8L;
                while(numbers[i] % n == n - 1) {
                    n *= 2;
                }
                // 0위치가 1이 되게 왼쪽으로 시프트 하고 n을 4로 나눈 값을 빼주면 가장 작은 수가 된다.
                long mod = numbers[i] % n;
                answer[i] = numbers[i] - mod + ((mod << 1) + 1 - (n / 4));
            }
        }
        return answer;
    }
}