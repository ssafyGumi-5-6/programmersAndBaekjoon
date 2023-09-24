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

    // 정사각형
    private static boolean straight(int size, int x, int y){
//        System.out.println("정사각형 탐지, size : " + size);
//        System.out.println("시작지점 : " + y + " " + x);
        for(int[] inDxy : dxy2){
            int nextX = inDxy[0] * size + x;
            int nextY = inDxy[1] * size + y;

//            System.out.println("nextX : " + nextX + " nextY : " + nextY);
            if(!withInRange(nextX, nextY)) return false;
            if(arr[y][x] != arr[nextY][nextX]) return false;
        }
        return true;
    }


    // 마름모
//    private static boolean diagonally(int size, int x, int y) {
////        System.out.println("마름모 탐지, size : " + size);
//        for (int[] inDxy : dxy) {
//            int nextX = inDxy[0] * size + x;
//            int nextY = inDxy[1] * size + y;
//
////            System.out.println("nextX : " + nextX + " nextY : " + nextY);
//            if(!withInRange(nextX, nextY)) return false;
//            if (arr[y][x] != arr[nextY][nextX]) return false;
//        }
//        return true;
//    }

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
//                System.out.println("행 : " + i + " 열 : " + j);
                for(int k = 1; k <= minData; k++){
//                    System.out.println("k : " + k);
                    if(straight(k, j, i)){
                        result = Math.max(result, (k + 1) * (k + 1));
                    }
                }
//                System.out.println();
            }
        }

        System.out.println(result);

        reader.close();
    }
}
