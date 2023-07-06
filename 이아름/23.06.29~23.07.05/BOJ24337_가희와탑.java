package java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ24337_가희와탑 {

    static int N, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 총 건물 수
        a = Integer.parseInt(st.nextToken());   // 가희가 볼 수 있는 건물
        b = Integer.parseInt(st.nextToken());   // 단비가 볼 수 있는 건물

        ArrayList<Integer> list = new ArrayList<>();

        int g, d;
        if (N + 1 < a + b) {
            System.out.println(-1);
            return;
        }

        int blank = a + b - 1;
        if (a > b) {
            g = 1;
            d = b - 1;

            for (int i = 0; i < blank; i++) {
                if (g <= a) {
                    list.add(g++);
                } else if (d > 0) {
                    list.add(d--);
                }
            }
        } else {
            g = 1;
            d = b;

            for (int i = 0; i < blank; i++) {
                if (g <= a - 1) {
                    list.add(g++);
                } else if (d > 0) {
                    list.add(d--);
                }
            }
        }

        if (a == 1) {
            for (int i = 0; i < N - blank; i++) {
                list.add(1, 1);
            }
        } else {
            for (int i = 0; i < N - blank; i++) {
                list.add(0, 1);
            }
        }

        for (int i : list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}