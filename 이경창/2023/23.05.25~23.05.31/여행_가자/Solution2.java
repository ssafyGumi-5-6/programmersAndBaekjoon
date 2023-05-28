package 여행_가자;

import java.util.*;
import java.io.*;

public class Solution2 {

    static int N, M;
    static int p[];

    static int find(int node) {
        if (p[node] == node) return node;
        return p[node] = find(p[node]);
    }

    static void union(int first, int second) {
        int nextFirst = find(p[first]);
        int nextSecond = find(p[second]);

        if (nextFirst > nextSecond) p[nextFirst] = nextSecond;
        else p[nextSecond] = nextFirst;
    }

    static int stoi(String s) {
        return Integer.valueOf(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = stoi(st.nextToken());

        p = new int[N + 1];

        for (int i = 0; i <= N; i++) p[i] = i;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int k = stoi(st.nextToken());
                if (k == 1) union(i + 1, j + 1);

            }
        }

        st = new StringTokenizer(br.readLine());
        int[] ans = new int[M];
        boolean flag = true;

        for (int i = 0; i < M; i++) {
            ans[i] = find(stoi(st.nextToken()));
            if (!(i == 0) && ans[i] != ans[i - 1]) flag = false;
        }

        if (!flag) sb.append("NO");
        else sb.append("YES");

        System.out.println(sb);

        br.close();
    }
}