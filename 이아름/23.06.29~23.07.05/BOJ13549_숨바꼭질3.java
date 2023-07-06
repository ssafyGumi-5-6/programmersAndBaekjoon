package java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13549_숨바꼭질3 {

    private static final int MAX = 100_001;
    static int[] dp;
    static int[] mov = {2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[MAX];
        Arrays.fill(dp, Integer.MAX_VALUE);

        bfs(N);
        System.out.println(dp[K]);
    }

    private static void bfs(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        dp[n] = 0;
        pq.offer(n);

        while (!pq.isEmpty()) {
            int cur = pq.poll();

            for (int i = 0; i < 3; i++) {
                int next, time;

                if (i == 0) {
                    next = cur * mov[i];
                    time = 0;
                } else {
                    next = cur + mov[i];
                    time = 1;
                }

                if (next >= 0 && next < MAX && dp[next] > dp[cur] + time) {
                    pq.offer(next);
                    dp[next] = dp[cur] + time;
                }
            }
        }
    }
}