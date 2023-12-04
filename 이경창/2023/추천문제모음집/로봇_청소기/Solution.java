package 로봇_청소기;

import java.io.*;
import java.util.*;

public class Solution {

    private static class Node {
        public final int x;
        public final int y;
        public final int d;

        Node(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    private static int N, M;
    private static int[][] arr;

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    private static int curX, curY;
    private static int d;

    private static boolean isWithInRange(int row, int col){
        return 0 <= row && 0 <= col && row < N && col < M;
    }
    private static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(curX, curY, d));

        while(queue.size() > 0){
            Node node = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;

                // 범위 이내라면
                if(!isWithInRange(ny, nx)) continue;

                // 
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());

        curY = Integer.parseInt(tokenizer.nextToken());
        curX = Integer.parseInt(tokenizer.nextToken());
        d = Integer.parseInt(tokenizer.nextToken());

        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        bfs();

        reader.close();
    }
}
