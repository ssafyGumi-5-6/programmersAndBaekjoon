import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int max = 0;
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                max = Math.max(calculateMax(i, j, board, visited, i, j, 1), max);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static int calculateMax(int y, int x, int[][] board, boolean[][] visited, int ny, int nx, int length) {
        // 길이가 4인 dfs
        if(length == 4) {
            return board[ny][nx];
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int max = 0;
        for(int d = 0; d < 4; ++d) {
            int nny = ny + dy[d];
            int nnx = nx + dx[d];

            if(nny < 0 || nnx < 0 || nny >= board.length || nnx >= board[y].length || visited[nny][nnx]) {
                continue;
            }

            visited[nny][nnx] = true;
            max = Math.max(max, calculateMax(y, x, board, visited, nny, nnx, length + 1));
            visited[nny][nnx] = false;
        }

        int TBlock = 0;
        // 길이가 3이고 특정 조건을 만족하면
        // T블럭의 크기를 계산한 후 dfs 결과와 비교하여 더 큰 값을 반환한다.
        if(length == 3) {
            if(nx == x) {
                if(ny == y + 2) {
                    if(x - 1 >= 0) {
                        TBlock = Math.max(TBlock, board[y + 1][x - 1]);
                    }

                    if(x + 1 < board[y].length) {
                        TBlock = Math.max(TBlock, board[y + 1][x + 1]);
                    }
                } else if(ny == y - 2) {
                    if(x - 1 >= 0) {
                        TBlock = Math.max(TBlock, board[y - 1][x - 1]);
                    }

                    if(x + 1 < board[y].length) {
                        TBlock = Math.max(TBlock, board[y - 1][x + 1]);
                    }
                }
            }else if(ny == y) {
                if(nx == x + 2) {
                    if(y - 1 >= 0) {
                        TBlock = Math.max(TBlock, board[y - 1][x + 1]);
                    }

                    if(y + 1 < board.length) {
                        TBlock = Math.max(TBlock, board[y + 1][x + 1]);
                    }
                } else if(nx == x - 2) {
                    if(y - 1 >= 0) {
                        TBlock = Math.max(TBlock, board[y - 1][x - 1]);
                    }

                    if(y + 1 < board.length) {
                        TBlock = Math.max(TBlock, board[y + 1][x - 1]);
                    }
                }
            }

            max = Math.max(TBlock, max);
        }

        return board[ny][nx] + max;
    }

}
