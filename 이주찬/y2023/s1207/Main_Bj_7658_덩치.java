package y2023.s1207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7568
// 아직 못 품
public class Main_Bj_7658_덩치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        int[][] volumes = new int[N][2];
        int[] rank = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            volumes[i][0] = x;
            volumes[i][1] = y;
        }
        for (int i = 0; i < N; i++) {
            int curRank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                if (volumes[i][0] < volumes[j][0] && volumes[i][1] < volumes[j][1]) {
                    curRank++;
                }
            }
            rank[i] = curRank;
            sb.append(curRank).append(" ");
        }

        System.out.print(sb.toString());
    }
}
