import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2169_로봇조종하기 {

    static int N, M;
    static int[][] map, dp, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];
        temp = new int[2][M];   // 왼, 위 & 오, 위

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 초기값
        dp[0][0] = map[0][0];

        // 첫번째 줄
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }

        // 두번째 줄 ~ 마지막 줄
        for (int i = 1; i < N; i++) {

            // 왼, 위
            temp[0][0] = dp[i - 1][0] + map[i][0];
            for (int j = 1; j < M; j++) {
                temp[0][j] = Math.max(temp[0][j - 1], dp[i - 1][j]) + map[i][j];
            }

            // 오, 위
            temp[1][M - 1] = dp[i - 1][M - 1] + map[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                temp[1][j] = Math.max(temp[1][j + 1], dp[i - 1][j]) + map[i][j];
            }

            // 최대값
            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}