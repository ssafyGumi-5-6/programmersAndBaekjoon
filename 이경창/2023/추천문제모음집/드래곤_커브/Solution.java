package 드래곤_커브;

/*
    끝점을 기준으로 90도 회전
    N세대 : N - 1세대 끝점을 기준으로 90도 회전하여 붙이면 된다.
    0세대 -> 끝점을 지점으로 바라보았을 때는 <-
* */

import java.io.*;
import java.util.*;

public class Solution {

    //N(1 ≤ N ≤ 20)이 주어진다. 둘째 줄부터 N개의 줄에는 드래곤 커브의 정보가 주어진다. 드래곤 커브의 정보는 네 정수 x, y, d, g
    private static int N;
    private static int x, y, d, g;

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        arr = new int[110][110];

        for(int tk = 1; tk <= N; tk++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            x = Integer.parseInt(tokenizer.nextToken());
            y = Integer.parseInt(tokenizer.nextToken());
            d = Integer.parseInt(tokenizer.nextToken());
            g = Integer.parseInt(tokenizer.nextToken());

            ArrayList<Integer> list = new ArrayList<>();
            // 0세대 일 때
            list.add(d);

            for(int generation = 1; generation <= g; generation++){

                // 다음 세대에서는 count * 2로 검토한다. (d 방향이 90도 회전 반대 방향)
                for(int gIdx = list.size() - 1; gIdx >= 0; gIdx--){
                    // 현재 인덱스
                    int index = (list.get(gIdx) + 1) % 4;
                    list.add(index);
                }
            }

            arr[y][x] = 1;
            for(int direction : list){
                x = x + dx[direction];
                y = y + dy[direction];
                arr[y][x] = 1;
            }

        }

        int answer = 0;
        for(int row = 0; row <= 100; row++){
            for(int col = 0; col <= 100; col++){
                if(arr[row][col] == 1
                        && arr[row + 1][col] == 1
                        && arr[row][col + 1] == 1
                        && arr[row + 1][col + 1] == 1){
                    answer += 1;
                }
            }
        }

//        for(int i = 0; i < 9 ;i++){
//            for(int j = 0; j < 6; j++){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(answer);

        reader.close();
    }
}
