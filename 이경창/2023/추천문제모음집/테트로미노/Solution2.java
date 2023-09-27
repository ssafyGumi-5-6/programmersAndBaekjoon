package 테트로미노;

import java.util.*;
import java.io.*;

public class Solution2 {
    private static int N, M;
    private static int[][] arr;
    private static int[] dx = {-1 ,0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int answer;
    private static boolean[][] visited;

    private static boolean isWithInRange(int x, int y){
        if(0 <= x && 0 <= y && x < M && y < N) return true;
        else return false;
    }

    // 크기 4만큼 백트래킹
    private static void backtracking(int x, int y, int cnt, int sum){

//        System.out.println(Arrays.deepToString(visited));
        answer = Math.max(answer, sum);
//        System.out.println(y + " " + x + " cnt : " + cnt + " sum : " + sum);
        if(cnt == 4){
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(isWithInRange(nx, ny)){
                if(visited[ny][nx]) continue;
                visited[ny][nx] = true;
                backtracking(nx, ny, cnt + 1, sum + arr[ny][nx]);
                visited[ny][nx] = false;
            }
        }
    }

    private static void exceptToUpOrDownOrLeftOrRight(int x, int y){
        int sum = arr[y][x];
        int count = 0;
        int minData = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(isWithInRange(nx, ny)){
                sum += arr[ny][nx];
                count++;
                minData = Math.min(minData, arr[ny][nx]);
            }
        }

        if(count == 4) sum -= minData;
        answer = Math.max(answer, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < M; j++){
                int num = Integer.parseInt(tokenizer.nextToken());
                arr[i][j] = num;
            }
        }

        for(int i = 0; i< N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = true;
                backtracking(j, i, 1, arr[i][j]);
                exceptToUpOrDownOrLeftOrRight(j, i);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);

    }
}
