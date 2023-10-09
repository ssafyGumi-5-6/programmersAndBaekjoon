package y2023.s0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Backjun_24337_가희와탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 빌딩 개수
        int a = Integer.parseInt(st.nextToken()); // 왼쪽에서 보이는 빌딩 수
        int b = Integer.parseInt(st.nextToken()); // 오른쪽에서 보이는 빌딩 수

        int aNow = 1; // 현재 왼쪽에서 보이는 건물 수
        int bNow = 1; // 현재 오른쪽에서 보이는 건물 수

        // 빌딩 배열
        int[] buildings = new int[n];
        // 왼쪽과 오른쪽에서 보이는 빌딩 수의 합이 전체 빌딩 수 + 1 보다 많으면 불가능함
        if (a + b > n + 1) {
            System.out.println(-1);
            return;
        }
        int cursor = 0;
        for (int i = 0; i < n; i++) {
            if (aNow > a) {
                break;
            }
            buildings[i] = aNow;
            aNow++;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (bNow >= b) {
                break;
            }
            buildings[i] = bNow;
            bNow++;
        }
        for (int i = 0; i < n; i++) {
            if (buildings[i] == 0) {
                buildings[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(buildings[i]).append(" ");
        }
        System.out.print(sb.toString());
    }
}
