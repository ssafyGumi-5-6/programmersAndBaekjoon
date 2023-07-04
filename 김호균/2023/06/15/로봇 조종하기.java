import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        int[][] dp = new int[N][M];
        dp[0][0] = board[0][0];
        for (int i = 1; i < M; i++) {
            // 첫 행은 오른쪽 이동으로만 올 수 있다.
            dp[0][i] = dp[0][i - 1] + board[0][i];
        }

        for (int i = 1; i < N; i++) {
            int[] leftStartDP = new int[M]; // 왼쪽에서 오른쪽으로 이동하는 최댓값
            int[] rightStartDP = new int[M]; // 오른쪽에서 왼쪽으로 이동하는 최댓값
            leftStartDP[0] = dp[i - 1][0] + board[i][0];
            rightStartDP[M - 1] = dp[i - 1][M - 1] + board[i][M - 1];
            for (int j = 1; j < M; j++) {
                // 바로 위 칸과 왼(오른)쪽 부터 누적된 값을 비교해 더 큰 값과의 합을 저장한다.
                leftStartDP[j] = Math.max(leftStartDP[j - 1], dp[i - 1][j]) + board[i][j];
                rightStartDP[M - 1 - j] =
                    Math.max(rightStartDP[M - j], dp[i - 1][M - 1 - j]) + board[i][M - 1 - j];
            }

            for (int j = 0; j < M; j++) {
                // 왼쪽부터 누적된 최댓값과 오른쪽부터 누적된 최댓값을 비교하여 큰 값을 저장한다.
                dp[i][j] = Math.max(leftStartDP[j], rightStartDP[j]);
            }
        }

        System.out.print(dp[N - 1][M - 1]);

        sc.close();
    }
}
