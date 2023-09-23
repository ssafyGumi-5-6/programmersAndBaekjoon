package 숫자_정사각형;

import java.io.*;
import java.util.*;

public class Solution4 {

    private static int N, M;
    private static char[][] arr;
    private static int[][] dxy1 = {{-1, 1}, {0, 1}, {1, 1}};
    private static int[][] dxy2 = {{0, 1}, {1, 1}, {1, 0}};

    private static boolean withInRange(int x, int y){
        if(0 <= y && 0 <= x && y < N && x < M) return true;
        else return false;
    }

    private static boolean straight(int size, int x, int y){
        System.out.println("size : " + size);
        System.out.println("시작위치 : " + x + " " + y);
        for(int[] inDxy : dxy1){
            int nextY = inDxy[1] * size;
            int nextX = inDxy[0] * size;
            System.out.println(nextX + " " + nextY);
            if(!withInRange(nextX, nextY)) return false;
            if(arr[y][x] != arr[nextY][nextX]) return false;
        }
        return true;
    }

    private static boolean diagonally(int size, int x, int y) {
        for (int[] inDxy : dxy2) {
            int nextY = inDxy[1] * size;
            int nextX = inDxy[0] * size;
            System.out.println(nextX + " " + nextY);
            if(!withInRange(nextX, nextY)) return false;
            if (arr[y][x] != arr[nextY][nextX]) return false;
        }
        return true;
    }

        public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        arr = new char[N][M];

        for(int i = 0; i < N ; i++){
            char[] c = reader.readLine().toCharArray();
            arr[i] = c;
        }

        int minData = Math.min(N, M);
        int result = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int k = 1; k <= minData; k++){
                    if(straight(k, j, i) || diagonally(k, j, i)){

                        result = Math.max(result, k * k);
                    }
                }
            }
        }

        System.out.println(result);

        reader.close();
    }
}
