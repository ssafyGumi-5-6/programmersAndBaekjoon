package y2023.s1207;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_Bj_20125_쿠키의신체측정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        boolean[][] pan = new boolean[N][N];

        int[] heart = new int[2];
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (ch[j] == '*') {
                    pan[i][j] = true;
                }
            }
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (pan[i][j]) {
                    heart[0] = i + 1;
                    heart[1] = j;
                    i = N;
                    j = N;
                }
            }
        }
        sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n");
        int[] body = new int[5]; // left arm, right arm, waist, left leg, right leg
        for (int j = heart[1] - 1; j >= 0; j--) {
            if (pan[heart[0]][j]) {
                body[0]++;
            } else
                break;
        }
        sb.append(body[0]).append(" ");
        for (int j = heart[1] + 1; j < N; j++) {
            if (pan[heart[0]][j]) {
                body[1]++;
            } else 
                break;
        }
        sb.append(body[1]).append(" ");
        for (int i = heart[0] + 1; i < N; i++) {
            if (pan[i][heart[1]]) {
                body[2]++;
            } else 
                break;
        }
        sb.append(body[2]).append(" ");
        for (int i = body[2] + heart[0] + 1; i < N; i++) {
            if (pan[i][heart[1] - 1]) {
                body[3]++;
            } else 
                break;
        }
        sb.append(body[3]).append(" ");
        for (int i = body[2] + heart[0] + 1; i < N; i++) {
            if (pan[i][heart[1] + 1]) {
                body[4]++;
            } else 
                break;
        }
        sb.append(body[4]).append(" ");
        System.out.print(sb.toString());
    }
}
