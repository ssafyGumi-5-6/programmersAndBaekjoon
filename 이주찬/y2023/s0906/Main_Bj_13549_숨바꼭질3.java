package y2023.s0906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Bj_13549_숨바꼭질3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int sec = 0;
        Queue<int[]> qu = new PriorityQueue<int[]>((int[] arr1, int[] arr2) -> arr1[1] - arr2[1]);
        qu.offer(new int[]{n, 0});
        while (true) {
            int[] cur = qu.poll();
            if (cur[0] == k) {
                sec = cur[1];
                break;
            }
            if (cur[0] < k) {
                qu.offer(new int[] { cur[0] + 1, cur[1] + 1 });
                if(cur[0] != 0)
                    qu.offer(new int[] { cur[0] * 2, cur[1] });
            }
            qu.offer(new int[] { cur[0] - 1, cur[1] + 1 });
        }
        System.out.println(sec);
    }
}
