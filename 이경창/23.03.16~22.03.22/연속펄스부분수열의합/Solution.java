package 연속펄스부분수열의합;

class Solution {

    public long dpLeftFunction(int[] sequence, int len) {
        long dp[] = new long[sequence.length];

        dp[0] = sequence[0];
        long answer = dp[0];

        for (int i = 1; i < len; i++) {
            // (dp[i-1] + sequence[i]) compare sequence[i]
            long previousData = dp[i - 1] + sequence[i];
            long curData = sequence[i];

            if (previousData < curData) dp[i] = curData;
            else dp[i] = previousData;


            if (answer < dp[i]) answer = dp[i];
        }

        return answer;
    }

    public long dpRightFunction(int[] sequence, int len) {
        long dp[] = new long[sequence.length];

        dp[len - 1] = sequence[len - 1];
        long answer = dp[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            // (dp[i+1] + sequence[i]) compare sequence[i]
            long previousData = dp[i + 1] + sequence[i];
            long curData = sequence[i];

            if (previousData < curData) dp[i] = curData;
            else dp[i] = previousData;


            if (answer < dp[i]) answer = dp[i];
        }

        return answer;
    }

    public long solution(int[] sequence) {
        long answer = 0;
        int[] firstSequence;
        int[] secondSequence;
        // long leftDp[];
        // long rightDp[];
        firstSequence = new int[sequence.length];
        secondSequence = new int[sequence.length];
        // leftDp = new long[sequence.length];
        // rightDp = new long[sequence.length];

        int len = sequence.length;

        // (1)
        // - 1, -1, 1 적용
        // - -1, 1, -1 적용
        int minus = -1;
        for (int i = 0; i < len; i++) {
            firstSequence[i] = sequence[i] * (minus) * (-1);
            secondSequence[i] = sequence[i] * (minus) * (1);

            minus *= -1;
        }

        // (2)
        // - 적용한 것을 기반으로 leftDp, rightDp를 구해서 그 중 가장 큰 값이 정답이다.

        // (2-1) 1, -1, 1을 기준, 인덱스 0부터
        answer = Math.max(answer, dpLeftFunction(firstSequence, len));
        // (2-2) 1, -1, 1을 기준, 인덱스 len - 1부터
        answer = Math.max(answer, dpRightFunction(firstSequence, len));
        // (2-3) -1, 1, -1을 기준, 인덱스 0부터
        answer = Math.max(answer, dpLeftFunction(secondSequence, len));
        // (2-4) -1, 1, -1을 기준, 인덱스 len - 1부터
        answer = Math.max(answer, dpRightFunction(secondSequence, len));

        return answer;
    }
}
