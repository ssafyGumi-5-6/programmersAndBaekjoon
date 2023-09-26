package 토마토;

import java.util.*;
import java.io.*;

public class Solution2 {

    private static class Node{
        public final int x;
        public final int y;
        public final int z;
        public final int day;

        public Node(int x, int y, int z, int day){
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }

//        public Node add(int x, int y, int z, int day){
//            return new Node(x, y, z, this.day + day);
//        }
    }

    // N : 세로, M : 가로, H : 높이
    private static int N,M,H;
    private static int[][][] arr;
    private static int[][] dxyz = {{-1, 0, 0}, {0, -1, 0}, {1, 0, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};

    private static boolean isWithRange(int x, int y, int z){
        if(0 <= x && 0 <= y && 0 <= z && x < M && y < N && z < H) return true;
        else return false;
    }
    private static int bfs(Queue<Node> queue){
        int finalDay = 0;

        while(queue.size() > 0){
            Node node = queue.poll();
            if(finalDay < node.day) finalDay = node.day;

            for(int i = 0; i < 6; i++){
                int nx = dxyz[i][0] + node.x;
                int ny = dxyz[i][1] + node.y;
                int nz = dxyz[i][2] + node.z;

                if(isWithRange(nx, ny, nz)){

                    if(arr[nz][ny][nx] == -1 || arr[nz][ny][nx] == 1) continue;
                    arr[nz][ny][nx] = 1;
                    queue.add(new Node(nx, ny, nz, node.day + 1));
                }
            }
        }

        return finalDay;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        M = Integer.parseInt(tokenizer.nextToken());
        N = Integer.parseInt(tokenizer.nextToken());
        H = Integer.parseInt(tokenizer.nextToken());
        arr = new int[H][N][M];

        Queue<Node> queue = new LinkedList<>();

        for(int i = 0 ; i < N * H; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < M; j++){
//                System.out.println("높이 : " + (i / H) + " 행 : " + (i % N) + " 열 : " + j);
                arr[i / N][i % N][j] = Integer.parseInt(tokenizer.nextToken());

                if(arr[i / N][i % N][j] == 1) queue.add(new Node(j, i % N, i/ N, 0));
            }
        }

        int finalDay = bfs(queue);
//        for(int i = 0 ; i < N * H ; i++){
//            for(int j = 0; j < M ; j++){
//                System.out.print(arr[i / N][i % N][j] + " ");
//            }
//            System.out.println();
//        }
        Loop1:
        for(int i = 0; i < N * H; i++){
            for(int j = 0; j < M; j++){
                if(arr[i / N][i % N][j] == 0){
                    finalDay = -1;
                    break Loop1;
                }
            }
        }

        System.out.println(finalDay);

        reader.close();
    }
}
