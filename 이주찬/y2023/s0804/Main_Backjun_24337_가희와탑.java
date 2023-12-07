package y2023.s0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 아직 못 풀었음
public class Main_Backjun_24337_가희와탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 빌딩 개수
        int a = Integer.parseInt(st.nextToken()); // 왼쪽에서 보이는 빌딩 수
        int b = Integer.parseInt(st.nextToken()); // 오른쪽에서 보이는 빌딩 수
        // 왼쪽과 오른쪽에서 보이는 빌딩 수의 합이 전체 빌딩 수 + 1 보다 많으면 불가능함
        if (a + b > n + 1) {
            System.out.println(-1);
            return;
        }
        int max = Math.max(a, b);
        int[] buildings = new int[n];

        int nowH = 1;
        int cursor = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nowH >= b) {
                cursor = i;
                break;
            }
            buildings[i] = nowH++;
        }
        if (b == 1) {
            buildings[n - 1] = max;
            nowH = max - 1;
        } else {
            nowH = max;
        }
        int nowA = 1;
        for (int i = cursor; i >= 0; i--) {
            buildings[i] = nowH;
            nowA++;
            if (nowA >= a) {
                nowH = 1;
            }
            if (nowH > 1) {
                nowH--;
            }
            
        }


        /*
        10 1 9
        9 1 8 7 6 5 4 3 2 1
        10 9 1
        1 2 3 4 5 6 7 8 1 9
        9 1 5
        5 1 1 1 1 4 3 2 1
        9 5 1
        1 1 1 1 1 2 3 4 5
         */

        for (int i = 0; i < n; i++) {
            sb.append(buildings[i]).append(" ");
        }

        System.out.print(sb.toString());
    }
}
