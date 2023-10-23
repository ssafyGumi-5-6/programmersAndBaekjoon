package 말이_되고픈_원숭이;

import java.util.*;
import java.io.*;

public class Solution {

    private static class Node{
        public final int x;
        public final int y;
        public final int activeCnt;

        Node(int x, int y, int activeCnt){
            this.x  = x;
            this.y  = y;
            this.activeCnt = activeCnt;
        }
    }
    private static int K, W, H;
    private static int[][][] arr;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    private static int[][] horseJumping = {
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
    };

    private static boolean isWithInRange(int row, int col){
        return 0 <= row && 0 <= col && row < H && col < W && arr[0][row][col] != -1;
    }
    private static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0 ,0,0));
        arr[0][0][0] = 0;

        while(queue.size() > 0){
            Node node = queue.poll();
            int horseJumpingCnt = node.activeCnt;

            if(node.y == H - 1 && node.x == W - 1){
                break;
            }

            // (1) 현재 상하좌우 이동 가능할 때
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;

                if(isWithInRange(ny, nx) && arr[horseJumpingCnt][ny][nx] > arr[horseJumpingCnt][node.y][node.x] + 1){
                    arr[horseJumpingCnt][ny][nx] = arr[horseJumpingCnt][node.y][node.x] + 1;
                    queue.add(new Node(nx, ny, horseJumpingCnt));
                }
            }

            // (2) 원숭이가 말 점프 가능할 때
            if(horseJumpingCnt + 1 <= K){
//                System.out.println(node.y + " " + node.x + " " + (arr[horseJumpingCnt][node.y][node.x]));
                for(int i = 0; i < 8; i++){
                    int nx = horseJumping[i][0] + node.x;
                    int ny = horseJumping[i][1] + node.y;

                    if(isWithInRange(ny, nx) && arr[horseJumpingCnt + 1][ny][nx] > arr[horseJumpingCnt][node.y][node.x] + 1){
//                        System.out.println(ny + " " + nx + "로 점프");
                        arr[horseJumpingCnt + 1][ny][nx] = arr[horseJumpingCnt][node.y][node.x] + 1;
                        queue.add(new Node(nx, ny, horseJumpingCnt + 1));
                    }
                }
            }
        }

        int result = 40010;
//        for(int i = 0; i <= K; i++){
//            for(int r = 0; r < H; r++){
//                System.out.println(Arrays.toString(arr[i][r]));
//            }
//            System.out.println();
//        }
        for(int i = 0; i <= K; i++){
            if(result > arr[i][H - 1][W - 1]) result = arr[i][H - 1][W - 1];
        }

        return (result == 40010 ? -1 : result);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        W = Integer.parseInt(tokenizer.nextToken());
        H = Integer.parseInt(tokenizer.nextToken());

        arr = new int[K + 1][H][W];
        // 40010
//        for(int i = 0; i < K; i++){
//            for(int r = 0; r < H; r++){
//                for(int w = 0; w < W; w++){
//                    arr[i][r][w] = 40010;
//                }
//            }
//        }

        // -1 : 장애물
        // 자연수 : 평지
        for(int i = 0; i < H; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < W; j++){
                int number = Integer.parseInt(tokenizer.nextToken());
                if(number == 1){
                    for(int k = 0; k <= K; k++){
                        arr[k][i][j] = -1;
                    }
                }else{
                    for(int k = 0; k <= K; k++){
                        arr[k][i][j] = 40010;
                    }
                }
            }
        }

        System.out.println(bfs());


        reader.close();
    }
}
