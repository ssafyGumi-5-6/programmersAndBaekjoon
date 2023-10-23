package 벽_부수고_이동하기;

import java.io.*;
import java.util.*;

public class Solution {

    private static class Node{
        public final int x;
        public final int y;
        public final int wallBreakCount;

        Node(int x, int y, int wallBreakCount){
            this.x = x;
            this.y = y;
            this.wallBreakCount = wallBreakCount;
        }
    }

    private static int N, M;
    private static int[][][] arr;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    private static boolean isWithInRange(int row, int col){
        return 0 <= row && 0 <= col && row < N && col < M;
    }

    private static void printArr(){
        for(int i = 0; i < 2; i++){
            for(int r = 0; r < N; r++){
                System.out.println(Arrays.toString(arr[i][r]));
            }
            System.out.println();
        }
        System.out.println();

    }
    private static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));
        arr[0][0][0] = 1;
        arr[1][0][0] = 1;

        while(queue.size() > 0){
            Node node = queue.poll();
            int wallBreakCount = node.wallBreakCount;

            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(isWithInRange(ny, nx) && arr[0][ny][nx] > 0 && arr[wallBreakCount][ny][nx] > arr[wallBreakCount][node.y][node.x] + 1){
                    arr[wallBreakCount][ny][nx] = arr[wallBreakCount][node.y][node.x] + 1;
                    queue.add(new Node(nx, ny, wallBreakCount));
                }else{
                    // 벽이 있어서 부수고 이동
                    if(isWithInRange(ny, nx) && arr[0][ny][nx] == -1){
                        for(int wallIdx = wallBreakCount + 1; wallIdx < 2; wallIdx++){
                            nx += dx[i];
                            ny += dy[i];

                            if(isWithInRange(ny, nx) && arr[0][ny][nx] > 0 && arr[wallIdx][ny][nx] > arr[wallBreakCount][node.y][node.x] + (wallIdx + 1)){
                                arr[wallIdx][ny][nx] = arr[wallBreakCount][node.y][node.x] + (wallIdx + 1);
                                queue.add(new Node(nx, ny, wallIdx));
                            }else if(!isWithInRange(ny, nx)){
                                // 이전으로 되돌리고
                                ny = node.y + 1;
                                nx = node.x + 1;

                                if(isWithInRange(ny, nx) && arr[wallIdx][ny][nx] > arr[wallBreakCount][node.y][node.x] + (wallIdx + 1)){
                                    arr[wallIdx][ny][nx] = arr[wallBreakCount][node.y][node.x] + (wallIdx + 1);
                                    queue.add(new Node(nx, ny, wallIdx));
                                }

                            }
                        }
                    }
                }
            }
        }

        int result = 1000100;
        for(int i = 0 ; i < 2; i++){
            if(result > arr[i][N - 1][M - 1]) result = arr[i][N - 1][M - 1];
        }

        return (result == 1000100 ? -1 : result);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        arr = new int[2][N][M];

        for(int i = 0; i < N; i++){
            char[] c = reader.readLine().toCharArray();

            for(int j = 0; j < M; j++){
                int number = (c[j] - '0') * -1;
                if(number == -1){
                    for(int k = 0; k < 2; k++) arr[k][i][j] = -1;
                }
                else{
                    for(int k = 0; k < 2; k++) arr[k][i][j] = 1000100;
                }
            }
        }

        System.out.println(bfs());


        reader.close();
    }
}
