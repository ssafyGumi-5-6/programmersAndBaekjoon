package y2023.s0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_Backjun_13549숨바꼭질3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] map = new int[100001];
        for (int i = 0; i <= n; i++) {
            map[i] = n - i;
        }
        int cur = n;
        Deque<Integer> dq = new ArrayDeque<>();
        while (cur < map.length) {
            cur *= 2;
            dq.add(cur);
        }
        int start = n;
        while (!dq.isEmpty()) {
            cur = dq.poll();
            for (int i = start; i < cur; i++) {
                
            }
        }
    }
}
