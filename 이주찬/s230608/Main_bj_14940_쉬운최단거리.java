package s230608;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_bj_14940_쉬운최단거리 {
    static int[] se = new int[] { -1, 0, 1, 0 };
    static int[] ga = new int[] {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] answer = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] start = new int[2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 2) {
                    start[0] = i;
                    start[1] = j;
                }else if(num == 0) {
                    visited[i][j] = true;
                }
            }
            // 13.209.90.105
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(start);
        visited[start[0]][start[1]] = true;
        int depth = 0;
        while (!dq.isEmpty()) {
            depth++;
            int size = dq.size();
            for (int d = 0; d < size; d++) {
                int[] current = dq.poll();
                for (int i = 0; i < 4; i++) {
                    int dy = current[0] + se[i];
                    int dx = current[1] + ga[i];
                    if (dy < 0 || dx < 0 || dy >= n || dx >= m || visited[dy][dx]) {
                        continue;
                    }
                    visited[dy][dx] = true;
                    dq.add(new int[] { dy, dx });
                    answer[dy][dx] = depth;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && answer[i][j] == 0) {
                    answer[i][j] = -1;
                }
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
