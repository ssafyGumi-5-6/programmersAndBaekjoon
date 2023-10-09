package y2023.s0615;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_Bj_1238_파티 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        boolean[][] visit = new boolean[n][n];

        List<Path>[] paths = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            paths[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(st.nextToken());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int time = Integer.parseInt(st.nextToken()) - 1;
            paths[start].add(new Path(end, time));
        }

        

    }
    
    static class Path implements Comparable<Path> {
        int v;
        int time;

        public Path(int v, int time) {
            this.v = v;
            this.time = time;
        }

        @Override
        public int compareTo(Path o) {
            return Integer.compare(v, o.v);
        }
    }
}
