import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int[][] dp = new int[10000][3];

    public static void main(String[] args) {
        Main solution = new Main();
        solution.init();
        String answer = solution.getAnswer(solution.input());
        System.out.println(answer);
    }

    private void init() {
        // dp[n][0] 는 1 + x = n인 조합 모음
        // dp[n][1] 는 2 + x = n인 조합 모음
        // dp[n][2] 는 3 + x = n인 조합 모음
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        for (int i = 3; i < dp.length; ++i) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 2][0] + dp[i - 2][1];
            dp[i][2] = dp[i - 3][0] + dp[i - 3][1] + dp[i - 3][2];
        }
    }

    private int[] input() {
        int[] numbers;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            numbers = new int[n];

            for (int i = 0; i < n; ++i) {
                numbers[i] = Integer.parseInt(br.readLine()) - 1;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numbers;
    }

    private String getAnswer(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        for (int i : numbers) {
            sb.append(dp[i][0] + dp[i][1] + dp[i][2]).append("\n");
        }

        return sb.toString();
    }
}
