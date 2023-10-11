import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for(int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; st.hasMoreTokens(); ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] results = new int[N];

        for(int i = 0; i < M; ++i) {
            results[i] = dfs(board, i, 0, -1);
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < M; ++i) {
            answer = Math.min(results[i], answer);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int dfs(int[][] board, int x, int y, int dir) {
        if(y == board.length) {
            return 0;
        }

        int[] dx = {-1, 0, 1};
        int answer = Integer.MAX_VALUE;

        for(int d = 0; d < dx.length; ++d) {
            int nx = x + dx[d];
            if(nx < 0 || nx >= board[y].length || d == dir) {
                continue;
            }

            answer = Math.min(answer, dfs(board, nx, y + 1, d));
        }

        return board[y][x] + answer;
    }
}
