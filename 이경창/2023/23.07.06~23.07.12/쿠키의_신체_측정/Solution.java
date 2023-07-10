package 쿠키의_신체_측정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int N;
    private static char[][] c;

    private static boolean isWithinRange(int x, int y){
        if(0 <= x && 0 <= y && x < N && y < N) return true;
        return false;
    }

    private static int[] colorPaint(int x, int y, int paintX, int paintY){
        int curX = x;
        int curY = y;
        int result = 0;
        while(isWithinRange(curX, curY) && c[curY][curX] == '*'){
            curX += paintX;
            curY += paintY;
            result += 1;
        }

        return new int[]{curX, curY, result};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        c = new char[N][];

        for(int i = 0; i < N; i++){
            c[i] = br.readLine().toCharArray();
        }


        int startX = 0, startY = 0;
        Loop1:
        for(int i =0 ; i< N; i++){
            for(int j =0 ; j < N; j++){
              if(c[i][j] == '*'){
                  startX = j;
                  startY = i;
                  break Loop1;
              }
            }
        }
        startY += 1;
        // 심장 위치
        builder.append(startY + 1).append(" ").append(startX + 1).append("\n");
        int[] answer = new int[5];

        int[] res = new int[3];
        // 왼쪽
        res = colorPaint(startX - 1, startY, -1, 0);
        answer[0] = res[2];
        // 오른쪽 팔
        res = colorPaint(startX + 1, startY, 1, 0);
        answer[1] = res[2];
        // 허리
        res = colorPaint(startX, startY + 1, 0, 1);
        answer[2] = res[2];
        startX = res[0];
        startY = res[1] - 1;
        // 왼쪽 다리
        res = colorPaint(startX - 1, startY + 1, 0, 1);
        answer[3] = res[2];
        // 오른쪽 다리
        res = colorPaint(startX + 1, startY + 1, 0, 1);
        answer[4] = res[2];

        for(int i = 0; i < 4; i++){
            builder.append(answer[i]).append(" ");
        }
        builder.append(answer[4]);

        System.out.println(builder.toString());
        br.close();
    }
}
